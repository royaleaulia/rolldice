package com.example.tugasroledice

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        val rollButton: Button = findViewById(R.id.let_roll)
        rollButton.setOnClickListener { roll() }


    }

    private fun roll(){
        var dadulagi1 = diceroll1()
        var dadulagi2 = diceroll2()

        if (dadulagi1 == dadulagi2){
            Toast.makeText(this,"Selamat anda dapat dadu double!", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "Anda belum beruntung!", Toast.LENGTH_LONG).show()
        }

    }


    private fun diceroll1(): Int {
        val dice1 = Dice(6)
        val diceRoll1 = dice1.roll()

        val diceImage1: ImageView = findViewById(R.id.dice_image1)

        val drawableResource1 = when (diceRoll1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage1.setImageResource(drawableResource1)
        diceImage1.contentDescription = diceRoll1.toString()
        return diceRoll1
    }

    private fun diceroll2(): Int {
        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()

        val diceImage2: ImageView = findViewById(R.id.dice_image2)

        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage2.setImageResource(drawableResource2)
        diceImage2.contentDescription = diceRoll2.toString()
        return diceRoll2
    }

}


class Dice(private val numSides: Int) {

    /**
     * Do a random dice roll and return the result.
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}

