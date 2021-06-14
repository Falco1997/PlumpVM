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

    lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val numberOfPlayers = intent.getStringExtra(NUMBER_OF_PLAYERS).toString()
        val numberOfRounds = intent.getStringExtra(NUMBER_OF_ROUNDS).toString()

        Log.d("plumpDebug", "GameActivity Players: " + numberOfPlayers)
        Log.d("plumpDebug", "GameActivity Rounds: " + numberOfRounds)

        binding.test1.text = numberOfPlayers
        binding.test2.text = numberOfRounds

        Log.d("plumpDebug", binding.test1.text as String)
        Log.d("plumpDebug", binding.test2.text as String)
        
    }
}