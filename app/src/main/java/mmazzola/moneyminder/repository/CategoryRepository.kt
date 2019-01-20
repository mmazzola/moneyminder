package mmazzola.moneyminder.repository

import mmazzola.moneyminder.data.CategoryEntity

interface CategoryRepository {

    fun addCategory(category : CategoryEntity)
}