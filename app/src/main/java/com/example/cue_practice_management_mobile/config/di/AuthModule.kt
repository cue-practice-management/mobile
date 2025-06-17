package com.example.cue_practice_management_mobile.config.di

import com.example.cue_practice_management_mobile.domain.repositories.AuthRepository
import com.example.cue_practice_management_mobile.core.data.repositories.AuthRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        impl: AuthRepositoryImpl
    ): AuthRepository

}