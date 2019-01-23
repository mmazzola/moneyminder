package mmazzola.moneyminder.dagger

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mmazzola.moneyminder.category.CategoryActivity
import mmazzola.moneyminder.main.MainActivity

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [ViewModule::class, PresentersModule::class])
    abstract fun bindMainActivity() : MainActivity

    @ContributesAndroidInjector(modules = [ViewModule::class, PresentersModule::class])
    abstract fun bindCategoryActivity() : CategoryActivity

}