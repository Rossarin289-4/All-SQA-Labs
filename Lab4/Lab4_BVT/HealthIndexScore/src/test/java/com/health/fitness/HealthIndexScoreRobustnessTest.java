package com.health.fitness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HealthIndexScoreRobustnessTest {

    @Order(1)
    @ParameterizedTest(name = "TC{0}")
    @CsvSource({
        "1,42,130,21,8,STANDARD",
        "2,25,130,21,6,STANDARD",
        "3,26,130,21,6,STANDARD",
        "4,59,130,21,9,STANDARD",
        "5,60,130,21,9,STANDARD",
        "6,42,40,21,12,EXCELLENT",
        "7,42,41,21,12,EXCELLENT",
        "8,42,219,21,8,STANDARD",
        "9,42,220,21,8,STANDARD",
        "10,42,130,12,7,STANDARD",
        "11,42,130,13,7,STANDARD",
        "12,42,130,29,9,STANDARD",
        "13,42,130,30,9,STANDARD",
        "14,24,130,21,5,POOR",
        "15,61,130,21,10,STANDARD"
    })
    void testValidRobustness(int tc, double vo2, int rhr, int hrr, int expectedScore, HealthIndexScore.FitnessLevel expectedLevel) {
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

    @Order(2)
    @ParameterizedTest(name = "TC{0}")
    @CsvSource({
        "16,42,39,21",
        "17,42,221,21"
    })
    void testInvalidInput(int tc, double vo2, int rhr, int hrr) {
        System.out.printf(
            "TC%03d | VO2=%.0f | RHR=%d | HRR=%d | Expect Exception%n",
            tc, vo2, rhr, hrr
        );

        assertThrows(
            IllegalArgumentException.class,() -> new HealthIndexScore(vo2, rhr, hrr)
        );
    }

    @Order(3)
    @Test
    void TC018() {
        HealthIndexScore health = new HealthIndexScore(42,130,11);
        System.out.printf(
            "TC018 | VO2=42 | RHR=130 | HRR=11 | Score=%d | Level=%s%n",
            health.getTotalScore(),
            health.getFitnessLevel()
        );
        assertEquals(5, health.getTotalScore());
        assertEquals(HealthIndexScore.FitnessLevel.POOR, health.getFitnessLevel());
    }

    @Order(4)
    @Test
    void TC019() {
        //HealthIndexScore health = new HealthIndexScore(42,130,31);

        System.out.printf(
            "TC019 | VO2=42 | RHR=130 | HRR=31 | Expect Exception%n"
            //health.getTotalScore(),
            //health.getFitnessLevel()
        );
        assertThrows(
            IllegalArgumentException.class, () -> new HealthIndexScore(42,130,31)
        );
    }
    
}
