package com.ohp.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class SampleModule {

    @Singleton
    @Provides
    @Named("SomeString")
    fun provideSomeString() = "Hello World"
}