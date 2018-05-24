package io.dandi.android.ch02

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import io.dandi.doitandroid.R
import kotlinx.android.synthetic.main.ch0205_activity_main.*

class SampleScrollLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.ch0205_activity_main)

        __scroll_view__.isHorizontalScrollBarEnabled = true

        val img01 = resources.getDrawable(R.drawable.image01)

        __img_view__.setImageDrawable(img01)
        __img_view__.layoutParams.height = img01.intrinsicHeight
        __img_view__.layoutParams.width = img01.intrinsicWidth
    }

    fun onButton1Clicked(v : View) {
        changeImage()
    }

    private fun changeImage() {

        val img02 = resources.getDrawable(R.drawable.image02)

        __img_view__.setImageDrawable(img02)
        __img_view__.layoutParams.height = img02.intrinsicHeight
        __img_view__.layoutParams.width = img02.intrinsicWidth
    }

}
/*



import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    ScrollView scrollView;
    ImageView imageView;
    BitmapDrawable bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = (ScrollView) findViewById(R.id.scrollView);
        imageView = (ImageView) findViewById(R.id.imageView);

        scrollView.setHorizontalScrollBarEnabled(true);

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;
    }

    public void onButton1Clicked(View v) {
        changeImage();
    }

    private void changeImage() {
        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image02);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;
    }
}
*/
