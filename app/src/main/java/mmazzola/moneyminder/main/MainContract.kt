package mmazzola.moneyminder.main

import mmazzola.moneyminder.foundation.BasePresenter
import mmazzola.moneyminder.foundation.BaseView

interface MainContract {

    interface Presenter : BasePresenter {
        fun onViewCreated()
        fun onCategoriesLoaded()
        fun onAddCategoryTapped()
    }

    interface View : BaseView<Presenter> {
        fun displayCategories()
    }
}