package io.dandi.android.ch03

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import io.dandi.doitandroid.R
import kotlinx.android.synthetic.main.ch0305_activity_main.*

class SampleLifecycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ch0305_activity_main)

        __text_view__.text = "onCreate 호출됨"
        Toast.makeText(this, "onCreate 호출됨", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()

        __text_view__.text = "onStart 호출됨"
        Toast.makeText(this, "onStart 호출됨", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()

        __text_view__.text = "onStop 호출됨"
        Toast.makeText(this, "onStop 호출됨", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()

        __text_view__.text = "onDestroy 호출됨"
        Toast.makeText(this, "onDestroy 호출됨", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()

        __text_view__.text = "onPause 호출됨"
        Toast.makeText(this, "onPause 호출됨", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()

        __text_view__.text = "onResume 호출됨"
        Toast.makeText(this, "onResume 호출됨", Toast.LENGTH_SHORT).show()
    }
}
