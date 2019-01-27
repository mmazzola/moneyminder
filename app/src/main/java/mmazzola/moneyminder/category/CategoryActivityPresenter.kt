package mmazzola.moneyminder.category

import mmazzola.moneyminder.BasePresenter
import mmazzola.moneyminder.data.CategoryEntity
import mmazzola.moneyminder.main.SaveCategoryUseCase
import mmazzola.moneyminder.rx.SchedulerFacade

class CategoryActivityPresenter constructor(
    view: CategoryContract.View,
    private val saveCategoryUseCase: SaveCategoryUseCase,
    private val schedulerFacade: SchedulerFacade
) :
    BasePresenter<CategoryContract.View>(view), CategoryContract.Presenter {

    lateinit var category: CategoryEntity
    var selectedIconId: Int = -1

    override fun onViewCreated() {
        category = CategoryEntity()
    }

    override fun onIconSelected(iconId: Int) {
        if (selectedIconId < 0 || selectedIconId != iconId) {
            category.imageUrl = "drawable://$iconId"
            if (selectedIconId > 0) {
                (view::deselectIcon)(selectedIconId)
            }
            (view::selectIcon)(iconId)
            selectedIconId = iconId
        } else {
            (view::deselectIcon)(selectedIconId)
            selectedIconId = -1
            category.imageUrl = ""
        }
    }

    override fun onNameChanged(name: String) {
        category.title = name
    }

    override fun onSubmitTapped() {

        if (category.imageUrl.isNotBlank() && category.title.isNotBlank()) {
            addDisposables(
                saveCategoryUseCase.execute(CategoryEntity(category.title, category.imageUrl))
                    .subscribeOn(schedulerFacade.io())
                    .observeOn(schedulerFacade.ui())
                    .subscribe(view::onCategorySaved)
            )
        }
        else
        {
            view.displayWarning("Need to fill everything!")
        }
    }

    override fun displayCategory() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}