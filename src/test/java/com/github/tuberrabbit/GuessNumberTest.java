package com.github.tuberrabbit;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by btu on 3/10/15.
 */
public class GuessNumberTest
{
    @Test
    public void should_return_4A0B_when_all_number_are_correct()
    {
        //given
        String arr = "1234";
        //when
        GuessNumber guessNumber = new GuessNumber();
        String result = guessNumber.guess(arr);
        //then
        assertThat(result, is("4A0B"));
    }
}
