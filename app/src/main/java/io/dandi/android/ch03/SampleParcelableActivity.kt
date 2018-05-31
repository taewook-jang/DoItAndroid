package io.dandi.android.ch03

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.dandi.android.MainActivity.Companion.KEY_SIMPLE_DATA
import io.dandi.doitandroid.R
import kotlinx.android.synthetic.main.ch0304_activity_main.*


class SampleParcelableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.ch0304_activity_main)

        __button__.setOnClickListener {
            val intent = Intent()
            intent.putExtra("name", "장태욱")
            setResult(Activity.RESULT_OK, intent)

            finish()
        }

        // 메인 액티비티로부터 전달받은 인텐트를 확인합니다.
        processIntent(intent)
    }

    private fun processIntent(intent: Intent?) {

        if (intent != null) {
            // 인텐트 안의 번들 객체를 참조합니다.
            val bundle = intent.extras

            // 번들 객체 안의 SimpleData 객체를 참조합니다.
            val data = bundle!!.getParcelable(KEY_SIMPLE_DATA) as SimpleData

            // 텍스트뷰에 값을 보여줍니다.
            __text_view__.text = "전달받은 데이터\nNumber : ${data.number}\nMessage : ${data.message}"
        }
    }
}
