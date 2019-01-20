package mmazzola.moneyminder.dagger

import android.app.Application
import android.arch.persistence.room.Room
import mmazzola.moneyminder.data.CategoryDao
import mmazzola.moneyminder.repository.AppDatabase
import mmazzola.moneyminder.repository.CategoryDataSource
import mmazzola.moneyminder.repository.CategoryRepository

class DataModule(private val app: Application) {

    fun provideDatabase(): AppDatabase = Room.databaseBuilder(
        app,
        AppDatabase::class.java, "moneyminder-db"
    ).build()


    fun provideCategoryDao(appDatabase: AppDatabase) : CategoryDao = appDatabase.getCategoryDao()

    fun categoryRepository(categoryDao: CategoryDao): CategoryRepository = CategoryDataSource(categoryDao)
}