package ru.mrkurilin.mrKurilinCore.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.mrkurilin.featureTemplate.di.TemplateFeatureComponent
import ru.mrkurilin.mrKurilinCore.di.qualifiers.ApplicationContext
import ru.mrkurilin.mrKurilinCore.di.scopes.AppScope
import ru.mrkurilin.mrKurilinCore.di.modules.NetworkModule
import ru.mrkurilin.mrKurilinCore.di.modules.SubComponentsModule

@AppScope
@Component(
    modules = [
        SubComponentsModule::class,
        NetworkModule::class,
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance
            @ApplicationContext
            context: Context,
        ): AppComponent
    }

    fun templateFeatureComponentFactory(): TemplateFeatureComponent.Factory
}