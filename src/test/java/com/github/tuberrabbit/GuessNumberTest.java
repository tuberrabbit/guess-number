package com.github.tuberrabbit;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GuessNumberTest
{
    @Test
    public void should_return_4A0B_when_all_number_are_correct()
    {
        //given
        String input = "1234";
        //when
        GuessNumber guessNumber = new GuessNumber();
        String result = guessNumber.guess(input);
        //then
        assertThat(result, is("4A0B"));
    }
}
