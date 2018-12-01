package sk.mholecy.meteorites

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import sk.mholecy.meteorites.meteorites.ui.list.MeteoritesListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MeteoritesListFragment.newInstance())
                .commitNow()
        }
    }
}
