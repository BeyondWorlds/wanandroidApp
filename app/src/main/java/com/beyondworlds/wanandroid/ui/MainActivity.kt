package com.beyondworlds.wanandroid.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.MenuItem
import com.beyondworlds.wanandroid.R
import com.beyondworlds.wanandroid.base.BaseActivity
import com.beyondworlds.wanandroid.home.HomeFragment
import com.beyondworlds.wanandroid.knowledge.TypeFragment
import com.beyondworlds.wanandroid.my.MyFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {


    private val fragmentManager by lazy {
        supportFragmentManager
    }
    private val mFragments by lazy { arrayOf<Fragment>(HomeFragment(), TypeFragment(), MyFragment()) }

    override fun setLayoutId(): Int = R.layout.activity_main

    override fun initView() {
        bottomNavigation.run {
            setOnNavigationItemSelectedListener(this@MainActivity)
            selectedItemId = R.id.navigation_home
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setFragment(index: Int) {
        fragmentManager.beginTransaction().run {
            if (!mFragments[index].isAdded)
                add(R.id.fl_content, mFragments[index])
            hideFragment(this)
            show(mFragments[index])
            commit()
        }
    }

    private fun hideFragment(transaction: FragmentTransaction) {
        transaction.run {
            for (fragment in mFragments)
                hide(fragment)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_home -> {
                setFragment(0)
                return true
            }
            R.id.navigation_type -> {
                setFragment(1)
                return true
            }
            R.id.navigation_my -> {
                setFragment(2)
                return true
            }
            else -> {
                return false
            }
        }

    }
}
