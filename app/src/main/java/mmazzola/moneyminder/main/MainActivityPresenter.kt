package mmazzola.moneyminder.main

import mmazzola.moneyminder.BasePresenter
import mmazzola.moneyminder.rx.SchedulerFacade

class MainActivityPresenter constructor(
    view: MainContract.View,
    private val loadCategoriesUseCase: LoadCategoriesUseCase,
    private val schedulerFacade: SchedulerFacade
) : BasePresenter<MainContract.View>(view),
    MainContract.Presenter {


    override fun onViewCreated() {
    }

    override fun loadCategories() {
        addDisposables(loadCategoriesUseCase.execute()
            .subscribeOn(schedulerFacade.io())
            .observeOn(schedulerFacade.ui())
            .subscribe(view::displayCategories))
    }
}
