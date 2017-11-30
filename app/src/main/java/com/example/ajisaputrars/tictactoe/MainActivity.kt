package com.example.ajisaputrars.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    protected fun pressed(view:View){
        val buttonSelected = view as Button
        var cellID=0

        when(buttonSelected.id){
            R.id.b1 -> cellID = 1
            R.id.b2 -> cellID = 2
            R.id.b3 -> cellID = 3
            R.id.b4 -> cellID = 4
            R.id.b5 -> cellID = 5
            R.id.b6 -> cellID = 6
            R.id.b7 -> cellID = 7
            R.id.b8 -> cellID = 8
            R.id.b9 -> cellID = 9
        }
        game(cellID, buttonSelected)
        checkWinner()
    }

    val player1 = ArrayList<Int>()
    val player2 = ArrayList<Int>()
    var activePlayer = 1


    protected fun game(cellID:Int, buttonSelected:Button){

        buttonSelected.isEnabled = false

        if (activePlayer == 1) {
            buttonSelected.text = "X"
            buttonSelected.setBackgroundColor(Color.CYAN)
            player1.add(cellID)
            activePlayer = 2
        }

        else {
            buttonSelected.text = "O"
            buttonSelected.setBackgroundColor(Color.GREEN)
            player2.add(cellID)
            activePlayer = 1
        }
    }
    protected fun checkWinner(){
        var winner = 0

        if(player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }

        if(player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        if(player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }

        if(player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        if(player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        if(player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }

        if(player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        if(player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }

        if(player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        if(player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }

        if(player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        if(player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }

        if(player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }


        if (winner != 0) {
            Toast.makeText(this, "The Winner is = " +winner, Toast.LENGTH_SHORT).show()
        }
    }
}