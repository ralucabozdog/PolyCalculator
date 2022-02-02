package model.operations.operations_monomial;

import model.datastructures.Monomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyMonomialTest {

    @Test
    void calculate() {
        Monomial m1 = new Monomial(2, 3);
        Monomial m2 = new Monomial(15,4);

        MultiplyMonomial multiply = new MultiplyMonomial();

        assertEquals(30, multiply.calculate(m1, m2).getCoefficient());
        assertEquals(7, multiply.calculate(m1, m2).getPower());
    }
}