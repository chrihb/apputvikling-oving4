package ntnu.idi.oving4

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import java.lang.Integer.max
import java.lang.Integer.min

class MainActivity : AppCompatActivity(), TitlesFragment.OnTitleSelectedListener {

    // Current selected movie index
    private var selectedIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // restore last index if rotated
        selectedIndex = savedInstanceState?.getInt("selectedIndex") ?: 0

        if (savedInstanceState == null) {
            // first time
            supportFragmentManager.beginTransaction()
                .replace(R.id.titlesContainer, TitlesFragment())
                .replace(R.id.detailsContainer, DetailsFragment())
                .runOnCommit { onTitleSelected(selectedIndex) }
                .commit()
        } else {
            // fragments already restored
            window?.decorView?.post {
                onTitleSelected(selectedIndex)
            }
        }
    }

    // Saves the selected index when rotating
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("selectedIndex", selectedIndex)
    }

    //Menu creation
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    //Menu item selection handling
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_next -> {
                selectedIndex = min(Movie.entries.lastIndex, selectedIndex + 1)
                onTitleSelected(selectedIndex)
                true
            }
            R.id.menu_prev -> {
                selectedIndex = max(0, selectedIndex - 1)
                onTitleSelected(selectedIndex)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Called both when user clicks a title and when we navigate via menu
    override fun onTitleSelected(index: Int) {
        selectedIndex = index
        val details = supportFragmentManager
            .findFragmentById(R.id.detailsContainer) as? DetailsFragment
        details?.showDetails(index)
    }
}
