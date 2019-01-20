package mmazzola.moneyminder.main

import dagger.Binds
import dagger.Module

@Module
abstract class MainViewModule {

    @Binds
    abstract fun provideMainView(mainActivity: MainActivity) : MainContract.View
}