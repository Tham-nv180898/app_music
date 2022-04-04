package com.example.myapp.data.model.remote

data class MusicData(
    val author: String,
    val buymecoffee: Buymecoffee,
    val lastUpdatedAtApify: String,
    val lastUpdatedAtSource: String,
    val songs: Songs,
    val sourceUrl: String
)