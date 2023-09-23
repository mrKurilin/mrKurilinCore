package ru.mrkurilin.mrKurilinCore.featureTemplate.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.mrkurilin.mrKurilinCore.di.lazyViewModel
import ru.mrkurilin.mrKurilinCore.di.requireSubComponentsProvider
import ru.mrkurilin.mrKurilinCore.featureTemplate.R
import ru.mrkurilin.mrKurilinCore.featureTemplate.di.TemplateFeatureComponentProvider
import ru.mrkurilin.mrKurilinCore.featureTemplate.presentation.stateHolders.TemplateState

class TemplateFragment : Fragment(R.layout.fragment_template) {

    private val templateViewModel: TemplateViewModel by lazyViewModel {
        (requireSubComponentsProvider() as TemplateFeatureComponentProvider)
            .provideTemplateFeatureComponent().templateViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            launch {
                observeState()
            }
            launch {
                observeEffect()
            }
        }
    }

    private suspend fun observeEffect() {
        templateViewModel.effectFlow.collect { effect ->
            when (effect) {
                else -> {}
            }
        }
    }

    private suspend fun observeState() {
        templateViewModel.templateState.collect { state ->
            when (state) {
                is TemplateState.Loaded -> {
                }

                TemplateState.Loading -> {
                }
            }
        }
    }
}