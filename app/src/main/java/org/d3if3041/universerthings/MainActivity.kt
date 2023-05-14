package org.d3if3041.universerthings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

        // membuat dialog exit
        override fun onBackPressed() {
            // inisialisasi alert dialog
            val builder = AlertDialog.Builder(this)

            // mengeset judul dialog
            builder.setTitle(R.string.app_name)

            // mengeset pesan dialog
            builder.setMessage(R.string.exit_dialog)

            // jika ya
            builder.setPositiveButton("Ya") { _, _ ->
                this.finish()
            }

            // jika tidak
            builder.setNegativeButton("Tidak") { _, _ -> }

            // dialog tidak bisa kembali / cancel
            builder.setCancelable(false)

            // menampilkan dialog
            builder.show()
        }
}


