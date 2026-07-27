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
public class ShiftCipherDecryptTest {
    
    private final ShiftCipher cipher = new ShiftCipher();

    @Order(1)
    @DisplayName("Valid Decryption Test")
    @ParameterizedTest(name = "TC{0}")
    @CsvSource({
        "1, KHOOR, 3, HELLO",
        "2, GDKKN, -1, HELLO",
        "3, WORLD, 0, WORLD",
        "4, ABC, 3, XYZ",
        "5, XYZ, -3, ABC",
        "6, school, -5, XHMTTQ",
    })

    void testDecryptionValid(
            int tc,
            String cipherText,
            int key,
            String expected) {

        String actual = cipher.decrypt(cipherText, key);

        System.out.printf(
                "TC%03d | Input=%s | Key=%d | Result=%s%n",
                tc, cipherText, key, actual);

        assertEquals(expected, actual);
    }

    @Order(2)
    @DisplayName("Invalid Decryption Test")
    @ParameterizedTest(name = "TC{0}")
    @CsvSource({
        "7, /+@_, 2",
        "8, 12345, 4",
        "9, TEST@, 2",
        "10, AB12, 5",
        "11, '', 5",
    })

    void testDecryptInvalid(
            int tc,
            String cipherText,
            int key) {

        System.out.printf(
                "TC%03d | Input=%s | Key=%d | Expect Exception%n",
                tc, cipherText, key);

        assertThrows(
                IllegalArgumentException.class,
                () -> cipher.decrypt(cipherText, key));
    }

    @Order(3)
    @Test
    @DisplayName("TC011 - cipherText = null")
    void testDecryptNullCipherText() {

        System.out.println("TC012 | Input=null | Key=5 | Expect Exception");

        assertThrows(
                IllegalArgumentException.class,
                () -> cipher.decrypt(null, 5));
    }
}
