package mmazzola.moneyminder.main

import dagger.Module
import dagger.Provides
import mmazzola.moneyminder.rx.SchedulerFacade

@Module
class MainModule {

    @Provides
    fun provideMainPresenter(
        view: MainContract.View,
        loadCategoriesUseCase: LoadCategoriesUseCase,
        saveCategoryUseCase: SaveCategoryUseCase,
        schedulerFacade: SchedulerFacade
    ) = MainActivityPresenter(view, loadCategoriesUseCase, saveCategoryUseCase,schedulerFacade)
}