package com.example.myapp.data.source.remote

import androidx.lifecycle.LiveData
import com.example.myapp.data.model.remote.MusicData
import com.example.myapp.data.source.remote.retrofit.RetrofitClient
import retrofit2.Response
import java.lang.Exception

class MusicRemoteDataSourceImpl : MusicRemoteDataSource {
    override suspend fun getMusicData(): Response<MusicData> =
        RetrofitClient.retrofitClient.getMusicData()
}