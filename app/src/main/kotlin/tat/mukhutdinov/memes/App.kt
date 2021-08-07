package tat.mukhutdinov.memes

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import tat.mukhutdinov.memes.infrastructure.InfrastructureModule
import tat.mukhutdinov.memes.list.ListModule
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        setupTimber()

        setupKoin()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@App)

            modules(
                InfrastructureModule.module,
                ListModule.module
            )
        }
    }
}