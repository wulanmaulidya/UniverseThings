package org.d3if3041.universerthings.ui.listdata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if3041.universerthings.R
import org.d3if3041.universerthings.databinding.ListItemBinding
import org.d3if3041.universerthings.model.Universe
import org.d3if3041.universerthings.network.UniverseApi

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private val data = mutableListOf<Universe>()
    fun updateData(newData: List<Universe>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
    class ViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(universe: Universe) = with(binding) {
            namaTextView.text = universe.namaPlanet
            isiTextView.text = universe.informasiPlanet
            Glide.with(imageView.context)
                .load(UniverseApi.getUniverseUrl(universe.imgPlanet))
                .error(R.drawable.ic_baseline_broken_image_24)
                .into(imageView)
            root.setOnClickListener {
                // do something
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}
