package io.dandi.android.ch03

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.dandi.doitandroid.R
import kotlinx.android.synthetic.main.ch0302_activity_menu.*


class SampleIntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.ch0302_activity_menu)

        __button__.setOnClickListener {
            val intent = Intent()
            intent.putExtra("name", "장태욱")
            setResult(Activity.RESULT_OK, intent)

            finish()
        }
    }
}
