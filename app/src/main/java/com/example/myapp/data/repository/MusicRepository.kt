package com.example.myapp.data.repository

import androidx.lifecycle.LiveData
import com.example.myapp.data.model.remote.MusicData

interface MusicRepository {
    suspend fun getMusicData(): LiveData<MusicData>?
}