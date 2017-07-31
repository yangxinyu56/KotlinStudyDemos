package com.yxy.kotlinstudydemos

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import com.yxy.kotlinstudydemos.fragments.MainFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar()
        setupNavigationView(nav_view)
        createViewFragment()
    }

    private fun createViewFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fl_home_container, MainFragment())
        transaction.commit()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        val ab = supportActionBar
        ab!!.setHomeAsUpIndicator(R.drawable.ic_menu)
        ab.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupNavigationView(nav_view: NavigationView) {
        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.list_navigation_menu_item -> {
                    niceToast("test_list_click")
                }
            }
            it.isChecked = true
            drawer_layout.closeDrawers()
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Open the navigation drawer when the home icon is selected from the toolbar.
                drawer_layout.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun niceToast(message: String,
                  tag: String = javaClass.simpleName,
                  length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, "$tag $message", length).show()
    }
}
