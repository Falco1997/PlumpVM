package com.example.plumpvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.plumpvm.R
import com.example.plumpvm.databinding.FragmentStartGameBinding

class StartGameFragment : Fragment() {

    companion object {

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



}