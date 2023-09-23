package ru.mrkurilin.mrKurilinCore.featureTemplate.data

import ru.mrkurilin.mrKurilinCore.featureTemplate.di.TemplateFeatureScope
import ru.mrkurilin.mrKurilinCore.featureTemplate.domain.repository.TemplateRepository
import javax.inject.Inject

@TemplateFeatureScope
class TemplateRepositoryImpl @Inject constructor() : TemplateRepository