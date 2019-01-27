package mmazzola.moneyminder.dagger

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
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
class AppModule {

    lateinit var appDb: AppDatabase

    @Singleton
    @Provides
    fun provideContext(app: MoneyMinderApplication): Context = app.applicationContext

    @Singleton
    @Provides
    fun provideDatabase(app: MoneyMinderApplication): AppDatabase {
        appDb = Room.databaseBuilder(
            app,
            AppDatabase::class.java, "moneyminder-db"
        ).addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                //DB pre-init if needed
            }
        }).build()
        return appDb
    }

    @Provides
    fun provideCategoryDao(appDatabase: AppDatabase): CategoryDao = appDatabase.getCategoryDao()

    @Provides
    @Singleton
    fun categoryRepository(categoryDao: CategoryDao): CategoryRepository = CategoryDataSource(categoryDao)
}