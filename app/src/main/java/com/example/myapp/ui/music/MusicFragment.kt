package com.example.myapp.ui.music

import android.os.Bundle
import android.transition.TransitionInflater.from
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.LayoutInflater.from
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.example.myapp.R
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
    private var viewModel:MusicViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(viewModel == null) {
            Log.d("response", "??????")
            viewModel = ViewModelProvider(this).get(MusicViewModel::class.java)
        }
        Log.d("response", "abcdddd")
        viewModel?.getMusicData()
        viewModel?.musicData?.observe(viewLifecycleOwner){
            Log.d("response", "$it")
        }
    }

}