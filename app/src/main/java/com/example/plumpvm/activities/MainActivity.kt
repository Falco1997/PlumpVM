package com.example.plumpvm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.plumpvm.*
import com.example.plumpvm.databinding.ActivityMainBinding
import com.example.plumpvm.fragments.HighScoreFragment
import com.example.plumpvm.fragments.SettingsFragment
import com.example.plumpvm.fragments.StartGameFragment

class MainActivity : AppCompatActivity() {

    companion object {
        private const val KEY_FRAGMENT_START_GAME = "KEY_START_GAME"
        private const val KEY_FRAGMENT_HIGHSCORE = "KEY_HIGHSCORE"
        private const val KEY_FRAGMENT_SETTINGS = "KEY_SETTINGS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        //App bar text
        //supportActionBar?.title = getString(R.string.customer_information)

        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.main_activity_frame_layout, StartGameFragment(), KEY_FRAGMENT_START_GAME)
                .add(R.id.main_activity_frame_layout, HighScoreFragment(), KEY_FRAGMENT_HIGHSCORE)
                .add(R.id.main_activity_frame_layout, SettingsFragment(), KEY_FRAGMENT_SETTINGS)
                .commitNow()
            supportFragmentManager
                .beginTransaction()
                .hide(supportFragmentManager.findFragmentByTag(KEY_FRAGMENT_HIGHSCORE)!!)
                .hide(supportFragmentManager.findFragmentByTag(KEY_FRAGMENT_SETTINGS)!!)
                .commit()
        }

        binding.mainActivityBottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.StartGame -> changeFragment(KEY_FRAGMENT_START_GAME)
                R.id.HighScore -> changeFragment(KEY_FRAGMENT_HIGHSCORE)
                R.id.Settings -> changeFragment(KEY_FRAGMENT_SETTINGS)
            }
            true
        }
    }

    private fun changeFragment(fragmentKey: String) {
        with(supportFragmentManager.beginTransaction()) {
            for (fragment in supportFragmentManager.fragments) {
                hide(fragment)
            }
            show(supportFragmentManager.findFragmentByTag(fragmentKey)!!)
            commit()
        }
    }

}