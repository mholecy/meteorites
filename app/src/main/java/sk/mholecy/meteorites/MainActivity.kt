package sk.mholecy.meteorites

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import sk.mholecy.meteorites.databinding.ActivityMainBinding
import sk.mholecy.meteorites.meteorites.ui.list.MeteoritesListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MeteoritesListFragment.newInstance())
                .commitNow()
        }
    }
}
