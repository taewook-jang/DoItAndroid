package io.dandi.android.ch03

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import io.dandi.doitandroid.R
import kotlinx.android.synthetic.main.ch0306_activity_main.*


class SampleServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.ch0306_activity_main)

        processIntent(intent)

        __button__.setOnClickListener {

            val intent = Intent(this, MyService::class.java)
            intent.putExtra("command", "show")
            intent.putExtra("name", __edit_text__.text.toString())

            startService(intent)
        }
    }

    override fun onNewIntent(intent: Intent?) {

        processIntent(intent)
        super.onNewIntent(intent)
    }

    private fun processIntent(intent: Intent?) {

        if (intent != null) {

            val command: String
            val name: String
            val bundle = intent.extras

            when(bundle) {

                null -> {
                    command = "커맨드"
                    name = "네임"
                }

                else -> {
                    command = bundle.getString("command")
                    name = bundle.getString("name")

                    processCommand(command, name)
                }
            }

            Toast.makeText(this, "command : $command, name : $name", Toast.LENGTH_SHORT).show()
        }
    }

    private fun processCommand(command: String, name: String) {

        Log.d("MyService", "command: $command, name: $name")

        for (i in 1..5) {

            try {
                Thread.sleep(1000)
            } catch (e: Exception) {
                Log.e("MyService", "ERROR :: ${e.message}")
            }

            Log.d("MyService", "${i}초 기다림...")
        }
    }

}
