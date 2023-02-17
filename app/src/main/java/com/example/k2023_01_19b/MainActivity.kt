package com.example.k2023_01_19b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.text.set
import com.example.k2023_01_19b.score_q_track_models.AllQuestions
import com.example.k2023_01_19b.score_q_track_models.Score

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionArea: EditText
    private lateinit var scoreArea: EditText
    private var questionNumber: Int = 0

    private val TAG: String = "ON_CREATE"

    private var questions: AllQuestions = AllQuestions()
    private var score: Score = Score(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i(TAG, "Activity (re)-created")

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        questionArea = findViewById(R.id.question_area)
        scoreArea = findViewById(R.id.score_view)

        trueButton.setOnClickListener (
            View.OnClickListener {
                if (questions.listOfQuestions[questionNumber].isTrue) {
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                    score.incrementScore(1)
                    scoreArea.setText(score.getScore().toString())
                } else {
                    Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
                }
            }
        )

        falseButton.setOnClickListener(
            View.OnClickListener {
                if (! questions.listOfQuestions[questionNumber].isTrue) {
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                    score.incrementScore(1)
                    scoreArea.setText(score.getScore().toString())
                } else {
                    Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
                }
            }
        )

        nextButton.setOnClickListener(
            View.OnClickListener {
                questionNumber = (questionNumber +1) % questions.listOfQuestions.size
                questionArea.setText(questions.listOfQuestions[questionNumber].questionID)
            }
        )

    }
}