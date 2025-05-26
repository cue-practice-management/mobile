package com.example.cue_practice_management_mobile.features.auth

import com.example.cue_practice_management_mobile.features.auth.repositories.AuthRepository
import com.example.cue_practice_management_mobile.features.auth.repositories.AuthRepositoryImpl
import com.example.cue_practice_management_mobile.features.auth.services.AuthService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthModule {

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        impl: AuthRepositoryImpl
    ): AuthRepository


}