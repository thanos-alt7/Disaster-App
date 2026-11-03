package com.example.disasterapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.disasterapp.databinding.ItemDisasterBinding
import com.example.disasterapp.R

typealias OnClickDisaster = (Disaster) -> Unit

class DisasterAdapter(
    private val listDisaster: List<Disaster>,
    private val onClickDisaster: OnClickDisaster
) : RecyclerView.Adapter<DisasterAdapter.DisasterViewHolder>() {

    inner class DisasterViewHolder(
        private val binding: ItemDisasterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(disaster: Disaster) {
            binding.txtDisasterName.text = disaster.nameDisaster
            binding.txtDisasterType.text = disaster.disasterType

            binding.imgDisaster.setImageResource(disaster.imageRes)

            binding.root.setOnClickListener {
                onClickDisaster(disaster)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DisasterViewHolder {
        val binding = ItemDisasterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DisasterViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: DisasterViewHolder,
        position: Int
    ) {
        holder.bind(listDisaster[position])
    }

    override fun getItemCount(): Int {
        return listDisaster.size
    }
}