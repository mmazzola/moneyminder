package mmazzola.moneyminder.repository

import io.reactivex.Completable
import io.reactivex.Single
import mmazzola.moneyminder.data.CategoryEntity

interface CategoryRepository {

    fun addCategory(category : CategoryEntity) : Completable

    fun loadCategories() : Single<List<CategoryEntity>>
}