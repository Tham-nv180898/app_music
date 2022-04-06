package com.example.myapp.ui.music

import android.os.Bundle
import android.transition.TransitionInflater.from
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.LayoutInflater.from
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.R
import com.example.myapp.adapter.ListMusicAdapter
import com.example.myapp.data.model.remote.MusicData
import com.example.myapp.data.repository.MusicRepositoryImpl
import com.example.myapp.data.source.remote.MusicRemoteDataSourceImpl
import com.example.myapp.data.source.remote.retrofit.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import kotlin.math.log


class MusicFragment : Fragment() {
    private var viewModel: MusicViewModel? = null
    private lateinit var rcvListMusic: RecyclerView
    private var mMusicAdapter: ListMusicAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        execute()
    }

    private fun execute() {
        viewModel?.getMusicData()
        viewModel?.musicData?.observe(viewLifecycleOwner) { musicData: MusicData? ->
            if (musicData != null) {
                mMusicAdapter?.setMusicData(musicData?.songs)
                rcvListMusic.adapter = mMusicAdapter
            } else Toast.makeText(context, "Disconnect Internet!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initView(view: View) {
        if (viewModel == null) {
            viewModel = ViewModelProvider(this).get(MusicViewModel::class.java)
        }
        rcvListMusic = view.findViewById(R.id.rcv_list_music)
        rcvListMusic.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        if (mMusicAdapter == null) mMusicAdapter = ListMusicAdapter()
    }
}