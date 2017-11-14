package com.example.framgiatongxuanan.android_kotlin_st


import android.os.Bundle
import android.support.design.widget.BottomNavigationView

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import com.example.bottomnavigation.ui.DashboardFragment
import com.example.bottomnavigation.ui.NotificationsFragment
import com.example.framgiatongxuanan.android_kotlin_st.fragment.BlankFragment

import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var username: String
    private lateinit var password: String
    private var TAG: String = "SettingActivity"
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                switchFragment(BlankFragment.newInstance(), BlankFragment.TAG);
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                switchFragment(DashboardFragment.newInstance(), DashboardFragment.TAG)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                switchFragment(NotificationsFragment.newInstance(), NotificationsFragment.TAG);
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        toolbar = findViewById(R.id.toolbar)
        bottomNavigation = findViewById(R.id.bottom_navigation)
//x        setSupportActionBar(toolbar)
        username = intent.getStringExtra("username")
        password = intent.getStringExtra("password")

        Log.e(TAG, "infomation: " + username + " " + password);
        initFrangment(savedInstanceState)
        var bundle= Bundle()
        bundle.putString("username",username)
        bundle.putString("password",password)
        var homeFragment:Fragment=BlankFragment.newInstance();
        homeFragment.setArguments(bundle)
                                                                                                                                                                                                                                    
    }

    private fun initFrangment(savaInstanceState: Bundle?) {

        savaInstanceState ?: switchFragment(BlankFragment.newInstance(), BlankFragment.TAG)
    }

    private fun switchFragment(fragment: Fragment, tag: String): Boolean {
        if (fragment.isAdded) return false
        detachFragment()
        attachFragment(fragment, tag)
        supportFragmentManager.executePendingTransactions()
        return true

    }

    private fun detachFragment() {
        supportFragmentManager.findFragmentById(R.id.container)?.also {
            supportFragmentManager.beginTransaction().detach(it).commit()
        }
    }

    private fun attachFragment(fragment: Fragment, tag: String) {
        if (fragment.isDetached) {
            supportFragmentManager.beginTransaction()
                    .attach(fragment)
                    .commit()
        } else {
            supportFragmentManager.beginTransaction()
                    .add(R.id.container, fragment, tag)
                    .commit()
        }
        supportFragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
    }

}
