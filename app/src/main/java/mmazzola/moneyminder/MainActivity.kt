package mmazzola.moneyminder

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.log4k.Level
import com.log4k.Log4k
import com.log4k.android.AndroidAppender
import com.log4k.i

class MainActivity : AppCompatActivity(), MainActivityPresenter {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) {
            Log4k.add(Level.Verbose, ".*", AndroidAppender())
        }
        setContentView(R.layout.activity_main)

        //Setup ActionBar
        setSupportActionBar(findViewById(R.id.action_bar))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actions,menu)
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
}
