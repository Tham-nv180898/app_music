package com.example.myapp.data.repository

import androidx.lifecycle.LiveData
import com.example.myapp.data.model.remote.MusicData
import com.example.myapp.data.source.remote.MusicRemoteDataSourceImpl

class MusicRepositoryImpl:MusicRepository {
    override suspend fun getMusicData(): LiveData<MusicData>? {
        val musicRemoteDataSourceImpl = MusicRemoteDataSourceImpl()
        return musicRemoteDataSourceImpl.getMusicData()
    }
}