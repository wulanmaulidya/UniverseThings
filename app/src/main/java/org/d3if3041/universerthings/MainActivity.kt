package org.d3if3041.universerthings
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import org.d3if3041.universerthings.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCari.setOnClickListener { cariPlanet() }
    }

    private fun cariPlanet() {
        // inisialiasi variabel dengan memamggil inputan dari inpPlanet
        val planet = binding.inpPlanet.text.toString()

        // melakuakan pengecekan inputan kalau kosong (sanity check)
        if (TextUtils.isEmpty(planet)) {
            Toast.makeText(this, R.string.input_kosong, Toast.LENGTH_LONG).show()
        }

        // melakukan pengecekan kalau inputan tidak berupa angka (sanity check)
        if (TextUtils.isDigitsOnly(planet)) {
            Toast.makeText(this, R.string.input_angka, Toast.LENGTH_LONG).show()
        }

        // melakukan pengecekan kalau inputan tidak berupa karakter spesial (sanity check)
        if (binding.inpPlanet.text!!.contains("[!\"get#$%&'()*+,-./:;\\\\<=>?@\\[\\]^_`{|}~]".toRegex())) {
            Toast.makeText(this, R.string.input_karakter, Toast.LENGTH_LONG).show()
        }

        // pengecekan ketika mencari planet, meteor atau galaxy
        if (planet.equals("Merkurius", ignoreCase = true)) { // merkurius

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaPlanet.isVisible = true
            binding.informasiPlanet.isVisible = true
            binding.imgPlanet.isVisible = true

            // mengeset data
            binding.namaPlanet.text = getString(R.string.planet_merkurius)
            binding.informasiPlanet.text = "-Planet terdekat dari Matahari\n" +
                    "-Sehari di Merkurius lebih lama daripada setahun di Merkurius\n" +
                    "-Merkurius adalah planet terkecil"
            binding.imgPlanet.setImageResource(R.drawable.merkurius)
        } else if (planet.equals("Venus", ignoreCase = true)) { // venus

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaPlanet.isVisible = true
            binding.informasiPlanet.isVisible = true
            binding.imgPlanet.isVisible = true

            // mengeset data
            binding.namaPlanet.text = getString(R.string.planet_venus)
            binding.informasiPlanet.text = "-Venus disebut sebagai Bintang Kejora\n" +
                    "-Venus merupakan planet terpanas di Tata Surya\n" +
                    "-Di Venus Matahari terbit dari barat"
            binding.imgPlanet.setImageResource(R.drawable.venus)
        } else if (planet.equals("Bumi", ignoreCase = true)) { // bumi

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaPlanet.isVisible = true
            binding.informasiPlanet.isVisible = true
            binding.imgPlanet.isVisible = true

            // mengeset data
            binding.namaPlanet.text = getString(R.string.planet_bumi)
            binding.informasiPlanet.text = "-Bumi Adalah Planet Air\n" +
                    "-Atmosfer Bumi sangat tebal\n" +
                    "-Bumi adalah tempat tinggal makhluk hidup"
            binding.imgPlanet.setImageResource(R.drawable.bumi)
        } else if (planet.equals("Mars", ignoreCase = true)) { // mars

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaPlanet.isVisible = true
            binding.informasiPlanet.isVisible = true
            binding.imgPlanet.isVisible = true

            // mengeset data
            binding.namaPlanet.text = getString(R.string.planet_mars)
            binding.informasiPlanet.text = "-Mars mempunyai Gunung Tertinggi di Tata Surya\n" +
                    "-Mars memiliki Badai Debu Terbesar di Tata Surya\n" +
                    "-Mars Mempunyai Air"
            binding.imgPlanet.setImageResource(R.drawable.mars)
        } else if (planet.equals("Jupiter", ignoreCase = true)) { // jupiter

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaPlanet.isVisible = true
            binding.informasiPlanet.isVisible = true
            binding.imgPlanet.isVisible = true

            // mengeset data
            binding.namaPlanet.text = getString(R.string.planet_jupiter)
            binding.informasiPlanet.text = "-Jupiter adalah planet terbesar di tata surya\n" +
                    "-Jupiter mengalami hari paling pendek\n" +
                    "-Jupiter memiliki satelit terbesar pada tata surya"
            binding.imgPlanet.setImageResource(R.drawable.jupiter)
        } else if (planet.equals("Saturnus", ignoreCase = true)) { // saturnus

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaPlanet.isVisible = true
            binding.informasiPlanet.isVisible = true
            binding.imgPlanet.isVisible = true

            // mengeset data
            binding.namaPlanet.text = getString(R.string.planet_saturnus)
            binding.informasiPlanet.text = "-Nama Saturnus Diambil Dari Nama Dewa Yunani\n" +
                    "-Ternyata Cincin Saturnus Bisa Menghilang\n" +
                    "-Planet Terbesar Kedua Dalam Tata Surya"
            binding.imgPlanet.setImageResource(R.drawable.saturnus)
        } else if (planet.equals("Uranus", ignoreCase = true)) { // uranus

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaPlanet.isVisible = true
            binding.informasiPlanet.isVisible = true
            binding.imgPlanet.isVisible = true

            // mengeset data
            binding.namaPlanet.text = getString(R.string.planet_uranus)
            binding.informasiPlanet.text = "-Uranus sering disebut sebagai planet es\n" +
                    "-Uranus merupakan planet ke 3 terbesar di tata surya\n" +
                    "-Hanya satu pesawat saja yang pernah menjelajahi Uranus"
            binding.imgPlanet.setImageResource(R.drawable.uranus)
        } else if (planet.equals("Neptunus", ignoreCase = true)) { // neptunus

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaPlanet.isVisible = true
            binding.informasiPlanet.isVisible = true
            binding.imgPlanet.isVisible = true

            // mengeset data
            binding.namaPlanet.text = getString(R.string.planet_neptunus)
            binding.informasiPlanet.text = "-Neptunus adalah planet terjauh dari matahari\n" +
                    "-Gravitasi hampir sama dengan Bumi\n" +
                    "-Penemuan Neptunus masih kontroversi"
            binding.imgPlanet.setImageResource(R.drawable.neptunus)
        } else if (planet.equals("Andromeda", ignoreCase = true)) { // Andromeda

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaPlanet.isVisible = true
            binding.informasiPlanet.isVisible = true
            binding.imgPlanet.isVisible = true

            // mengeset data
            binding.namaPlanet.text = getString(R.string.andromeda)
            binding.informasiPlanet.text = getString(R.string.infor_andromeda)
            binding.imgPlanet.setImageResource(R.drawable.andromeda)
        } else if (planet.equals("Bima Sakti", ignoreCase = true)) { // Bima Sakti

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaPlanet.isVisible = true
            binding.informasiPlanet.isVisible = true
            binding.imgPlanet.isVisible = true

            // mengeset data
            binding.namaPlanet.text = getString(R.string.bima_sakti)
            binding.informasiPlanet.text = getString(R.string.infor_bima)
            binding.imgPlanet.setImageResource(R.drawable.bimasakti)
        } else if (planet.equals("Black Eye", ignoreCase = true)) { // Black Eye

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaPlanet.isVisible = true
            binding.informasiPlanet.isVisible = true
            binding.imgPlanet.isVisible = true

            // mengeset data
            binding.namaPlanet.text = getString(R.string.black_eye)
            binding.informasiPlanet.text = getString(R.string.infor_blackeye)
            binding.imgPlanet.setImageResource(R.drawable.blackeye)
        } else if (planet.equals("Smiley", ignoreCase = true)) { // smiley

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaPlanet.isVisible = true
            binding.informasiPlanet.isVisible = true
            binding.imgPlanet.isVisible = true

            // mengeset data
            binding.namaPlanet.text = getString(R.string.smiley)
            binding.informasiPlanet.text = getString(R.string.infor_smiley)
            binding.imgPlanet.setImageResource(R.drawable.smiley)
        } else if (planet.equals("Ursa Mayor", ignoreCase = true)) { // ursa mayor

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaPlanet.isVisible = true
            binding.informasiPlanet.isVisible = true
            binding.imgPlanet.isVisible = true

            // mengeset data
            binding.namaPlanet.text = getString(R.string.ursa_mayor)
            binding.informasiPlanet.text = getString(R.string.infor_ursamayor)
            binding.imgPlanet.setImageResource(R.drawable.ursamayor)
        } else if (planet.equals("Orionid", ignoreCase = true)) { // Orionid

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaPlanet.isVisible = true
            binding.informasiPlanet.isVisible = true
            binding.imgPlanet.isVisible = true

            // mengeset data
            binding.namaPlanet.text = getString(R.string.orionid)
            binding.informasiPlanet.text = getString(R.string.infor_orionid)
            binding.imgPlanet.setImageResource(R.drawable.orionid)
        } else if (planet.equals("Perseid", ignoreCase = true)) { // perseid

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaPlanet.isVisible = true
            binding.informasiPlanet.isVisible = true
            binding.imgPlanet.isVisible = true

            // mengeset data
            binding.namaPlanet.text = getString(R.string.perseid)
            binding.informasiPlanet.text = getString(R.string.infor_perseid)
            binding.imgPlanet.setImageResource(R.drawable.perseid)
        } else if (planet.equals("Quadrantid", ignoreCase = true)) { // quadrantid

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaPlanet.isVisible = true
            binding.informasiPlanet.isVisible = true
            binding.imgPlanet.isVisible = true

            // mengeset data
            binding.namaPlanet.text = getString(R.string.quadrantid)
            binding.informasiPlanet.text = getString(R.string.infor_quadrantid)
            binding.imgPlanet.setImageResource(R.drawable.quadrantid)

        } else {
            Toast.makeText(this, R.string.tidak_diketahui, Toast.LENGTH_LONG).show()
        }
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


