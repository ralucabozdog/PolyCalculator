package model.operations.operations_monomial;

import model.datastructures.Monomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideMonomialTest {

    @Test
    void calculate() {
        Monomial m1 = new Monomial(35, 7);
        Monomial m2 = new Monomial(4,3);

        DivideMonomial divide = new DivideMonomial();

        assertEquals(8.75, divide.calculate(m1, m2).getCoefficient(), 0.00001);
        assertEquals(4, divide.calculate(m1, m2).getPower());
    }
}