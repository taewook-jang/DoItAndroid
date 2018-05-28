package io.dandi.android.ch03

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.dandi.doitandroid.R
import kotlinx.android.synthetic.main.ch0303_activity_main.*


class SampleCallIntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.ch0303_activity_main)

        __button__.setOnClickListener {

            val data = __edit_text__.text.toString()

            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(data)))
        }
    }
}
