package org.d3if3041.universerthings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.d3if3041.universerthings.R.id.myNavHostFragment

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
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


