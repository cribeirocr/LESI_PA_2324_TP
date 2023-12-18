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

class MenuFavoriteActivity : Fragment() {

    private lateinit var imoveisFavoritos: MutableList<Imovel>

    data class Imovel(
        val image: Int,
        val title: String,
        val price: String,
        var favorite: Boolean
    )

    private val imoveisList = listOf(
        Imovel(R.drawable.img_casa1, "BARCELOS", "120.000 €", true),
        Imovel(R.drawable.img_casa2, "BRAGA", "185.000 €", false),
        Imovel(R.drawable.img_casa3, "PRADO", "130.000 €", true),
        Imovel(R.drawable.img_casa4, "GUIMARAES", "160.000 €", false),
        Imovel(R.drawable.img_casa5, "PORTO", "220.000 €", true),
        Imovel(R.drawable.img_casa6, "BRAGA", "180.000 €", false),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar o layout para este fragmento
        return inflater.inflate(R.layout.activity_menu_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Filtrar a lista para mostrar apenas os favoritos
        imoveisFavoritos = imoveisList.filter { it.favorite }.toMutableList()

        // Configura o RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_favorite)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ImovelAdapter(imoveisFavoritos) {
            // Atualiza a lista de favoritos e o adapter
            imoveisFavoritos = imoveisFavoritos.filter { it.favorite }.toMutableList()
            recyclerView.adapter?.notifyDataSetChanged()
        }
    }

    // Adapter para o RecyclerView
    class ImovelAdapter(private var imoveis: MutableList<Imovel>, private val onItemChanged: () -> Unit) :
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

            // Configurar o ícone de favorito com base no estado
            holder.favoriteView.setImageResource(
                if (imovel.favorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_border
            )

            // Configurar a lógica de clique no ícone de favorito
            holder.favoriteView.setOnClickListener {
                // Alterar o estado de favorito
                imovel.favorite = !imovel.favorite
                // Atualizar o ícone de favorito
                holder.favoriteView.setImageResource(
                    if (imovel.favorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_border
                )
                // Atualizar a lista e o adapter
                if (!imovel.favorite) {
                    onItemChanged()
                }
            }
        }

        override fun getItemCount(): Int = imoveis.size
    }
}
