package ru.mrkurilin.mrKurilinCore

import android.app.Application
import ru.mrkurilin.mrKurilinCore.di.AppComponent
import ru.mrkurilin.mrKurilinCore.di.DaggerAppComponent
import ru.mrkurilin.mrKurilinCore.di.SubComponentsProviderImpl
import ru.mrkurilin.mrKurilinCore.di.api.SubComponentsProvider
import ru.mrkurilin.mrKurilinCore.di.api.SubComponentsProviderProvider

class App : Application(), SubComponentsProviderProvider {

    private lateinit var appComponent: AppComponent
    private lateinit var subComponentsProviderImpl: SubComponentsProvider

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory().create(
            context = this
        )
        subComponentsProviderImpl = SubComponentsProviderImpl(appComponent)
    }

    override fun getSubComponentsProvider(): SubComponentsProvider {
        return subComponentsProviderImpl
    }
}