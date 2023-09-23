package ru.mrkurilin.mrKurilinCore.featureTemplate.di

import dagger.Subcomponent
import ru.mrkurilin.mrKurilinCore.featureTemplate.presentation.TemplateViewModel

@TemplateFeatureScope
@Subcomponent(
    modules = [
        TemplateFeatureModule::class
    ]
)
interface TemplateFeatureComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): TemplateFeatureComponent
    }

    fun templateViewModel(): TemplateViewModel
}