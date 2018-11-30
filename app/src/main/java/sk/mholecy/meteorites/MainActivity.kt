package sk.mholecy.meteorites

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import sk.mholecy.meteorites.ui.meteoriteslist.MeteoritesListFragment

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
