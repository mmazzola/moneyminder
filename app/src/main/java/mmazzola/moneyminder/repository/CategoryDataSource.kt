package mmazzola.moneyminder.repository

import mmazzola.moneyminder.data.CategoryDao
import mmazzola.moneyminder.data.CategoryEntity
import javax.inject.Inject

class CategoryDataSource @Inject constructor(var categoryDao: CategoryDao) : CategoryRepository {

    override fun addCategory(category : CategoryEntity)
    {
        categoryDao.insert(category)
    }
}