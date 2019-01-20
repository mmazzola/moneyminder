package mmazzola.moneyminder.repository

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import mmazzola.moneyminder.data.CategoryDao
import mmazzola.moneyminder.data.CategoryEntity

@Database(entities = [CategoryEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    abstract fun getCategoryDao() : CategoryDao
}