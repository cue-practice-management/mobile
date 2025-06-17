package com.example.cue_practice_management_mobile.config.di

import com.example.cue_practice_management_mobile.config.network.AuthInterceptor
import com.example.cue_practice_management_mobile.core.data.api.AuthService
import com.example.cue_practice_management_mobile.config.network.TokenAuthenticator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AppRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthRetrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "http://10.0.2.2:3000/api/"

    @Provides
    @Singleton
    fun provideCookieJar(): JavaNetCookieJar {
        return JavaNetCookieJar(CookieManager().apply {
            setCookiePolicy(CookiePolicy.ACCEPT_ALL)
        })
    }

    @AuthRetrofit
    @Provides
    @Singleton
    fun provideAuthRetrofit(
        cookieJar: JavaNetCookieJar
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(
            OkHttpClient.Builder()
                .cookieJar(cookieJar)
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @AppRetrofit
    @Provides
    @Singleton
    fun provideAppRetrofit(
        authInterceptor: AuthInterceptor,
        tokenAuthenticator: TokenAuthenticator,
        cookieJar: JavaNetCookieJar
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(
            OkHttpClient.Builder()
                .addInterceptor(authInterceptor)
                .authenticator(tokenAuthenticator)
                .cookieJar(cookieJar)
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideAuthService(
        @AuthRetrofit retrofit: Retrofit
    ): AuthService = retrofit.create(AuthService::class.java)


}
