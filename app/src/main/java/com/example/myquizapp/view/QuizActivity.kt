package com.example.myquizapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myquizapp.QuizRecyclerViewAdapter
import com.example.myquizapp.viewModel.QuizViewModel
import com.example.myquizapp.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    private lateinit var quizViewModel: QuizViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quizViewModel = ViewModelProvider(this)[QuizViewModel::class.java]


        binding.rvQuiz.layoutManager = LinearLayoutManager(this)
        val adapter = QuizRecyclerViewAdapter(quizViewModel.questions,quizViewModel.options,quizViewModel.selectedAnswers)
        binding.rvQuiz.adapter = adapter

        binding.btnSubmit.setOnClickListener {
            val score = quizViewModel.getScore()
            val totalQuestions = quizViewModel.questions.size
            val intent = Intent(this, ScoreBoardActivity::class.java)
            intent.putExtra("SCORE", score)
            intent.putExtra("TOTAL_QUESTIONS", totalQuestions)
            startActivity(intent)
            finish()
        }
    }
}