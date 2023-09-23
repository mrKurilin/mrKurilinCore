package ru.mrkurilin.mrKurilinCore.di.modules

import dagger.Module
import ru.mrkurilin.featureTemplate.di.TemplateFeatureComponent

@Module(
    subcomponents = [
        TemplateFeatureComponent::class,
    ]
)
class SubComponentsModule