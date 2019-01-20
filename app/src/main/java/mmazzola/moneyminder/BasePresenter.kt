package mmazzola.moneyminder

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<T>(protected val view: T) {

    private val disposables: CompositeDisposable = CompositeDisposable()

    fun start() {}

    fun stop() {
        disposables.clear()
    }

    protected fun addDisposables(disposable: Disposable) {
        disposables.add(disposable)
    }
}