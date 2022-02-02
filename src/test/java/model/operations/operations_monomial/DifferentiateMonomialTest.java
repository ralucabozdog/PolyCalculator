package model.operations.operations_monomial;

import model.datastructures.Monomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DifferentiateMonomialTest {

    @Test
    void calculate() {
        Monomial m1 = new Monomial(2, 3);

        DifferentiateMonomial differentiate = new DifferentiateMonomial();

        assertEquals(6, differentiate.calculate(m1, m1).getCoefficient());
        assertEquals(2, differentiate.calculate(m1, m1).getPower());
    }
}