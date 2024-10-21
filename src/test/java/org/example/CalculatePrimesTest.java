package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

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

}