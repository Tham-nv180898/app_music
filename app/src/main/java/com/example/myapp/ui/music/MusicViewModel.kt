package com.example.myapp.ui.music

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapp.data.model.remote.MusicData
import com.example.myapp.data.repository.MusicRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MusicViewModel:ViewModel() {
    val musicData:MutableLiveData<MusicData> = MutableLiveData()
    fun getData(){
        CoroutineScope(Dispatchers.IO).launch {
            val musicRepository = MusicRepositoryImpl()
            musicData.postValue(musicRepository.getMusicData()?.value)
        }
    }
}