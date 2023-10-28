package com.example.recyclerview_cardview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val myDataSet: ArrayList<String>, private val imageResources: ArrayList<Int>, private val listener: OnItemClickListener) : RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vh = LayoutInflater.from(parent.context).inflate(R.layout.ligne, parent,false)
        return ViewHolder(vh)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var current = myDataSet[position]
        var current_image = imageResources[position]

        holder.vText.text = current.toString()
        holder.imageView.setImageResource(current_image)
    }

    override fun getItemCount(): Int {
        return myDataSet.size
    }
    inner class ViewHolder(val itemview: View):
        RecyclerView.ViewHolder(itemview),View.OnClickListener{
        val vText = itemView.findViewById(R.id.word) as TextView
        val deleteButton :Button = itemView.findViewById(R.id.deleteButton)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)

        init {
            itemView.setOnClickListener(this)
            deleteButton.setOnClickListener{
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION){
                    listener.deleteItem(position)
                }
            }
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
        fun deleteItem(position: Int)
    }
}

