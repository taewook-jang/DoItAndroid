package io.dandi.android

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import android.widget.Toast
import io.dandi.android.ch02.LayoutCodeActivity
import io.dandi.android.ch02.SampleLinearLayoutActivity
import io.dandi.android.ch02.SampleRelativeLayoutActivity
import io.dandi.doitandroid.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter = ExampleAdapter(this, listOf (
                ExampleData(R.drawable.number_0, R.drawable.number_1, "리니어 레이아웃 사용", "Chapter 02-2"),
                ExampleData(R.drawable.number_0, R.drawable.number_2, "자바코드에서 화면 구성", "Chapter 02-2"),
                ExampleData(R.drawable.number_0, R.drawable.number_3, "상대 레이아웃 사용", "Chapter 02-3")
            )
        )

        adapter.setOnItemClickListener(this)

        __rv_example_list__.layoutManager = LinearLayoutManager(this)
        __rv_example_list__.adapter = adapter
    }

    override fun onClick(v: View?) {

        val textView = v?.findViewById(R.id.__tv_title__) as TextView
        val title = textView.text ?: "None"

        Toast.makeText(this, "선택 :: $title", Toast.LENGTH_SHORT).show()

        when (title) {
            "리니어 레이아웃 사용" -> startActivity(Intent(this, SampleLinearLayoutActivity::class.java))
            "자바코드에서 화면 구성" -> startActivity(Intent(this, LayoutCodeActivity::class.java))
            "상대 레이아웃 사용" -> startActivity(Intent(this, SampleRelativeLayoutActivity::class.java))
            else -> Toast.makeText(this, "선택 :: 뿅", Toast.LENGTH_SHORT).show()
        }

        /*val textView = v?.findViewById(R.id.text_name) as TextView
        val name = textView.text ?: "None"

        val intent = Intent(this, NationDetailActivity::class.java)
        intent.putExtra(NationDetailActivity.EXTRA_NATION_NAME, name)

        startActivity(intent)*/
    }
}
