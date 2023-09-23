package ru.mrkurilin.featureTemplate.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.mrkurilin.featureTemplate.data.TemplateRepositoryImpl
import ru.mrkurilin.featureTemplate.data.remote.service.TemplateApiService
import ru.mrkurilin.featureTemplate.domain.repository.TemplateRepository

@Module
interface TemplateFeatureModule {

    @Binds
    @TemplateFeatureScope
    fun provideTemplateRepository(
        templateRepositoryImpl: TemplateRepositoryImpl
    ): TemplateRepository

    companion object {
        @Provides
        @TemplateFeatureScope
        fun provideTemplateApiService(retrofit: Retrofit): TemplateApiService {
            return retrofit.create(TemplateApiService::class.java)
        }
    }
}