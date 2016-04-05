package com.github.tuberrabbit;

public class Game {
    private String actualAnswer;

    public void setActualAnswer(String actualAnswer) {
        this.actualAnswer = actualAnswer;
    }

    public String guess(String inputAnswer) {
        int aAccount = 0;
        int bAccount = 0;

        for (int i = 0; i < inputAnswer.length(); i += 2) {
            if (inputAnswer.charAt(i) == actualAnswer.charAt(i)) {
                aAccount++;
            } else if (actualAnswer.contains(inputAnswer.subSequence(i, i + 1))) {
                bAccount++;
            }
        }

        return aAccount + "A" + bAccount + "B";
    }
}
