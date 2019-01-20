package mmazzola.moneyminder.dagger

import dagger.Module
import dagger.Provides
import mmazzola.moneyminder.main.MainActivityPresenter
import mmazzola.moneyminder.main.MainContract
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun provideMainActivityPresenter(): MainContract.Presenter = MainActivityPresenter()
}