package mmazzola.moneyminder.main

import io.reactivex.Single
import mmazzola.moneyminder.data.CategoryEntity
import mmazzola.moneyminder.repository.CategoryRepository
import javax.inject.Inject

class LoadCategoriesUseCase @Inject constructor(private val categoryRepository: CategoryRepository) {

    fun execute() : Single<List<CategoryEntity>> = categoryRepository.loadCategories()
}