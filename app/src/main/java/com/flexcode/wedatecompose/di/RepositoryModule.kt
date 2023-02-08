package com.flexcode.wedatecompose.di

import com.flexcode.wedate.common.data.LogService
import com.flexcode.wedate.common.data.LogServiceImpl
import com.flexcode.wedate.auth.data.repository.AuthRepositoryImpl
import com.flexcode.wedate.auth.domain.repository.AuthRepository
import com.flexcode.wedate.home.data.repository.HomeRepositoryImpl
import com.flexcode.wedate.home.domain.repository.HomeRepository
import com.flexcode.wedate.matches.data.repository.MatchesRepositoryImpl
import com.flexcode.wedate.matches.domain.repository.MatchesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds abstract fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository

    @Binds abstract fun provideLogService(impl: LogServiceImpl): LogService

    @Binds
    abstract fun providesHomeRepository(impl: HomeRepositoryImpl): HomeRepository

    @Binds
    abstract fun providesMatchesRepository(impl: MatchesRepositoryImpl): MatchesRepository



}