package com.example.myapp.data.source.remote.retrofit

import androidx.lifecycle.LiveData
import com.example.myapp.data.model.remote.MusicData
import retrofit2.Response
import retrofit2.http.GET

interface MusicApiService {
    @GET("v2/key-value-stores/EJ3Ppyr2t73Ifit64/records/LATEST")
    suspend fun  getMusicData(): Response<MusicData>
}