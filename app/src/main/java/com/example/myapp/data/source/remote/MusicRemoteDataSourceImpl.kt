package com.example.myapp.data.source.remote

import androidx.lifecycle.LiveData
import com.example.myapp.data.model.remote.MusicData
import com.example.myapp.data.source.remote.retrofit.RetrofitClient
import retrofit2.Response
import java.lang.Exception

class MusicRemoteDataSourceImpl : MusicRemoteDataSource {
    override suspend fun getMusicData(): LiveData<MusicData>? =
        try {
            RetrofitClient.retrofitClient.let { musicApiService ->
                if (musicApiService.getMusicData().isSuccessful) {
                    var musicData: LiveData<MusicData>? = musicApiService.getMusicData().body()
                    musicData
                } else {
                    null
                }
            }
        }catch (exception:Exception){
            null
        }
}