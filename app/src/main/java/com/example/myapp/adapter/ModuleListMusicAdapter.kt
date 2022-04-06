package com.example.myapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.R
import com.example.myapp.data.model.remote.MusicData
import com.example.myapp.data.model.remote.Song
import com.example.myapp.data.model.remote.Songs
import com.example.myapp.data.model.remote.Top100

const val SIZE_NO_DATA = 0

class ModuleListMusicAdapter :
    RecyclerView.Adapter<ModuleListMusicAdapter.ModuleListMusicViewHolder>() {
    private var moduleMusicData: List<Top100>? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setMusicData(listData: List<Top100>?) {
        moduleMusicData = listData
        notifyDataSetChanged()
    }

    class ModuleListMusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val typeMusicData: TextView = itemView.findViewById(R.id.tv_type_music)
        private var subModuleListMusicAdapter: SubModuleListMusicAdapter? = null
        private val rcvAvatar: RecyclerView = itemView.findViewById(R.id.rcv_avatar_music)

        private fun getAdapter(): SubModuleListMusicAdapter {
            return SubModuleListMusicAdapter()
        }

        fun bindingData(content: String?, data: List<Song>?) {
            /**
             * init adapter and set data for adapter */
            subModuleListMusicAdapter = getAdapter() ?: SubModuleListMusicAdapter()
            subModuleListMusicAdapter?.setMusicData(data)
            /**
             * recycle view */
            rcvAvatar.layoutManager =
                LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            rcvAvatar.adapter = subModuleListMusicAdapter
            /**
             * update ui */
            typeMusicData.text = content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleListMusicViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.module_item_list_music, parent, false)
        return ModuleListMusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModuleListMusicViewHolder, position: Int) {
        holder.bindingData(
            moduleMusicData?.let { moduleMusicData!![position].name },
            moduleMusicData?.let { moduleMusicData!![position].songs })
    }

    override fun getItemCount(): Int = if (moduleMusicData != null) {
        moduleMusicData!!.size
    } else {
        SIZE_NO_DATA
    }
}