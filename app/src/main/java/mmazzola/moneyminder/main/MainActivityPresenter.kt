package mmazzola.moneyminder.main

class MainActivityPresenter(view: MainContract.View) : MainContract.Presenter
{
    private var view : MainContract.View? = view
    override fun onViewCreated() {
        view?.displayCategories()
    }

    override fun onDestroy() {
        this.view = null
    }
    override fun onCategoriesLoaded() {
    }
    override fun onAddCategoryTapped() {
    }
}
