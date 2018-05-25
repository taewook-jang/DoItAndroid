package io.dandi.android.mission

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import io.dandi.doitandroid.R
import kotlinx.android.synthetic.main.mission04_activity_main.*
import java.io.UnsupportedEncodingException

class Mission04Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.mission04_activity_main)

        __m04_btn_send__.setOnClickListener {
            val message = __m04_et_input_msg__.text
            Toast.makeText(this, "[메시지 전송]\n\n$message", Toast.LENGTH_SHORT).show()
        }

        __m04_btn_close__.setOnClickListener {
            finish()
        }

        val watcher = object : TextWatcher {

            override fun onTextChanged(str: CharSequence, start: Int, before: Int, count: Int) {
                var bytes: ByteArray? = null
                try {
                    bytes = str.toString().toByteArray(charset("KSC5601"))
                    val strCount = bytes.size
                    __m04_tv_input_count__.text = strCount.toString() + " / 80바이트"
                } catch (ex: UnsupportedEncodingException) {
                    ex.printStackTrace()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(strEditable: Editable) {

                val str = strEditable.toString()
                try {
                    val strBytes = str.toByteArray(charset("KSC5601"))
                    if (strBytes.size > 80) {
                        strEditable.delete(strEditable.length - 2, strEditable.length - 1)
                    }
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }
        }

        __m04_et_input_msg__.addTextChangedListener(watcher)
    }

}
