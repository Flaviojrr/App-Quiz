package com.example.appquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog

class Question4 : AppCompatActivity() {
    private lateinit var myButton: Button
    private lateinit var myRadioGroup: RadioGroup
    private lateinit var myCorrectResponse : RadioButton
    private var myPunctuation : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question4)
        myButton = findViewById<Button>(R.id.ActivityQuestion4_Button_SendResponse)
        myRadioGroup=findViewById<RadioGroup>(R.id.ActivityQuestion4_RadioGroup_ResponseGroup)
        myCorrectResponse=findViewById<RadioButton>(R.id.ActivityQuestion4_RadioButton_CorrectResponse)
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
            startActivity(Intent(this,Question5::class.java))
            dialog.dismiss() // Fecha o pop-up
        }
        val dialog = builder.create()
        dialog.show()
    }
}