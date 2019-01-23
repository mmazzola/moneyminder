package mmazzola.moneyminder.category

interface CategoryContract {


    interface Presenter {
        fun onViewCreated()
        fun displayCategory()
        fun onSubmitTapped()
    }

    interface View {
        fun updateCategoryName(name : String)
    }
}