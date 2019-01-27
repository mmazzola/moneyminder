package mmazzola.moneyminder.category

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.TextInputEditText
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.log4k.Level
import com.log4k.Log4k
import com.log4k.android.AndroidAppender
import dagger.android.AndroidInjection
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

        val iconContainer = findViewById<ConstraintLayout>(R.id.category_icons)
        for (i in 0 until iconContainer.childCount) {
            iconContainer.getChildAt(i).setOnClickListener { v: View -> presenter.onIconSelected(v.id) }
        }

        findViewById<TextInputEditText>(R.id.category_name_text).addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    presenter.onNameChanged(s.toString())
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        findViewById<Button>(R.id.button_category_create).setOnClickListener { presenter.onSubmitTapped() }
        presenter.onViewCreated()
    }

    override fun selectIcon(iconId: Int) {
        findViewById<ImageView>(iconId).setBackgroundColor(ContextCompat.getColor(this, R.color.selectedIconBackground))
    }

    override fun deselectIcon(iconId: Int) {
        findViewById<ImageView>(iconId).setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary))
    }

    override fun displayWarning(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun onCategorySaved() {
        finish()
    }

}
