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
import mmazzola.moneyminder.BuildConfig
import mmazzola.moneyminder.R

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var presenter: MainContract.Presenter
    private lateinit var addCategoryButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) {
            Log4k.add(Level.Verbose, ".*", AndroidAppender())
        }
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.action_bar))
        setPresenter(MainActivityPresenter(this))
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

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun displayCategories() {
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }
}
