package org.d3if3041.universerthings.ui.histori

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if3041.universerthings.data.UniverseEntity
import org.d3if3041.universerthings.databinding.ListHistoriBinding
import org.d3if3041.universerthings.model.cariUniverse
import java.text.SimpleDateFormat
import java.util.*

class HistoriAdapter : ListAdapter<UniverseEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<UniverseEntity>() {
                override fun areItemsTheSame(
                    oldData: UniverseEntity, newData: UniverseEntity
                ): Boolean {
                    return oldData.id == newData.id
                }

                override fun areContentsTheSame(
                    oldData: UniverseEntity, newData: UniverseEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ListHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val dateFormatter = SimpleDateFormat(
            "dd MMMM yyyy",
            Locale("id", "ID")
        )

        fun bind(item: UniverseEntity) = with(binding) {
            val rnd = Random()
            val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))

            val hasilUniverse = item.cariUniverse()
            kategoriTextView.text = hasilUniverse.namaPlanet.substring(0, 1)
            val circleBg = kategoriTextView.background as GradientDrawable
            circleBg.setColor(color)
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            universeTextView.text = hasilUniverse.namaPlanet
        }
    }
}