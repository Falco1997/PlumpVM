package com.example.plumpvm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plumpvm.adapters.GameAdapter
import com.example.plumpvm.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    companion object {
        private const val LIST_OF_PLAYERS = "LIST_OF_PLAYERS"
        private const val NUMBER_OF_ROUNDS = "NUMBER_OF_ROUNDS"
    }

    lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listOfPlayers = intent.getStringArrayListExtra(LIST_OF_PLAYERS)!!
        val numberOfRounds = intent.getIntegerArrayListExtra(NUMBER_OF_ROUNDS)!!

        binding.player1Name.text = listOfPlayers[0]
        binding.player2Name.text = listOfPlayers[1]
        binding.player3Name.text = listOfPlayers[2]
        binding.player4Name.text = listOfPlayers[3]
        binding.player5Name.text = listOfPlayers[4]

        binding.activityGameRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.activityGameRecyclerview.adapter = GameAdapter(listOfPlayers.size, numberOfRounds)

    }
}
