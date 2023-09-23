package ru.mrkurilin.mrKurilinCore.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import ru.mrkurilin.mrKurilinCore.di.api.SubComponentsProvider
import ru.mrkurilin.mrKurilinCore.di.api.SubComponentsProviderProvider

fun Fragment.requireSubComponentsProvider(): SubComponentsProvider {
    return (requireActivity().application as? SubComponentsProviderProvider)
        ?.getSubComponentsProvider() ?: error(
        "application should impement SubComponentsProviderProvider"
    )
}

inline fun <reified T : ViewModel> Fragment.lazyViewModel(
    noinline create: () -> T,
): Lazy<T> {
    return viewModels {
        ViewModelFactory(this, create)
    }
}