package com.example.plumpvm.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.plumpvm.activities.GameActivity
import com.example.plumpvm.databinding.FragmentStartGameBinding

class StartGameFragment : Fragment() {

    companion object {
        private const val LIST_OF_PLAYERS = "LIST_OF_PLAYERS"
        private const val NUMBER_OF_ROUNDS = "NUMBER_OF_ROUNDS"
    }

    lateinit var binding: FragmentStartGameBinding

    private val numberOfRounds14 = arrayListOf(10, 9, 8, 7, 6, 5, 4, 4, 5, 6, 7, 8, 9, 10)
    private val numberOfRounds7 = arrayListOf(10, 9, 8, 7, 6, 5, 4)

    private var listOfPlayers = arrayListOf("Bos", "Jan", "Gör", "Jal", "Kal")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Do
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentStartGameBinding.inflate(inflater, container, false).run {
        binding = this
        root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragmentStartGameButtonStartGame.setOnClickListener {
            val startGameIntent = Intent(context, GameActivity::class.java).apply {
                when (binding.fragmentStartGameSpinnerNumberOfRounds.selectedItem.toString()) {
                    "14" -> putIntegerArrayListExtra(NUMBER_OF_ROUNDS, numberOfRounds14)
                    "7" -> putIntegerArrayListExtra(NUMBER_OF_ROUNDS, numberOfRounds7)
                }
                putStringArrayListExtra(LIST_OF_PLAYERS, listOfPlayers)
            }
            startActivity(startGameIntent)
        }

    }

}