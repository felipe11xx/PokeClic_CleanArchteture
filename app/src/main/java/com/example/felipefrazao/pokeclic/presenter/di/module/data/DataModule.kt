package br.com.ciclic.presentation.di.module.data

import com.example.felipefrazao.pokeclic.data.repository.CardRepositoryImpl
import com.example.felipefrazao.pokeclic.data.repository.retrofit.CardClient
import com.example.felipefrazao.pokeclic.domain.repository.CardRepository

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named

@Module
class DataModule {

    @Provides
    fun provideCardRepository(cardRepository: CardRepositoryImpl): CardRepository{
        return cardRepository
    }


}