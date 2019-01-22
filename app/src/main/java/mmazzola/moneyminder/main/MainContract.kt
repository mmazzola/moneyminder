package mmazzola.moneyminder.main

import mmazzola.moneyminder.data.CategoryEntity

interface MainContract {

    interface Presenter {
        fun onViewCreated()
        fun loadCategories()
        fun onAddCategoryTapped()
    }

    interface View {
        fun displayCategories(categories : List<CategoryEntity>)
    }
}