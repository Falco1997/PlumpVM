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
        private const val NUMBER_OF_PLAYERS = "NUMBER_OF_PLAYERS"
        private const val NUMBER_OF_ROUNDS = "NUMBER_OF_ROUNDS"
    }

    lateinit var binding: FragmentStartGameBinding

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
                Log.d("plumpDebug", binding.fragmentStartGameSpinnerNumberOfPlayers.selectedItem.toString())
                Log.d("plumpDebug", binding.fragmentStartGameSpinnerNumberOfRounds.selectedItem.toString())
                putExtra(NUMBER_OF_PLAYERS, binding.fragmentStartGameSpinnerNumberOfPlayers.selectedItem.toString())
                putExtra(NUMBER_OF_ROUNDS, binding.fragmentStartGameSpinnerNumberOfRounds.selectedItem.toString())
            }
            startActivity(startGameIntent)
        }

    }

}