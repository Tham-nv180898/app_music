package com.example.myapp.data.model.remote

data class Top100(
    val name: String,
    val songs: List<Song>,
    val url: String,
)