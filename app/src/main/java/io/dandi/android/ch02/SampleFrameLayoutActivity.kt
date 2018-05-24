package io.dandi.android.ch02

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import io.dandi.doitandroid.R
import kotlinx.android.synthetic.main.ch0206_activity_main.*

class SampleFrameLayoutActivity : AppCompatActivity() {

    private var index: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.ch0206_activity_main)
    }

    fun onButton1Clicked(v : View) {
        changeImage()
    }

    private fun changeImage() {

        if (index == 0) {

            __iv_01__.visibility = View.VISIBLE
            __iv_02__.visibility = View.INVISIBLE

            index = 1

        } else {

            __iv_01__.visibility = View.INVISIBLE
            __iv_02__.visibility = View.VISIBLE

            index = 0
        }
    }

}

