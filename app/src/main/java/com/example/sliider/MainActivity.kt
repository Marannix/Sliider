package com.example.sliider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter by lazy { SliderAdapter(this.applicationContext) }
    private var currentPage = 0
    private var lastPage = 2

    // TODO: Create shared preference to only see this screen once
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onboardingViewPager.adapter = adapter

        nextButton.setOnClickListener {
            onboardingViewPager.currentItem = currentPage + 1
        }

        previousButton.setOnClickListener {
            onboardingViewPager.currentItem = currentPage - 1
        }
        onboardingViewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                currentPage = position
                when (position) {
                    0 -> {
                        nextButton.isEnabled = true
                        previousButton.isEnabled = false
                        previousButton.visibility = View.INVISIBLE
                        finishButton.visibility = View.INVISIBLE
                    }

                    lastPage -> {
                        nextButton.isEnabled = true
                        previousButton.isEnabled = true

                        nextButton.visibility = View.INVISIBLE
                        previousButton.visibility = View.VISIBLE
                        finishButton.visibility = View.VISIBLE

                        finishButton.setOnClickListener {
                            launchDashboard()
                        }
                    }

                    else -> {
                        nextButton.isEnabled = true
                        previousButton.isEnabled = true

                        nextButton.visibility = View.VISIBLE
                        previousButton.visibility = View.VISIBLE
                        finishButton.visibility = View.INVISIBLE
                    }
                }
            }

        })


    }

    private fun launchDashboard() {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()

    }
}
