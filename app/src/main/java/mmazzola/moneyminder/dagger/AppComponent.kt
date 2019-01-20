package mmazzola.moneyminder.dagger

import dagger.Component
import mmazzola.moneyminder.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, PresenterModule::class])
interface AppComponent {

    fun inject(target: MainActivity)
}