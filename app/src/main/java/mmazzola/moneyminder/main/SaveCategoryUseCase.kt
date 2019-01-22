package mmazzola.moneyminder.main

import io.reactivex.Completable
import mmazzola.moneyminder.data.CategoryEntity
import mmazzola.moneyminder.repository.CategoryRepository
import javax.inject.Inject

class SaveCategoryUseCase @Inject constructor(private val categoryRepository: CategoryRepository) {

    fun execute(categoryEntity: CategoryEntity): Completable = categoryRepository.addCategory(categoryEntity)
}