package mmazzola.moneyminder

import android.app.Application
import mmazzola.moneyminder.dagger.AppComponent
import mmazzola.moneyminder.dagger.AppModule
import mmazzola.moneyminder.dagger.DaggerAppComponent
import mmazzola.moneyminder.dagger.PresenterModule

class MoneyMinderApplication : Application() {

    lateinit var moneyMinderComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        moneyMinderComponent = initDagger(this)
    }

    private fun initDagger(app: MoneyMinderApplication): AppComponent =
        DaggerAppComponent.builder().appModule(AppModule(app)).presenterModule(PresenterModule()).build()
}