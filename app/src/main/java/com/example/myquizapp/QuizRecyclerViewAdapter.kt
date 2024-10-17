package com.example.myquizapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myquizapp.databinding.RvQuizItemBinding

class QuizRecyclerViewAdapter(
    private val questions: List<String>,
    private val options: List<List<String>>,
    private val selectedAnswers: IntArray
): RecyclerView.Adapter<QuizRecyclerViewAdapter.QuizViewHolder>() {

    inner class QuizViewHolder(private val binding:RvQuizItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(question: String, options: List<String>, position: Int){
            binding.tvQuestion.text = question
            binding.rbOption1.text = options[0]
            binding.rbOption2.text = options[1]
            binding.rbOption3.text = options[2]
            binding.rbOption4.text = options[3]

            binding.rgOptions.clearCheck()
            when (selectedAnswers[position]) {
                0 -> binding.rgOptions.check(R.id.rb_Option1)
                1 -> binding.rgOptions.check(R.id.rb_Option2)
                2 -> binding.rgOptions.check(R.id.rb_Option3)
                3 -> binding.rgOptions.check(R.id.rb_Option4)
            }

            //save selection
            binding.rgOptions.setOnCheckedChangeListener{_,checkedId->
                selectedAnswers[position] = when (checkedId) {
                    R.id.rb_Option1 -> 0
                    R.id.rb_Option2 -> 1
                    R.id.rb_Option3 -> 2
                    R.id.rb_Option4 -> 3
                    else -> -1
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val binding = RvQuizItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuizViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        holder.bind(questions[position],options[position],position)
    }

}