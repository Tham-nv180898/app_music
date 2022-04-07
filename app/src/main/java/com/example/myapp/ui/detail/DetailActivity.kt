package com.example.myapp.ui.detail

import android.media.AudioAttributes
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.SeekBar
import com.bumptech.glide.Glide
import com.example.myapp.R
import com.example.myapp.data.model.remote.Song
import com.google.android.material.floatingactionbutton.FloatingActionButton
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var circleImage: CircleImageView
    private lateinit var btnPrevious: FloatingActionButton
    private lateinit var btnPauseAndPlayer: FloatingActionButton
    private lateinit var btnNext: FloatingActionButton
    private lateinit var seekBar: SeekBar
    private  var handler: Handler? = null
    private  var runnable: Runnable? = null
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        /**
         * init all */
        initView()
        initHandlerAndRunnable()
        /**
         * receiver data */
        val bundle: Bundle? = intent.extras
        val listData: ArrayList<Song>? = bundle?.getParcelableArrayList("listData")
        val index = bundle?.getInt("index")
        /**
         * prepare media player */
        prepareMediaPlayer(listData!![index!!.toInt()].music)
        /**
         * click button */
        setOnclickButton()
        /**
         *binding data*/
        bindingData(listData[index.toInt()].avatar)
    }

    private fun bindingData(srcAvatar: String?) {
        Glide.with(this).load(srcAvatar).centerCrop().into(circleImage)
    }

    private fun initHandlerAndRunnable() {
        handler = Handler(Looper.getMainLooper())
        runnable = Runnable {
//            seekBar.progress = mediaPlayer?.currentPosition ?: 0
            handler?.postDelayed(runnable!!, 500)
        }
        handler?.postDelayed(runnable!!, 100)
    }

    private fun setOnclickButton() {
        btnPauseAndPlayer.setOnClickListener(this)
        btnPrevious.setOnClickListener(this)
        btnNext.setOnClickListener(this)
        seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                mediaPlayer?.seekTo(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })
    }

    private fun prepareMediaPlayer(url: String?) {
        if (mediaPlayer == null) {
            mediaPlayer = initMediaPlayer()
        }
        mediaPlayer.also { mediaPlayer ->
            mediaPlayer?.setDataSource(url)
            mediaPlayer?.prepareAsync()
        }
    }

    private fun initMediaPlayer(): MediaPlayer = MediaPlayer().apply {
        setAudioAttributes(
            AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build()
        )
        setOnPreparedListener {
            play()
            seekBar.progress = 0
            seekBar.max = mediaPlayer!!.duration
        }
        setOnCompletionListener {
            btnPauseAndPlayer.setImageResource(R.drawable.ic_play)
            seekBar.progress = 0
        }
    }

    private fun initView() {
        seekBar = findViewById(R.id.seek_bar)
        circleImage = findViewById(R.id.profile_image)
        btnPrevious = findViewById(R.id.btn_previous)
        btnPauseAndPlayer = findViewById(R.id.btn_pause_and_play)
        btnNext = findViewById(R.id.btn_next)
    }
    private fun play(){
        mediaPlayer?.start()
        btnPauseAndPlayer.setImageResource(R.drawable.ic_pause)
    }

    private fun pause(){
        mediaPlayer?.pause()
        btnPauseAndPlayer.setImageResource(R.drawable.ic_play)
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_previous -> {

            }
            R.id.btn_pause_and_play -> {
                if (!mediaPlayer!!.isPlaying) {
                    play()
                } else {
                    pause()
                }
            }
            R.id.btn_next -> {

            }
        }
    }
}