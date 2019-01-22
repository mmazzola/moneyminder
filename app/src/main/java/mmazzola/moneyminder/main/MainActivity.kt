package mmazzola.moneyminder.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import com.log4k.Level
import com.log4k.Log4k
import com.log4k.android.AndroidAppender
import com.log4k.i
import dagger.android.AndroidInjection
import mmazzola.moneyminder.BuildConfig
import mmazzola.moneyminder.R
import mmazzola.moneyminder.data.CategoryEntity
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {
    @Inject lateinit var presenter: MainActivityPresenter

    private lateinit var addCategoryButton: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) {
            Log4k.add(Level.Verbose, ".*", AndroidAppender())
        }
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.action_bar))
        addCategoryButton = findViewById(R.id.button_category_add)
        addCategoryButton.setOnClickListener { presenter.onAddCategoryTapped() }
        presenter.onViewCreated()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actions, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {

        R.id.action_accounts -> {
            i("Accounts")
            true
        }

        R.id.action_graph -> {
            i("Graphs")
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun displayCategories(categories : List<CategoryEntity>) {
        categories.forEach { c -> i(c.toString()) }
    }

    override fun onStop() {
        super.onStop()
        presenter.stop()
    }
}
