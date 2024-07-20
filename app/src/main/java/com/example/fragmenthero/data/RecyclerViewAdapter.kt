package com.example.fragmenthero.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fragmenthero.R
import com.example.fragmenthero.fragments.OnItemClickListener


class RecyclerViewAdapter(private val items: List<Superhero>,
                          private val listener: OnItemClickListener
): RecyclerView.Adapter<RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.hero_item, parent, false)
        return RecyclerViewHolder(itemView)
    }



    override fun getItemCount(): Int =items.size

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.name.text = items[position].name
        Glide.with(holder.itemView)
            .load(items[position].images.sm)
            .into(holder.listImage)

        holder.itemView.setOnClickListener {
            listener.onItemClick(items[position])
        }
    }


}

class RecyclerViewHolder(view: View): RecyclerView.ViewHolder(view){
    val name: TextView = view.findViewById(R.id.tvName)
    val listImage: ImageView = view.findViewById(R.id.imageView)
}


