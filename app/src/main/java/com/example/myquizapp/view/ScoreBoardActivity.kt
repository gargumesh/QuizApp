package com.example.myquizapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.myquizapp.R
import com.example.myquizapp.databinding.ActivityScoreBoardBinding

class ScoreBoardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScoreBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val score = intent.getIntExtra("SCORE", 0)
        val totalQuestions = intent.getIntExtra("TOTAL_QUESTIONS", 0)

        binding.tvScore.text = "$score/$totalQuestions"

        binding.btnGoBack.setOnClickListener {
            // Go back to the MainActivity
            finish()
        }
    }
}