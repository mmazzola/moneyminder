package mmazzola.moneyminder.main

import com.log4k.i

class MainActivityPresenter : MainContract.Presenter
{
    override fun onViewCreated() {
    }
    override fun onCategoriesLoaded() {
    }
    override fun onAddCategoryTapped() {
        i("Add Category!")
    }
}
