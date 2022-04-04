package com.example.myapp.data.model.remote

data class Songs(
    val top100_AM: List<Top100AM>,
    val top100_CA: List<Top100CA>,
    val top100_KL: List<Top100KL>,
    val top100_VN: List<Top100VN>
)