package com.advinity.carbonteam.hydrocarbon.modal;

import java.util.List;

/**
 * Created by afdolash on 18/12/16.
 */

public class Answer {
    private int id;
    private String range;
    private String answer;

    public Answer(int id, String range, String answer) {
        this.id = id;
        this.range = range;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
