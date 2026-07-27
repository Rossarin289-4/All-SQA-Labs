package com.sqa.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CompetitionScoreTest {

    private final CompetitionScore competition = new CompetitionScore();

    @DisplayName("Valid Score Test")
    @ParameterizedTest(name = "TC{0}")
    @CsvSource({
        "1,100,200,300,300",
        "2,450,200,300,450",
        "3,100,480,300,480",
        "4,250,250,250,250",
        "5,0,100,200,200",
        "6,500,200,300,500"
    })
    void testFindMaxScore(
            int tc,
            int score1,
            int score2,
            int score3,
            int expected) {

        int actual = competition.findMaxScore(score1, score2, score3);

        System.out.printf(
            "TC%03d | Input=%d,%d,%d | Result=%d%n",
            tc, score1, score2, score3, actual
        );

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("TC007 - Valid Array Test")
    void testFindMaxScoreArray() {

        int[] scores = {100,200,300};

        int actual = competition.findMaxScore(scores);

        System.out.println(
            "TC007 | Input={100,200,300} | Result=" + actual
        );

        assertEquals(300, actual);
    }

    @Test
    @DisplayName("TC008 - Negative Score")
    void negativeScoreTest() {

        assertThrows(IllegalArgumentException.class, () ->
            competition.findMaxScore(-1,100,200)
        );

        System.out.println(
            "TC008 | Input=-1,100,200 | Result=IllegalArgumentException"
        );
    }

    @Test
    @DisplayName("TC009 - Score Over 500")
    void scoreOver500Test() {

        assertThrows(IllegalArgumentException.class, () ->
            competition.findMaxScore(501,100,200)
        );

        System.out.println(
            "TC009 | Input=501,100,200 | Result=IllegalArgumentException"
        );
    }

    @Test
    @DisplayName("TC010 - Null Array")
    void nullArrayTest() {

        assertThrows(IllegalArgumentException.class, () ->
            competition.findMaxScore((int[]) null)
        );

        System.out.println(
            "TC010 | Input=null | Result=IllegalArgumentException"
        );
    }

    @Test
    @DisplayName("TC011 - Array Less Than 3")
    void arrayLessThanThreeTest() {

        int[] scores = {100,200};

        assertThrows(IllegalArgumentException.class, () ->
            competition.findMaxScore(scores)
        );

        System.out.println(
            "TC011 | Input={100,200} | Result=IllegalArgumentException"
        );
    }

    @Test
    @DisplayName("TC012 - Array More Than 3")
    void arrayMoreThanThreeTest() {

        int[] scores = {100,200,300,400};

        assertThrows(IllegalArgumentException.class, () ->
            competition.findMaxScore(scores)
        );

        System.out.println(
            "TC012 | Input={100,200,300,400} | Result=IllegalArgumentException"
        );
    }
}