package com.example.mobile_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuHistoricActivity : Fragment() {

    data class Imovel(
        val image: Int,
        val title: String,
        val price: String,
        var favorite: Boolean
    )

    // Lista de imóveis para demonstração
    private val imoveisList = listOf(
        Imovel(R.drawable.img_casa1, "BARCELOS", "120.000 €", true),
        Imovel(R.drawable.img_casa2, "BRAGA", "185.000 €", false),
        Imovel(R.drawable.img_casa3, "VIANA CASTELO", "135.000 €", false),
        Imovel(R.drawable.img_casa4, "BRAGA", "200.000 €", true),
        Imovel(R.drawable.img_casa5, "PORTO", "230.000 €", false)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_menu_historic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // RecyclerView config
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_historic)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ImovelAdapter(imoveisList)
    }

    // Adapter for RecyclerView
    class ImovelAdapter(private val imoveis: List<Imovel>) :
        RecyclerView.Adapter<ImovelAdapter.ImovelViewHolder>() {

        class ImovelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imageView: ImageView = itemView.findViewById(R.id.imovel_image)
            val titleView: TextView = itemView.findViewById(R.id.imovel_title)
            val priceView: TextView = itemView.findViewById(R.id.imovel_price)
            val favoriteView: ImageView = itemView.findViewById(R.id.imovel_favorite)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImovelViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_menu_favorite_imovel, parent, false)
            return ImovelViewHolder(view)
        }

        override fun onBindViewHolder(holder: ImovelViewHolder, position: Int) {
            val imovel = imoveis[position]

            holder.imageView.setImageResource(imovel.image)
            holder.titleView.text = imovel.title
            holder.priceView.text = imovel.price

            // State icon favorite
            holder.favoriteView.setImageResource(
                if (imovel.favorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_border
            )

            // Favorite Click
            holder.favoriteView.setOnClickListener {
                imovel.favorite = !imovel.favorite
                holder.favoriteView.setImageResource(
                    if (imovel.favorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_border
                )
            }
        }

        override fun getItemCount(): Int = imoveis.size
    }
}
