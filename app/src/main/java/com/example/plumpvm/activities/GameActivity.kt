package com.example.plumpvm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.plumpvm.*
import com.example.plumpvm.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    companion object {
        private const val NUMBER_OF_PLAYERS = "NUMBER_OF_PLAYERS"
        private const val NUMBER_OF_ROUNDS = "NUMBER_OF_ROUNDS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val binding = ActivityGameBinding.inflate(layoutInflater)

        val numberOfPlayers = intent.getStringExtra(NUMBER_OF_PLAYERS)
        val numberOfRounds = intent.getStringExtra(NUMBER_OF_ROUNDS)

        Log.d("plumpDebug", "GameActivity Players: " + numberOfPlayers.toString())
        Log.d("plumpDebug", "GameActivity Rounds: " + numberOfRounds.toString())

        binding.test1.text = numberOfPlayers
        binding.test2.text = numberOfRounds
        
    }
}