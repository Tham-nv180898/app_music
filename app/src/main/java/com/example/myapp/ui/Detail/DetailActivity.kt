package com.example.myapp.ui.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapp.R
import com.example.myapp.data.model.remote.Song

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val bundle:Bundle? = intent.extras
        val listData: ArrayList<Song>? = bundle?.getParcelableArrayList("listData")
        val index = bundle?.getInt("number")
        Log.d("data", "${listData?.get(index!!.toInt())?.title}")
    }
}