package com.example.k2023_01_19b.score_q_track_models

class Score(val _score : Int) {
    private var score : Int = _score

    public fun getScore (): Int {
        return score
    }

    public fun incrementScore (by: Int) {
        score += by
    }
}