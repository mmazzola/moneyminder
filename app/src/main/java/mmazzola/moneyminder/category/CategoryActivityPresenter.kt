package mmazzola.moneyminder.category

import mmazzola.moneyminder.BasePresenter
import mmazzola.moneyminder.rx.SchedulerFacade

class CategoryActivityPresenter constructor(view: CategoryContract.View, schedulerFacade: SchedulerFacade) :
    BasePresenter<CategoryContract.View>(view), CategoryContract.Presenter {
    override fun onViewCreated() {
        view.updateCategoryName("hi")
    }

    override fun displayCategory() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSubmitTapped() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}