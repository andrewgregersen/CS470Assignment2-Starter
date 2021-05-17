package edu.bc.cs470assignment2

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import edu.bc.cs470assignment2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)


        val navController = this.findNavController(R.id.myNavHost)


        mediaPlayer = MediaPlayer.create(this, R.raw.jeopardy_theme_song)
        mediaPlayer.isLooping = true
        mediaPlayer.start()


    }

    override fun onPause() {
        super.onPause()
        mediaPlayer.stop()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer.start()
    }

}