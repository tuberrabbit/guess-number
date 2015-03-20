package com.github.tuberrabbit;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GuessNumberTest {

    private GuessNumber guessNumber;

    @Before
    public void setUp() {
        guessNumber = new GuessNumber("1234");
    }

    @Test
    public void should_return_4A0B_when_all_number_are_correct() {
        assertThat(guessNumber.guess("1234"), is("4A0B"));
    }

    @Test
    public void should_return_msg_like_xAxB_when_given_valid_format_but_error_number() {
        assertThat(guessNumber.guess("1567"), is("1A0B"));
        assertThat(guessNumber.guess("2478"), is("0A2B"));
        assertThat(guessNumber.guess("0324"), is("1A2B"));
        assertThat(guessNumber.guess("4321"), is("0A4B"));
    }

    @Test
    public void should_return_invalid_format_msg_when_given_invalid_format() {
        assertThat(guessNumber.guess("1123"), is("输入不正确，重新输入"));
        assertThat(guessNumber.guess("12"), is("输入不正确，重新输入"));
    }

    @Test
    public void should_return_failure_msg_when_given_wrong_answer_in_6th_times() {
        guessNumber.guess("1567");
        guessNumber.guess("1567");
        guessNumber.guess("1567");
        guessNumber.guess("1567");
        guessNumber.guess("1567");

        assertThat(guessNumber.guess("1567"), is("1A0B"));
    }
}
