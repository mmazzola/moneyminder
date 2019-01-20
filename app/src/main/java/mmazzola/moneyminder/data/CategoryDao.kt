package mmazzola.moneyminder.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert

@Dao
interface CategoryDao {

    @Insert
    fun insert(category:CategoryEntity)

    @Delete
    fun delete(category:CategoryEntity)
}