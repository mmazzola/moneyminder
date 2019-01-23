package mmazzola.moneyminder.dagger

import dagger.Binds
import dagger.Module
import mmazzola.moneyminder.category.CategoryActivity
import mmazzola.moneyminder.category.CategoryContract
import mmazzola.moneyminder.main.MainActivity
import mmazzola.moneyminder.main.MainContract

@Module
abstract class ViewModule {

    @Binds
    abstract fun provideMainView(mainActivity: MainActivity) : MainContract.View

    @Binds
    abstract fun provideCategoryView(categoryActivity: CategoryActivity) : CategoryContract.View
}