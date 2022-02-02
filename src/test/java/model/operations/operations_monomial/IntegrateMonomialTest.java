package model.operations.operations_monomial;

import model.datastructures.Monomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegrateMonomialTest {

    @Test
    void calculate() {
        Monomial m1 = new Monomial(2, 3);

        IntegrateMonomial integrate = new IntegrateMonomial();

        assertEquals(0.5, integrate.calculate(m1, m1).getCoefficient(), 0.00001);
        assertEquals(4, integrate.calculate(m1, m1).getPower());
    }
}