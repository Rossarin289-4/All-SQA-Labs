package com.health.fitness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HealthIndexScoreNormalBoundaryTest {
    @ParameterizedTest(name = "TC{00}")
    @CsvSource({
        //TC001
        "1,42, 130, 21, 8, STANDARD",
        
        //TC002-TC003
        "2,25,130,21,6, STANDARD",
        "3,26,130,21,6, STANDARD",
        
        //TC004-TC005
        "4,59,130,21,9, STANDARD",
        "5,60,130,21,9, STANDARD",
        
        //TC006-TC007
        "6,42,40,21,12, EXCELLENT",
        "7,42,41,21,12, EXCELLENT",
        
        //TC008-TC009
        "8,42,219,21,8, STANDARD",
        "9,42,220,21,8, STANDARD",

        //TC010-TC011
        "10,42,130,12,7, STANDARD",
        "11,42,130,13,7, STANDARD",
        
        //TC012-TC013
        "12,42,130,29,9, STANDARD",
        "13,42,130,30,9, STANDARD" })
        
        void testNormalBoundary(int tc, double vo2, int rhr, int hrr, int expectedScore, HealthIndexScore.FitnessLevel expectedLevel) {
            HealthIndexScore health = new HealthIndexScore(vo2, rhr, hrr);
            
            System.out.printf(
                "TC%03d | VO2=%.0f | RHR=%d | HRR=%d | Score=%d | Level=%s%n",
                    tc,
                    vo2,
                    rhr,
                    hrr,
                    health.getTotalScore(),
                    health.getFitnessLevel()
            );

            assertEquals(expectedScore, health.getTotalScore());
            assertEquals(expectedLevel, health.getFitnessLevel());
        }
    
}
