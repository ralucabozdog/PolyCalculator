package model.operations.operations_monomial;

import model.datastructures.Monomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractMonomialTest {

    @Test
    void calculate() {
        Monomial m1 = new Monomial(2, 3);
        Monomial m2 = new Monomial(15,3);

        SubtractMonomial subtract = new SubtractMonomial();

        assertEquals(-13, subtract.calculate(m1, m2).getCoefficient());
        assertEquals(3, subtract.calculate(m1, m2).getPower());
    }
}