package com.baltsarak.data.di

import com.baltsarak.data.TicketRepositoryImpl
import com.baltsarak.domain.TicketRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindRepository(repositoryImpl: TicketRepositoryImpl): TicketRepository
}