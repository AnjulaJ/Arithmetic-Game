package com.example.thegame
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var about: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        about = findViewById(R.id.about_btn)
        val game =findViewById<Button>(R.id.new_btn)

        about.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.about_window)

            val btnClose = dialog.findViewById<ImageView>(R.id.btnClose)
            val btnDismiss = dialog.findViewById<Button>(R.id.btnDismiss)

            btnDismiss.setOnClickListener {
                dialog.dismiss()
            }
            btnClose.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()

        }

        game.setOnClickListener {
            val intent = Intent(this, GameScreen::class.java)
            startActivity(intent)
        }
    }
}