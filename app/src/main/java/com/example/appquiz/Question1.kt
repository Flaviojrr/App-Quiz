package com.example.appquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Question1 : AppCompatActivity() {
    private lateinit var myButton: Button
    private lateinit var myRadioGroup: RadioGroup
    private lateinit var myCorrectResponse : RadioButton
    private var myPunctuation : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question1)
        myButton = findViewById<Button>(R.id.ActivityQuestion1_Button_SendResponse)
        myRadioGroup=findViewById<RadioGroup>(R.id.ActivityQuestion1_RadioGroup_ResponseGroup)
        myCorrectResponse=findViewById<RadioButton>(R.id.ActivityQuestion1_RadioButton_CorrectResponse)
        myButton.setOnClickListener{
            var myRadioButton = myRadioGroup.checkedRadioButtonId
            if(myRadioButton!=-1 && myRadioButton == myCorrectResponse.id){
                myPunctuation = intent.getIntExtra("Punctuation_Quiz",myPunctuation)
                exibirPopUp()
            }
        }
    }
    private fun exibirPopUp() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Resultado!!!")
        builder.setMessage("Respota Correta")
        builder.setPositiveButton("OK") { dialog, which ->
            val intent = Intent(this, Question2::class.java).apply {
                putExtra("Puctuantion_Quiz",myPunctuation)
            }
            startActivity(intent)
            dialog.dismiss() // Fecha o pop-up
        }
        val dialog = builder.create()
        dialog.show()
    }
}