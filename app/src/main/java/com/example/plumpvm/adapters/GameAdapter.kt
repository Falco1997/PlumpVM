package com.example.plumpvm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.plumpvm.R
import java.util.ArrayList

class GameAdapter(private var numberOfPlayers: Int, private var numberOfRows: ArrayList<Int>) : RecyclerView.Adapter<GameAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val rowNumber: TextView = itemView.findViewById(R.id.row_number)
        val player1Box: Button = itemView.findViewById(R.id.player1_score_box)
        val player2Box: Button = itemView.findViewById(R.id.player2_score_box)
        private val player3Box: Button = itemView.findViewById(R.id.player3_score_box)
        private val player4Box: Button = itemView.findViewById(R.id.player4_score_box)
        private val player5Box: Button = itemView.findViewById(R.id.player5_score_box)

        init {
            when (numberOfPlayers) {
                2 -> {
                    player3Box.visibility = View.GONE
                    player4Box.visibility = View.GONE
                    player5Box.visibility = View.GONE
                }
                3 -> {
                    player4Box.visibility = View.GONE
                    player5Box.visibility = View.GONE
                }
                4 -> player5Box.visibility = View.GONE
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.game_row, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rowNumber.text = numberOfRows[position].toString()
    }

    override fun getItemCount(): Int {
        return numberOfRows.size
    }

}
