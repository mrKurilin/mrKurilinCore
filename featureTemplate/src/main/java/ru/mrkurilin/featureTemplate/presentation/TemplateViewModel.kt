package ru.mrkurilin.featureTemplate.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import ru.mrkurilin.featureTemplate.presentation.stateHolders.TemplateAction
import ru.mrkurilin.featureTemplate.presentation.stateHolders.TemplateEffect
import ru.mrkurilin.featureTemplate.presentation.stateHolders.TemplateEvent
import ru.mrkurilin.featureTemplate.presentation.stateHolders.TemplateState
import javax.inject.Inject

class TemplateViewModel @Inject constructor() : ViewModel() {

    private val _templateState: MutableStateFlow<TemplateState> =
        MutableStateFlow(TemplateState.Loading)
    val templateState: StateFlow<TemplateState> = _templateState.asStateFlow()

    private val _templateEffectFlow: Channel<TemplateEffect> = Channel(Channel.BUFFERED)
    val effectFlow = _templateEffectFlow.receiveAsFlow()

    fun onAction(templateAction: TemplateAction) {
        viewModelScope.launch {
            when (templateAction) {
                else -> {}
            }
        }
    }

    fun onEvent(templateEvent: TemplateEvent) {
        viewModelScope.launch {
            when (templateEvent) {
                else -> {}
            }
        }
    }
}