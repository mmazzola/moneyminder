package mmazzola.moneyminder.main

interface MainContract {

    interface Presenter {
        fun onViewCreated()
        fun onCategoriesLoaded()
        fun onAddCategoryTapped()
    }

    interface View {
        fun displayCategories()
    }
}