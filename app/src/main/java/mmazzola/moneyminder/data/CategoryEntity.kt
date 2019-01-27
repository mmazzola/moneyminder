package mmazzola.moneyminder.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class CategoryEntity(
    @ColumnInfo(name = "title") var title: String = "",
    @ColumnInfo(name = "imageUrl") var imageUrl: String = ""
)
{
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}
