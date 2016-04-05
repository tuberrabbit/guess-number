package com.github.tuberrabbit;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
        game.setActualAnswer("1 2 3 4");

    }

    @Test
    public void should_return_4A0B_when_guess_all_numbers_correctly() {
        String inputAnswer = "1 2 3 4";

        assertThat(game.guess(inputAnswer), is("4A0B"));
    }

    @Test
    public void should_return_0A0B_when_no_number_is_correctly() {
        String inputAnswer = "5 6 7 8";

        assertThat(game.guess(inputAnswer), is("0A0B"));
    }

    @Test
    public void should_return_0A4B_when_all_numbers_are_correctly_but_locations_are_error() {
        String inputAnswer = "4 3 2 1";
        assertThat(game.guess(inputAnswer), is("0A4B"));

    }

    @Test
    public void should_return_1A2B_when_particial_numbers_are_correctly() {
        String inputAnswer = "0 3 2 4";
        assertThat(game.guess(inputAnswer), is("1A2B"));

    }
}
