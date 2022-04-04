package com.example.myapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.R

class ModuleListMusicAdapter :
    RecyclerView.Adapter<ModuleListMusicAdapter.ModuleListMusicViewHolder>() {
    class ModuleListMusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val type: TextView = itemView.findViewById(R.id.tv_type_music)
        private val rcvAvatar: RecyclerView = itemView.findViewById(R.id.rcv_avatar_music)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleListMusicViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.module_item_list_music, parent, false)
        return ModuleListMusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModuleListMusicViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }
}