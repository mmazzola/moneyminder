package mmazzola.moneyminder.category

interface CategoryContract {


    interface Presenter {
        fun onViewCreated()
        fun onIconSelected(iconId : Int)
        fun onNameChanged(name : String)
        fun displayCategory()
        fun onSubmitTapped()
    }

    interface View {
        fun selectIcon(iconId: Int)
        fun deselectIcon(iconId : Int)
        fun onCategorySaved()
        fun displayWarning(text : String)
    }
}