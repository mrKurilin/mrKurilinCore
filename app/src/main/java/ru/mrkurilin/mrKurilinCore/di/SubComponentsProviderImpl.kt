package ru.mrkurilin.mrKurilinCore.di

import ru.mrkurilin.mrKurilinCore.di.api.SubComponentsProvider
import ru.mrkurilin.mrKurilinCore.featureTemplate.di.TemplateFeatureComponent
import ru.mrkurilin.mrKurilinCore.featureTemplate.di.TemplateFeatureComponentProvider

class SubComponentsProviderImpl(
    private val appComponent: AppComponent
) : SubComponentsProvider,
    TemplateFeatureComponentProvider {

    override fun provideTemplateFeatureComponent(): TemplateFeatureComponent {
        return appComponent.templateFeatureComponentFactory().create()
    }
}