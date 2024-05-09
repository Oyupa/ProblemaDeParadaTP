package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HaltCheckerTest {

    @Test
    void testCall1() {
        HaltChecker haltChecker = new HaltChecker("while(i<10){\ni++;", "5");
        assertTrue(haltChecker.call());
    }
    @Test
    void testCall2() {
        HaltChecker haltChecker = new HaltChecker("while(i<10){\ni++;", "15");
        assertFalse(haltChecker.call());
    }

    @Test
    void testCall4() {
        HaltChecker haltChecker = new HaltChecker("while(i>10){\ni++;", "15");
        assertTrue(haltChecker.call());
    }

    @Test
    void testCall8() {
        HaltChecker haltChecker = new HaltChecker("while(i>10){\ni++;", "0");
        assertTrue(haltChecker.call());
    }

    @Test
    void testCall9() {
        HaltChecker haltChecker = new HaltChecker("while(i>10){\ni--;", "-1");
        assertFalse(haltChecker.call());
    }

    @Test
    void testCall10() {
        HaltChecker haltChecker = new HaltChecker("while(i<10){\ni--;", "0");
        assertTrue(haltChecker.call());
    }
}