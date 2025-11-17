package com.example.nobarecoffeshop.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nobarecoffeshop.Activity.DetailActivity
import com.example.nobarecoffeshop.Domain.ItemsModel
import com.example.nobarecoffeshop.databinding.ViewholderPopularBinding
import java.text.NumberFormat
import java.util.Locale

class PopularAdapter(val items: MutableList<ItemsModel>) :
    RecyclerView.Adapter<PopularAdapter.Viewholder>() {

    lateinit var context: Context

    class Viewholder(val binding: ViewholderPopularBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularAdapter.Viewholder {
        context = parent.context
        val binding = ViewholderPopularBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: PopularAdapter.Viewholder, position: Int) {
        holder.binding.titleTxt.text = items[position].title
        val formattedPrice =
            NumberFormat.getNumberInstance(Locale("id", "ID")).format(items[position].price.toInt())
        holder.binding.priceTxt.text = "Rp$formattedPrice"
        holder.binding.subtitleTxt.text = items[position].extra.toString()

        Glide.with(context)
            .load(items[position].picUrl[0])
            .into(holder.binding.pic)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("object", items[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size
}
