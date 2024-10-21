package org.example;

import org.junit.jupiter.api.BeforeEach;
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
    void testThatMinIsZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calculate(-1, 1000);
        });
    }

    @Test
    void testThatMaxIsOneThousand() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calculate(0, 1001);
        });
    }

    @Test
    void testThatZeroToTenIsFourLength() {
        assertEquals(4, calc.calculate(0, 10).size());
    }
    @Test
    void testThatFullRangeIs168Length() {
        assertEquals(168, calc.calculate(0, 1000).size());
    }

    @Test
    void testThatFullRangeIsWithinOneSecond() {
        assertTimeout(Duration.ofSeconds(1), () -> {
                calc.calculate(0, 1000);
        });
    }

    @Test
    void testThatSumOfZeroToTenIsSeventeen() {
        assertEquals(17, calc.sumNumbers(calc.calculate(0, 10)));
    }

    @Test
    void testThatSumOfZeroToZeroIsZero() {
        assertEquals(0, calc.sumNumbers(calc.calculate(0, 0)));
    }

}