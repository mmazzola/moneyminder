package mmazzola.moneyminder.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Single

@Dao
interface CategoryDao {

    @Insert
    fun insert(category:CategoryEntity)

    @Delete
    fun delete(category:CategoryEntity)

    @Query("SELECT * FROM CategoryEntity")
    fun selectAll() : Single<List<CategoryEntity>>
}