package mmazzola.moneyminder.dagger

import dagger.Module
import dagger.Provides
import mmazzola.moneyminder.category.CategoryActivityPresenter
import mmazzola.moneyminder.category.CategoryContract
import mmazzola.moneyminder.main.LoadCategoriesUseCase
import mmazzola.moneyminder.main.MainActivityPresenter
import mmazzola.moneyminder.main.MainContract
import mmazzola.moneyminder.main.SaveCategoryUseCase
import mmazzola.moneyminder.rx.SchedulerFacade

@Module
class PresentersModule {

    @Provides
    fun provideMainPresenter(
        view: MainContract.View,
        loadCategoriesUseCase: LoadCategoriesUseCase,
        schedulerFacade: SchedulerFacade
    ) = MainActivityPresenter(
        view,
        loadCategoriesUseCase,
        schedulerFacade
    )


    @Provides
    fun provideCategoryPresenter(
        view: CategoryContract.View,
        saveCategoryUseCase: SaveCategoryUseCase,
        schedulerFacade: SchedulerFacade
    ) = CategoryActivityPresenter(
        view,
        saveCategoryUseCase,
        schedulerFacade
    )
}