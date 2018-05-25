package io.dandi.android.mission

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.dandi.doitandroid.R
import kotlinx.android.synthetic.main.mission02_activity_main.*

class Mission02Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.mission02_activity_main)

        __mission02_btn_01__.setOnClickListener {
            moveImageUp()
        }

        __mission02_btn_02__.setOnClickListener {
            moveImageDown()
        }
    }

    private fun moveImageUp() {

        __mission02_iv_01__.setImageResource(R.drawable.beach)
        __mission02_iv_02__.setImageResource(0)

        __mission02_iv_01__.invalidate()
        __mission02_iv_02__.invalidate()
    }

    private fun moveImageDown() {

        __mission02_iv_01__.setImageResource(0)
        __mission02_iv_02__.setImageResource(R.drawable.beach)

        __mission02_iv_01__.invalidate()
        __mission02_iv_02__.invalidate()
    }

}

/*

private void moveImageDown() {
    imageView01.setImageResource(0);
    imageView02.setImageResource(R.drawable.beach);

    imageView01.invalidate();
    imageView02.invalidate();
}

private void moveImageUp() {
    imageView01.setImageResource(R.drawable.beach);
    imageView02.setImageResource(0);

    imageView01.invalidate();
    imageView02.invalidate();
}*/
