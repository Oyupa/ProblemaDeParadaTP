package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverserTest {

    @Test
    void testCall1() {
        Reverser reverser = new Reverser("while(i<10){\ni++;");
        assertFalse(reverser.call());
    }
    @Test
    void testCall2() {
        Reverser reverser = new Reverser("while(i>10){");
        assertFalse(reverser.call());
    }

    @Test
    void testCall4() {
        Reverser reverser = new Reverser("Falla");
        assertFalse(reverser.call());
    }

}