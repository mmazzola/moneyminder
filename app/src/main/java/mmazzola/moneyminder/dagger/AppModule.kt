package mmazzola.moneyminder.dagger

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import mmazzola.moneyminder.MoneyMinderApplication
import mmazzola.moneyminder.data.CategoryDao
import mmazzola.moneyminder.repository.AppDatabase
import mmazzola.moneyminder.repository.CategoryDataSource
import mmazzola.moneyminder.repository.CategoryRepository
import javax.inject.Singleton

@Module
class AppModule{

    @Singleton
    @Provides
    fun provideContext(app : MoneyMinderApplication) : Context = app.applicationContext

    @Singleton
    @Provides
    fun provideDatabase(app:MoneyMinderApplication): AppDatabase = Room.databaseBuilder(
        app,
        AppDatabase::class.java, "moneyminder-db"
    ).build()

    @Provides
    fun provideCategoryDao(appDatabase: AppDatabase) : CategoryDao = appDatabase.getCategoryDao()

    @Provides
    @Singleton
    fun categoryRepository(categoryDao: CategoryDao): CategoryRepository = CategoryDataSource(categoryDao)
}