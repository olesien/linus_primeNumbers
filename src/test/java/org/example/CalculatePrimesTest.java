package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalculatePrimesTest {

    CalculatePrimes calc = null;
    @BeforeEach
    public void setUp(){
        calc = new CalculatePrimes();
    }

    @Test
    @DisplayName("Negative is invalid")
    void testThatNegativeIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calculate(-1, 1000);
        });
    }

    @Test
    @DisplayName("Minimum is zero")
    void testThatMinIsZero() {
        assertDoesNotThrow(() -> {
            calc.calculate(0, 1000);
        });
    }

    @Test
    @DisplayName("Maximum is one thousand")
    void testThatMaxIsOneThousand() {
        assertDoesNotThrow(() -> {
            calc.calculate(0, 1000);
        });
    }

    @Test
    @DisplayName("Over one thousand is invalid")
    void testThatOverOneThousandIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calculate(0, 1001);
        });
    }

    @Test
    @DisplayName("Zero to ten is four values")
    void testThatZeroToTenIsFourLength() {
        assertEquals(4, calc.calculate(0, 10).size());
    }
    @Test
    @DisplayName("Maximum range is 168 values")
    void testThatFullRangeIs168Length() {
        assertEquals(168, calc.calculate(0, 1000).size());
    }

    @Test
    @DisplayName("Half is 95")
    void testThatHalfRangeIs95Length() {
        assertEquals(95, calc.calculate(0, 500).size());
    }

    @Test
    @DisplayName("Full calculation is under 1 second in compute time")
    void testThatFullRangeIsWithinOneSecond() {
        assertTimeout(Duration.ofSeconds(1), () -> {
                calc.calculate(0, 1000);
        });
    }

    @Test
    @DisplayName("Sum of zero to ten is seventeen")
    void testThatSumOfZeroToTenIsSeventeen() {
        assertEquals(17, calc.sumNumbers(calc.calculate(0, 10)));
    }

    @Test
    @DisplayName("Sum of zero to zero is zero")
    void testThatSumOfZeroToZeroIsZero() {
        assertEquals(0, calc.sumNumbers(calc.calculate(0, 0)));
    }

    @Test
    @DisplayName("Five to 995 Is 165")
    void testThatFiveTo995Is165Length() {
        assertEquals(165, calc.calculate(5, 995).size());
    }
}