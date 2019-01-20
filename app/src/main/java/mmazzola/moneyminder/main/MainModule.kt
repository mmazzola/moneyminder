package mmazzola.moneyminder.main

import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun provideMainPresenter(view : MainContract.View) = MainActivityPresenter(view)
}