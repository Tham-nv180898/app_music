package com.example.myapp.data.model.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Song(
    val avatar: String,
    val bgImage: String,
    val coverImage: String,
    val creator: String,
    val lyric: String,
    val music: String,
    val title: String,
    val url: String,
) : Parcelable