package io.dandi.android.ch03

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import io.dandi.doitandroid.R
import kotlinx.android.synthetic.main.ch0303_pdf_activity_main.*
import java.io.File


class SamplePDFViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.ch0303_pdf_activity_main)

        __button__.setOnClickListener {

            val fileName = __edit_text__.text.toString()

            if (fileName.isNotEmpty()) {
                openPdf(fileName)
            } else {
                Toast.makeText(this, "PDF 파일명을 입력하세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun openPdf(fileName: String) {

        val sdcardFolder = Environment.getExternalStorageDirectory().absolutePath
        val filepath = sdcardFolder + File.separator + fileName + ".pdf"
        val file = File(filepath)

        if (file.exists()) {

            val uri = Uri.fromFile(file)

            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(uri, "application/pdf")

            try {
                startActivity(intent)
            } catch (ex: Exception) {
                Toast.makeText(this, "PDF 파일을 보기 위한 뷰어 앱이 없습니다.", Toast.LENGTH_SHORT).show()
            }

        } else {
            Toast.makeText(this, "PDF 파일이 없습니다.", Toast.LENGTH_SHORT).show()
        }
    }
}
