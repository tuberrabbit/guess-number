package com.github.tuberrabbit;

import java.util.Scanner;

/**
 * Created by btu on 3/10/15.
 */
public class GuessNumber {

    private final String INVALID_FORMAT = "输入不正确，重新输入";
    private final int GUESS_COUNT = 6;
    private final int LENGTH = 4;
    private String answer;
    private int guessCount = 0;

    public GuessNumber(String answer) {
        this.answer = answer;
    }

    public static void main(String[] asdf) {
        GuessNumber guessNumber = new GuessNumber("1234");
        Scanner scanner = new Scanner(System.in);
        while (guessNumber.guessCount < guessNumber.GUESS_COUNT && scanner.hasNext()) {
            String result = guessNumber.guess(scanner.nextLine());
            System.out.println(result);
            if (result.equals("4A0B")) {
                break;
            }
        }
        if (guessNumber.guessCount >= guessNumber.GUESS_COUNT) {
            System.out.println("失败");
        }
    }

    public String guess(String input) {
        if (!isValid(input)) {
            return INVALID_FORMAT;
        }
        guessCount++;
        int aCount = 0;
        int bCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == answer.charAt(i)) {
                aCount++;
            } else {
                for (int j = 0; j < answer.length(); j++) {
                    if (input.charAt(i) == answer.charAt(j)) {
                        bCount++;
                        break;
                    }
                }
            }
        }
        return aCount + "A" + bCount + "B";
    }

    private boolean isValid(String input) {
        return hasValidLength(input) && !hasDuplicateDigital(input);
    }

    private boolean hasDuplicateDigital(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (hasSameDigitalWith(i, input)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSameDigitalWith(int i, String input) {
        for (int j = i + 1; j < input.length(); j++) {
            if (input.charAt(i) == input.charAt(j)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasValidLength(String input) {
        return input.length() == LENGTH;
    }
}
