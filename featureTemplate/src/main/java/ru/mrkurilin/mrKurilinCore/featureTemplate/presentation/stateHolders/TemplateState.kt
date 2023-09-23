package ru.mrkurilin.mrKurilinCore.featureTemplate.presentation.stateHolders

sealed class TemplateState {

    data object Loading : TemplateState()

    data object Loaded : TemplateState()
}