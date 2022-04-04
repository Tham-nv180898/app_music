package com.example.myapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.R

class ListMusicAdapter : RecyclerView.Adapter<ListMusicAdapter.ListMusicViewHolder>() {
     class ListMusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
          private val tvListMusic: TextView = itemView.findViewById(R.id.tv_list_music)
          private val rcvListMusic: RecyclerView = itemView.findViewById(R.id.rcv_list_music)
          fun bindingData() {

          }
     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMusicViewHolder {
          val view =
               LayoutInflater.from(parent.context).inflate(R.layout.item_list_music, parent, false)
          return ListMusicViewHolder(view)
     }

     override fun onBindViewHolder(holder: ListMusicViewHolder, position: Int) {
          holder.bindingData()
     }

     override fun getItemCount(): Int {
          return 4
     }
}