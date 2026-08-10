package sqa.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestCase_EEDT {
    private final QuadraticEquation quadraticEquation = new QuadraticEquation();

    @ParameterizedTest
    @CsvSource({
        "TC001, 0, 2, 5, NOT_QUADRATIC",
        "TC002, 0, 0, 5, NOT_QUADRATIC",
        "TC003, 1, 3, 1, REAL_ROOTS",
        "TC004, 1, 2, 1, EQUAL_ROOTS",
        "TC005, 1, 1, 1, IMAGINARY_ROOTS"
    })

    void testRootNature(
        String tc, int a, int b, int c,
        RootNature expected) {
            RootNature result = quadraticEquation.determineRootNature(a, b, c);
            System.out.println(
                tc + ": a=" + a + ", b=" + b + ", c=" + c + " -> " + result
            );
            assertEquals(expected, result);
        }

    @ParameterizedTest
    @CsvSource({
        "TC006, -1, 1, 1"
    })
    void testImpossible(String tc, int a, int b, int c) {
        System.out.println(
            tc + ": a=" + a + ", b=" + b + ", c=" + c + " -> Impossible"
        );
        assertThrows(IllegalArgumentException.class, () -> {
            quadraticEquation.determineRootNature(a, b, c);
        });
    }
}