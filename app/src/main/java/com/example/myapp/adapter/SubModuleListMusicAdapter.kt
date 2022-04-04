package com.example.myapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.R

class SubModuleListMusicAdapter :
    RecyclerView.Adapter<SubModuleListMusicAdapter.SubModuleListMusicViewHolder>() {
    class SubModuleListMusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val avatar: ImageView = itemView.findViewById(R.id.iv_avatar)
        private val title: TextView = itemView.findViewById(R.id.tv_title)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): SubModuleListMusicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.submodule_item_list_music, parent, false)
        return SubModuleListMusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubModuleListMusicViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }
}