package com.example.myapp.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapp.data.model.remote.MusicData
import com.example.myapp.data.source.remote.MusicRemoteDataSourceImpl
import com.example.myapp.data.source.remote.retrofit.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MusicRepositoryImpl : MusicRepository {

    private val musicRemoteDataSourceImpl = MusicRemoteDataSourceImpl()
    private var data: MutableLiveData<MusicData> = MutableLiveData()

    override suspend fun getMusicData(): LiveData<MusicData> {
        if (data.value == null) {
            withContext(Dispatchers.Main) {
                data.value = musicRemoteDataSourceImpl.getMusicData().body()
                Log.d("error", "MusicRepositoryImpl")
            }
        }
        return data
    }
}