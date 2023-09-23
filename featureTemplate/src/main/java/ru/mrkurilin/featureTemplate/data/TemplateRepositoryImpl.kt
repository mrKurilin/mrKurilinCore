package ru.mrkurilin.featureTemplate.data

import ru.mrkurilin.featureTemplate.di.TemplateFeatureScope
import ru.mrkurilin.featureTemplate.domain.repository.TemplateRepository
import javax.inject.Inject

@TemplateFeatureScope
class TemplateRepositoryImpl @Inject constructor() : TemplateRepository