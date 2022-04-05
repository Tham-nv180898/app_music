package com.example.myapp.ui.music

import android.os.Bundle
import android.transition.TransitionInflater.from
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.LayoutInflater.from
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myapp.R
import java.lang.Exception


class MusicFragment : Fragment() {
    private lateinit var viewModel:MusicViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MusicViewModel::class.java)
        viewModel.getData()
        try {
            viewModel.musicData.observe(viewLifecycleOwner){
                Log.d("response", "$it")
            }
        }catch (ex:Exception){
            Log.d("response", "no response")
        }

    }

}