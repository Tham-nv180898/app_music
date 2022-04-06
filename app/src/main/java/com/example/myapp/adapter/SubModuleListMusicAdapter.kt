package com.example.myapp.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapp.R
import com.example.myapp.data.model.remote.Song
import com.example.myapp.ui.Detail.DetailActivity


class SubModuleListMusicAdapter :
    RecyclerView.Adapter<SubModuleListMusicAdapter.SubModuleListMusicViewHolder>() {
    private var subModuleMusicData: List<Song>? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setMusicData(listData: List<Song>?) {
        subModuleMusicData = listData
        notifyDataSetChanged()
    }

    inner class SubModuleListMusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val avatar: ImageView = itemView.findViewById(R.id.iv_avatar)
        private val title: TextView = itemView.findViewById(R.id.tv_title)


        fun bindingData(content: String?, srcAvatar: String?) {
            /**
             * update ui */
            title.text = content
            Glide.with(itemView.context).load(srcAvatar).centerCrop().into(avatar)
        }

        fun onClick(){
            avatar.setOnClickListener{
                val intent = Intent(itemView.context, DetailActivity::class.java)
                (itemView.context as FragmentActivity).startActivity(intent)
            }
        }
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
        holder.bindingData(
            subModuleMusicData?.let { subModuleMusicData!![position].title },
            subModuleMusicData?.let { subModuleMusicData!![position].avatar })
        holder.onClick()
    }

    override fun getItemCount(): Int {
        return if (subModuleMusicData != null) {
            subModuleMusicData!!.size
        } else {
            SIZE_NO_DATA
        }
    }
}