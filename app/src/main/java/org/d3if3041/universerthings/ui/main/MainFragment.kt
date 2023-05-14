package org.d3if3041.universerthings.ui.main

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.d3if3041.universerthings.R
import org.d3if3041.universerthings.data.UniverseDb
import org.d3if3041.universerthings.databinding.FragmentMainBinding
import org.d3if3041.universerthings.model.HasilUniverse

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by lazy {
        val db = UniverseDb.getInstance(requireContext())
        val factory = MainViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnCari.setOnClickListener { cariPlanet() }
        viewModel.getHasilUniverse().observe(requireActivity()) { showResult(it) }
    }

    private fun isInputEmpty(input: String): Boolean {
        return input.isNullOrBlank()
    }
    private fun isInputNumber(input: String): Boolean {
        return input.toIntOrNull() != null
    }

    fun isInputValid(input: String): Boolean {
        val regex = Regex("^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$")
        return regex.matches(input)
    }


    private fun cariPlanet() {
        // inisialiasi variabel dengan memamggil inputan dari inpPlanet
        val planet = binding.inpPlanet.text.toString()

        // melakuakan pengecekan inputan kalau angka (sanity check)
        if (isInputNumber(planet)) {
            Toast.makeText(context, R.string.input_angka, Toast.LENGTH_SHORT).show()
            return
            // melakuakan pengecekan inputan kalau kosong (sanity check)
        } else if (isInputEmpty(planet)) {
            Toast.makeText(context, R.string.input_kosong, Toast.LENGTH_SHORT).show()
            return
            // melakuakan pengecekan inputan kalau angka kombinasi dengan teks (sanity check)
        } else if (isInputValid(planet)) {
            Toast.makeText(context, R.string.input_combine, Toast.LENGTH_SHORT).show()
            return
            // melakuakan pengecekan inputan kalau karakter (sanity check)
        }  else if (planet.contains("[!\"#$%&'()*+,-./:;\\\\<=>?@\\[\\]^_`{|}~]".toRegex())) {
            Toast.makeText(context, R.string.input_karakter, Toast.LENGTH_LONG).show()
        } else {
            viewModel.cariUniverse(planet)
        }
    }

    private fun showResult(result: HasilUniverse?) {
        if (result == null) return
        binding.namaPlanet.isVisible = true
        binding.informasiPlanet.isVisible = true
        binding.imgPlanet.isVisible = true

        binding.namaPlanet.text = result.namaPlanet
        binding.informasiPlanet.text = getString(result.informasiPlanet)
        binding.imgPlanet.setImageResource(result.imgPlanet)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.my_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_histori -> {
                findNavController().navigate(R.id.action_mainFragment_to_historiFragment)
                return true
            }
            R.id.menu_about -> {
                findNavController().navigate(R.id.action_mainFragment_to_fragmentAbout)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}


