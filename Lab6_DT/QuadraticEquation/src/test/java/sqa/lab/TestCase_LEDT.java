package sqa.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestCase_LEDT {

    private final QuadraticEquation quadraticEquation = new QuadraticEquation();

    @ParameterizedTest(name = "{0}")
    @CsvSource({
        "TC001, 0, 2, 5",
        "TC002, 1, 3, 1",
        "TC003, 1, 2, 1",
        "TC004, 1, 1, 1",
        "TC005, 0, 0, 5"
    })

    void testRootNature(String tc, int a, int b, int c) {
        RootNature result = quadraticEquation.determineRootNature(a, b, c);
        System.out.println(
            tc + ": a=" + a + ", b=" + b + ", c=" + c + " -> " + result
        );

        if (a == 0) {
            assertEquals(RootNature.NOT_QUADRATIC, result);
        } else if (b * b - 4 * a * c > 0) {
            assertEquals(RootNature.REAL_ROOTS, result);
        } else if (b * b - 4 * a * c == 0) {
            assertEquals(RootNature.EQUAL_ROOTS, result);
        } else {
            assertEquals(RootNature.IMAGINARY_ROOTS, result);
        }
    }

    @ParameterizedTest(name = "{0}")
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