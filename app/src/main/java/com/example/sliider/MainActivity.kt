package com.example.sliider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter by lazy { SliderAdapter(this.applicationContext) }
    private var currentPage = 0
    private var lastPage = 2

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

                        nextButton.text = "Next"
                        previousButton.text = ""
                    }

                    lastPage -> {
                        nextButton.isEnabled = true
                        previousButton.isEnabled = true
                        previousButton.visibility = View.VISIBLE

                        nextButton.text = "Finish"
                        previousButton.text = "Back"
                    }

                    else -> {
                        nextButton.isEnabled = true
                        previousButton.isEnabled = true
                        previousButton.visibility = View.VISIBLE

                        nextButton.text = "Next"
                        previousButton.text = "Back"
                    }
                }
            }

        })


    }
}
