package com.example.sliider

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.slide_layout.view.*

class SliderAdapter(
    val context: Context
) : PagerAdapter() {

    val slideImage = emptyList<Drawable>()

    val slideHeader = listOf(
        "Lorem ipsum dolor.",
        "Lorem ipsum dolor.",
        "Lorem ipsum dolor."
    )

    val slideDescription = listOf(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In consectetur massa ac risus eleifend accumsan.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In consectetur massa ac risus eleifend accumsan.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In consectetur massa ac risus eleifend accumsan."
    )

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as ConstraintLayout
    }

    override fun getCount(): Int {
        return slideHeader.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        return super.instantiateItem(container, position)
        val layoutInflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.slide_layout, container, false)

        view.onboardingHeader.text = slideHeader[position]
        view.onboardingDescription.text = slideDescription[position]

        container.addView(view)
        return view
    }

    // Once last page has been reached it will stop instead of creating multiple slide (stops crash)
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//        super.destroyItem(container, position, `object`)
        container.removeView(`object` as ConstraintLayout)
    }
}