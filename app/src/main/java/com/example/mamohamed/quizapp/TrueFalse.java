package com.example.mamohamed.quizapp;

/**
 * Created by mamohamed on 2/24/2018.
 */

public class TrueFalse {
    private int mQuestionId;
    private boolean mAnswer;

    public TrueFalse(int mQuestionId, boolean mAnswer) {
        this.mQuestionId = mQuestionId;
        this.mAnswer = mAnswer;
    }

    public int getmQuestionId() {
        return mQuestionId;
    }

    public void setmQuestionId(int mQuestionId) {
        this.mQuestionId = mQuestionId;
    }

    public boolean ismAnswer() {
        return mAnswer;
    }

    public void setmAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }
}
