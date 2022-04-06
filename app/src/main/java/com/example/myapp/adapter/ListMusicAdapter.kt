package com.example.myapp.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.R
import com.example.myapp.data.model.remote.Songs
import com.example.myapp.data.model.remote.Top100

const val NO_TYPE_MUSIC = 0
const val NUMBER_TYPE_MUSIC = 4
const val INDEX_TOP100_AM = 0
const val INDEX_TOP100_CA = 1
const val INDEX_TOP100_KL = 2
const val INDEX_TOP100_VN = 3
const val TOP100_AM = "TOP100_AM"
const val TOP100_CA = "TOP100_CA"
const val TOP100_KL = "TOP100_KL"
const val TOP100_VN = "TOP100_VN"
val LIST_TOP100: List<String> = listOf(TOP100_AM, TOP100_CA, TOP100_KL, TOP100_VN)

class ListMusicAdapter : RecyclerView.Adapter<ListMusicAdapter.ListMusicViewHolder>() {
    private var musicData: Songs? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setMusicData(data: Songs?) {
        musicData = data
        notifyDataSetChanged()
    }

    class ListMusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvModuleListMusic: TextView = itemView.findViewById(R.id.tv_module_list_music)
        private var moduleListMusicAdapter: ModuleListMusicAdapter? = null
        private val rcvModuleListMusic: RecyclerView =
            itemView.findViewById(R.id.rcv_module_list_music)

        private fun getAdapter(): ModuleListMusicAdapter {
            return ModuleListMusicAdapter()
        }

        fun bindingData(content: String, data: List<Top100>?) {
            /**
             * init adapter and set data for adapter */
            moduleListMusicAdapter = getAdapter() ?: ModuleListMusicAdapter()
            moduleListMusicAdapter?.setMusicData(data)
            /**
             * recycle view */
            rcvModuleListMusic.layoutManager =
                LinearLayoutManager(itemView.context, LinearLayoutManager.VERTICAL, false)
            rcvModuleListMusic.adapter = moduleListMusicAdapter
            /**
             * update ui */
            tvModuleListMusic.text = content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMusicViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_music, parent, false)
        return ListMusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListMusicViewHolder, position: Int) {
        when (position) {
            INDEX_TOP100_AM -> {
                holder.bindingData(LIST_TOP100[position], musicData?.top100_AM)
            }
            INDEX_TOP100_CA -> {
                holder.bindingData(LIST_TOP100[position], musicData?.top100_CA)
            }
            INDEX_TOP100_KL -> {
                holder.bindingData(LIST_TOP100[position], musicData?.top100_KL)
            }
            INDEX_TOP100_VN -> {
                holder.bindingData(LIST_TOP100[position], musicData?.top100_VN)
            }
        }
    }

    override fun getItemCount(): Int {
        return if (musicData != null) {
            NUMBER_TYPE_MUSIC
        } else NO_TYPE_MUSIC
    }
}