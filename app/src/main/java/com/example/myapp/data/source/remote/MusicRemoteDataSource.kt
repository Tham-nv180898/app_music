package com.example.myapp.data.source.remote

import com.example.myapp.data.model.remote.MusicData
import retrofit2.Response

interface MusicRemoteDataSource {
    suspend fun getMusicData() :Response<MusicData>
}