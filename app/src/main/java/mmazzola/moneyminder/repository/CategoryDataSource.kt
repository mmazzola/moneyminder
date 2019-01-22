package mmazzola.moneyminder.repository

import io.reactivex.Completable
import io.reactivex.Single
import mmazzola.moneyminder.data.CategoryDao
import mmazzola.moneyminder.data.CategoryEntity
import javax.inject.Inject

class CategoryDataSource @Inject constructor(var categoryDao: CategoryDao) : CategoryRepository {

    override fun loadCategories(): Single<List<CategoryEntity>> = categoryDao.selectAll()

    override fun addCategory(category: CategoryEntity): Completable = Completable.fromAction {categoryDao.insert(category)}

}