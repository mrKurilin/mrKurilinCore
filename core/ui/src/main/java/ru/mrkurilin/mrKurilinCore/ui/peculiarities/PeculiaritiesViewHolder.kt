package ru.mrkurilin.mrKurilinCore.ui.peculiarities

import androidx.recyclerview.widget.RecyclerView
import ru.mrkurilin.mrKurilinCore.ui.databinding.PeculiaritiesViewHolderBinding

class PeculiaritiesViewHolder(
    private val peculiaritiesViewHolderBinding: PeculiaritiesViewHolderBinding
) : RecyclerView.ViewHolder(
    peculiaritiesViewHolderBinding.root
) {

    fun bind(text: String) {
        peculiaritiesViewHolderBinding.peculiarityTextView.text = text
    }
}