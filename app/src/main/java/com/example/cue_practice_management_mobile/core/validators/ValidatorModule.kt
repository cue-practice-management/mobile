package com.example.cue_practice_management_mobile.core.validators

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ValidatorModule {

    @Provides
    fun provideRequiredValidator(): RequiredValidator = RequiredValidator()

    @Provides
    fun provideEmailValidator(): EmailValidator = EmailValidator()

    @Provides
    fun providePasswordValidator(): PasswordValidator = PasswordValidator()

}