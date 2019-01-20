package mmazzola.moneyminder.dagger

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mmazzola.moneyminder.main.MainActivity
import mmazzola.moneyminder.main.MainModule
import mmazzola.moneyminder.main.MainViewModule

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [MainViewModule::class, MainModule::class])
    abstract fun bindMainActivity() : MainActivity

}