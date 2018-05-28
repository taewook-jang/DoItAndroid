package io.dandi.android.ch03

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import io.dandi.doitandroid.R
import kotlinx.android.synthetic.main.ch0301_activity_menu.*
import kotlinx.android.synthetic.main.ch0301_sub.view.*


class SampleLayoutInflaterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.ch0301_activity_menu)

        __button__.setOnClickListener {
            val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            inflater.inflate(R.layout.ch0301_sub, __container__, true)
            __container__.checkBox.text = "로딩되었어요."
        }
    }
}
