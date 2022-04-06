package com.example.myapp.data.source.remote

import android.util.Log
import com.example.myapp.data.model.remote.MusicData
import com.example.myapp.data.source.remote.retrofit.RetrofitClient
import retrofit2.Response
import java.lang.Exception

class MusicRemoteDataSourceImpl : MusicRemoteDataSource {
    override suspend fun getMusicData(): Response<MusicData> =
        try {
            RetrofitClient.retrofitClient.getMusicData()
        } catch (ex: Exception) {
            Log.d("error", "disconnect internet")
            Response.success(null)
        }
}