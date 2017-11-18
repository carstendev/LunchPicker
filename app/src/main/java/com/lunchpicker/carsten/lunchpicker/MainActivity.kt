package com.lunchpicker.carsten.lunchpicker

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val foods = arrayListOf("Asia-Food", "Pizza", "B&J", "BurgerKing")
    private val random = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun decide(view: View) {
        val decision = foods[random.nextInt(foods.size)]
        selectedFoodTxt.text = decision
    }

    fun addFood(view: View) {
        val foodTxt = addFoodTxt.text.toString()

        when {
            foodTxt.isNotEmpty() and foods.contains(foodTxt).not() -> {
                foods.add(foodTxt)
                Toast.makeText(applicationContext, "Food added", Toast.LENGTH_SHORT).show()
            }
            else -> addFoodTxt.error = "Please provide food!"
        }
    }

}
