package com.example.thegame

import android.app.Dialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class GameScreen : AppCompatActivity() {

    private var randomNumber: Random = Random()
    private var lExpression =""
    private var rExpression =""
    private var lExpressionValue:Float = 1.1f
    private var rExpressionValue:Float = 1.1f

    var correctAnswers=0
    var wrongAnswers=0

    private var correctAnswer =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)

        var leftExp = findViewById<TextView>(R.id.exp_1)
        var rightExp = findViewById<TextView>(R.id.exp_2)
        var answer = findViewById<TextView>(R.id.resultView)

        var greater =findViewById<Button>(R.id.grt)
        var equal =findViewById<Button>(R.id.eq)
        var less =findViewById<Button>(R.id.less)

        while (lExpressionValue%1.0 !=0.0 || lExpressionValue>100 || rExpressionValue%1.0!=0.0 || rExpressionValue>100){
            lExpression=generate(1)
            rExpression=generate(2)
        }

        leftExp.text=lExpression
        rightExp.text=rExpression

        var timer = Timer(50000); //start timer
        timer.start()

        greater.setOnClickListener {
            if (correctAnswer=="greater"){
                answer.text="CORRECT!"
                answer.setTextColor(Color.GREEN)
                correctAnswers+=1

                if (correctAnswers %5==0){      //extend timer
                    val currentTime = timer.millisUntilFinished
                    timer.cancel()
                    timer = Timer(currentTime+10000);
                    timer.start()
                }

            }
            else{
                answer.text="WRONG!"
                answer.setTextColor(Color.RED)
                wrongAnswers+=1
            }
            popUp(answer,leftExp,rightExp)  // call popup window

        }
        equal.setOnClickListener {
            if (correctAnswer=="eq"){
                answer.text="CORRECT!"
                answer.setTextColor(Color.GREEN)
                correctAnswers+=1

                if (correctAnswers %5==0){      //extend timer
                    val currentTime = timer.millisUntilFinished
                    timer.cancel()
                    timer = Timer(currentTime+10000);
                    timer.start()
                }

            }
            else{
                answer.text="WRONG!"
                answer.setTextColor(Color.RED)
                wrongAnswers+=1
            }
            popUp(answer,leftExp,rightExp)  // call popup window

        }
        less.setOnClickListener {
            if (correctAnswer=="less"){
                answer.text="CORRECT!"
                answer.setTextColor(Color.GREEN)
                correctAnswers+=1

                if (correctAnswers %5==0){      //extend timer
                    val currentTime = timer.millisUntilFinished
                    timer.cancel()
                    timer = Timer(currentTime+10000);
                    timer.start()
                }

            }
            else{
                answer.text="WRONG!"
                answer.setTextColor(Color.RED)
                wrongAnswers+=1
            }
            popUp(answer,leftExp,rightExp)  // call popup window
        }

    }
    //generate arithmetic expressions
    private fun generate(eType:Int): String {

        val operations = listOf("+","-","*","/")
        var expression =""

        var term1=(1 + randomNumber.nextInt(20)).toString()
        var term2=(1 + randomNumber.nextInt(20)).toString()
        var term3=(1 + randomNumber.nextInt(20)).toString()
        var term4=(1 + randomNumber.nextInt(20)).toString()

        var op1 =operations.random()
        var op2 =operations.random()
        var op3 =operations.random()

        var termType = 1+ randomNumber.nextInt(4)

        if (termType==1){  //a
            expression=term1
        }
        else if (termType==2){  // a+b
            expression ="$term1$op1$term2"

        }
        else if (termType==3){   // (a+b)+c
            expression ="($term1$op1$term2)$op2$term3"
        }
        else if (termType==4){      //  ((a +b)+c)+d
            expression = "(($term1$op1$term2)$op2$term3)$op3$term4"
        }

        // create Expression values
        if (eType==1){
            lExpressionValue=Value().setValue(termType=termType,term1=term1,term2=term2,term3=term3,term4=term4, op1 = op1, op2 = op2, op3 = op3)
        }
        else if (eType==2){
            rExpressionValue=Value().setValue(termType=termType,term1=term1,term2=term2,term3=term3,term4=term4, op1 = op1, op2 = op2, op3 = op3)
        }
        result()
        return expression
    }

    private fun result(){
        if (lExpressionValue==rExpressionValue){
            correctAnswer="eq"
        }
        else if (lExpressionValue>rExpressionValue){
            correctAnswer="greater"
        }
        else if (lExpressionValue<rExpressionValue){
            correctAnswer ="less"
        }
    }

    //Pop Up Window
    private fun popUp(answer:TextView, leftExp:TextView, rightExp:TextView){ //https://www.youtube.com/watch?v=aDy_Le25_hE

        var dialog = Dialog(this)
        dialog.setCancelable(false)
        // 'ok' button setup and textview
        dialog.setContentView(R.layout.popup_window)

        val btnOk = dialog.findViewById<Button>(R.id.ok)
        val popupMsg = dialog.findViewById<TextView>(R.id.popupTxt)
        popupMsg.setText(answer.text)   // set the popup massage same as textview
        popupMsg.setTextColor(answer.textColors)

        btnOk.setOnClickListener {
            dialog.dismiss()

            lExpressionValue=1.1f //reset values to run generate
            rExpressionValue=1.1f

            // generate random expressions again and set
            while (lExpressionValue%1.0 !=0.0 || lExpressionValue>100 || rExpressionValue%1.0!=0.0 || rExpressionValue>100){
                lExpression=generate(1)
                rExpression=generate(2)
            }

            answer.text="" //clear answer view

            leftExp.text=lExpression
            rightExp.text=rExpression
            result()
        }
        dialog.show()
    }

    //https://stackoverflow.com/questions/52647719/android-kotlin-countdown-timer-for-time-add

    inner class Timer(miliSeconds:Long) : CountDownTimer(miliSeconds,1000){

        var countDown= findViewById<TextView>(R.id.count)
        var millisUntilFinished:Long = 0
        override fun onFinish() {
            gameOver()
        }

        override fun onTick(millisUntilFinished: Long) {
            this.millisUntilFinished = millisUntilFinished
            countDown.text = ""+millisUntilFinished/1000
        }
    }

    fun gameOver(){
        var leftExp = findViewById<TextView>(R.id.exp_1)
        var rightExp = findViewById<TextView>(R.id.exp_2)

        var answer = findViewById<TextView>(R.id.resultView)

        var greater =findViewById<Button>(R.id.grt)
        var equal =findViewById<Button>(R.id.eq)
        var less =findViewById<Button>(R.id.less)
        var counter = findViewById<TextView>(R.id.count)
        var countDown = findViewById<TextView>(R.id.count)
        var results = findViewById<TextView>(R.id.results)
        var gOverView = findViewById<TextView>(R.id.gOver)

        leftExp.visibility=View.INVISIBLE
        rightExp.visibility=View.INVISIBLE
        answer.visibility=View.INVISIBLE
        greater.visibility=View.INVISIBLE
        equal.visibility=View.INVISIBLE
        leftExp.visibility=View.INVISIBLE
        less.visibility=View.INVISIBLE
        counter.visibility=View.INVISIBLE
        countDown.visibility=View.INVISIBLE

        gOverView.visibility=View.VISIBLE
        results.visibility=View.VISIBLE

        results.text="Correct Answers = $correctAnswers \n Incorrect Answers = $wrongAnswers"

    }
}