package com.example.cue_practice_management_mobile.config.di

import com.example.cue_practice_management_mobile.domain.repositories.AuthRepository
import com.example.cue_practice_management_mobile.core.data.repositories.AuthRepositoryImpl
import com.example.cue_practice_management_mobile.core.data.repositories.ProfessorRepositoryImpl
import com.example.cue_practice_management_mobile.core.data.repositories.StudentRepositoryImpl
import com.example.cue_practice_management_mobile.domain.repositories.ProfessorRepository
import com.example.cue_practice_management_mobile.domain.repositories.StudentRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        impl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindStudentRepository(
        impl: StudentRepositoryImpl
    ): StudentRepository

    @Binds
    @Singleton
    abstract fun bindProfessorRepository(
        impl: ProfessorRepositoryImpl
    ): ProfessorRepository
}