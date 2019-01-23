package mmazzola.moneyminder.category

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.log4k.Level
import com.log4k.Log4k
import com.log4k.android.AndroidAppender
import com.log4k.i
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_category.*
import mmazzola.moneyminder.BuildConfig
import mmazzola.moneyminder.R
import javax.inject.Inject

class CategoryActivity : AppCompatActivity(), CategoryContract.View {
    @Inject
    lateinit var presenter: CategoryActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) {
            Log4k.add(Level.Verbose, ".*", AndroidAppender())
        }
        setContentView(R.layout.activity_category)
        setSupportActionBar(toolbar)
        presenter.onViewCreated()
    }

    override fun updateCategoryName(name: String) {
        i(name)
    }
}
