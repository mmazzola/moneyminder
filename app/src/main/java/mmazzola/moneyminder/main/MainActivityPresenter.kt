package mmazzola.moneyminder.main

import mmazzola.moneyminder.BasePresenter

class MainActivityPresenter(view: MainContract.View) : BasePresenter<MainContract.View>(view),
    MainContract.Presenter {

    override fun onViewCreated() {
    }

    override fun onCategoriesLoaded() {
    }

    override fun onAddCategoryTapped() {
    }
}
