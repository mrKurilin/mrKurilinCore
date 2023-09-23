package ru.mrkurilin.mrKurilinCore.di

import ru.mrkurilin.featureTemplate.di.TemplateFeatureComponent
import ru.mrkurilin.featureTemplate.di.TemplateFeatureComponentProvider
import ru.mrkurilin.mrKurilinCore.di.api.SubComponentsProvider

class SubComponentsProviderImpl(
    private val appComponent: AppComponent
) : SubComponentsProvider,
    TemplateFeatureComponentProvider {

    override fun provideTemplateFeatureComponent(): TemplateFeatureComponent {
        return appComponent.templateFeatureComponentFactory().create()
    }
}