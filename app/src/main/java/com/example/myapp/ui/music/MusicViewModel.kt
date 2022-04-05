package com.example.myapp.ui.music

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapp.data.model.remote.MusicData
import com.example.myapp.data.repository.MusicRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MusicViewModel : ViewModel() {
    private val musicRepositoryImpl = MusicRepositoryImpl()
    var musicData: MutableLiveData<MusicData> = MutableLiveData()

    fun getMusicData() {
        CoroutineScope(Dispatchers.IO).launch {
            val result = musicRepositoryImpl.getMusicData()
            musicData.postValue(result.value)
        }
    }
}