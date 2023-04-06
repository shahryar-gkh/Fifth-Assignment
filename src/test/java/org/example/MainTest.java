package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void additionTest() {
        Main calculator = new Main();
        assertEquals(6, calculator.addition(2,3));
    }
}