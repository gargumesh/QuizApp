package com.example.myquizapp.viewModel

import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    val questions = listOf<String>(
        "Who is the founder of Android?",
        "Who is the founder of Microsoft?",
        "Which of the following virtual machine is used by the Android operating system?",
        "Which of the following kernel is used in Android?",
        "Which of the following is the first callback method that is invoked by the system during an activity life-cycle?"
    )

    val options = listOf(
        listOf("Andy Rubin", "Jeff Bezos", "Mark Zuckerberg", "Linus Torvalds"),
        listOf("Steve Jobs", "Bill Gates", "Mark Zuckerberg", "Elon Musk"),
        listOf("JVM", "Dalvik virtual machine", "Simple virtual machine", "None of the above"),
        listOf("MAC", "Windows", "Linux", "Redhat"),
        listOf("onClick() method", "onCreate() method", "onStart() method", "onResume() method")
    )

    val correctAnswers = listOf(0, 1, 1, 2, 1)  // Index of correct options
    var selectedAnswers = IntArray(questions.size) { -1 }

    fun getScore():Int {
        var score = 0
        for (i in questions.indices) {
            if (selectedAnswers[i] == correctAnswers[i]) {
                score++;
            }
        }
        return score
    }
}