package com.sqa.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShiftCipherEncryptTest {

    private final ShiftCipher cipher = new ShiftCipher();

    @Order(1)
    @DisplayName("Valid Encryption Test")
    @ParameterizedTest(name = "TC{0}")
    @CsvSource({
        "1, ATTACK, 17, RKKRTB",
        "2, LOVE, -2, JMTC",
        "3, COMPUTER, -5, XJHKPOZM",
        "4, ZOO, 8, HWW",
        "5, Student, 5, XYZIJSY"
    })

    void testEncryptValid(
            int tc,
            String plainText,
            int key,
            String expected) {

        String actual = cipher.encrypt(plainText, key);

        System.out.printf(
                "TC%03d | Input=%s | Key=%d | Result=%s%n",
                tc, plainText, key, actual);

        assertEquals(expected, actual);
    }

    @Order(2)
    @DisplayName("Invalid Encryption Test")
    @ParameterizedTest(name = "TC{0}")
    @CsvSource({
        "6, NURS@-, 1",
        "7, 123, 8",
        "8, ABC#, 5",
        "9, RI02, 1",
        "10, '', 2"
    })

    void testEncryptInvalid(
            int tc,
            String plainText,
            int key) {

        System.out.printf(
                "TC%03d | Input=%s | Key=%d | Expect Exception%n",
                tc, plainText, key);

        assertThrows(
                IllegalArgumentException.class,
                () -> cipher.encrypt(plainText, key));
    }

    @Order(3)
    @Test
    @DisplayName("TC011 - plainText = null")
    void testEncryptNullPlainText() {

        System.out.println("TC011 | Input=null | Key=5 | Expect Exception");

        assertThrows(
                IllegalArgumentException.class,
                () -> cipher.encrypt(null, 5));
    }
}