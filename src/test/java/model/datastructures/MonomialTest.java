package model.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonomialTest {

    @Test
    void getCoefficient() {
        Monomial m = new Monomial(4.51234, 9);
        assertEquals(4.51233, m.getCoefficient(), 0.001);
    }

    @Test
    void setCoefficient() {
        Monomial m = new Monomial(15, 3);
        m.setCoefficient(8);
        assertEquals(8, m.getCoefficient());
    }

    @Test
    void getPower() {
        Monomial m = new Monomial(15, 3);
        assertEquals(3, m.getPower());
    }

    @Test
    void setPower() {
        Monomial m = new Monomial(15, 3);
        m.setPower(100);
        assertEquals(100, m.getPower());
    }

    @Test
    void compareTo() {
        Monomial mSmaller = new Monomial(15, 3);
        Monomial mEqual = new Monomial(10, 3);
        Monomial mGreater = new Monomial(15, 5);

        assertEquals(mSmaller.compareTo(mGreater), -1);
        assertEquals(mGreater.compareTo(mSmaller), 1);
        assertEquals(mSmaller.compareTo(mEqual), 0);
    }

    @Test
    void print() {
        Monomial m = new Monomial(-1, 1);
        assertTrue(m.print().equals("- x"));

        Monomial mFloat = new Monomial(1.0/3, 2);
        assertTrue(mFloat.print().equals("+ 0,3333x^2"));
    }
}