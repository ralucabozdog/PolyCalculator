package model.operations.operations_polynomial;

import model.datastructures.Monomial;
import model.datastructures.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DifferentiatePolynomialTest {

    @Test
    void calculate() {
        Polynomial p1 = new Polynomial();
        Polynomial result = new Polynomial();

        p1.getMonomialList().add(new Monomial(1, 4));
        p1.getMonomialList().add(new Monomial(3, 3));
        p1.getMonomialList().add(new Monomial(-8, 2));
        p1.getMonomialList().add(new Monomial(5, 1));
        p1.getMonomialList().add(new Monomial(1,0));

        //p1 = x^4 + 3x^3 - 8x^2 + 5x + 1

        result.getMonomialList().add(new Monomial(4, 3));
        result.getMonomialList().add(new Monomial(9, 2));
        result.getMonomialList().add(new Monomial(-16, 1));
        result.getMonomialList().add(new Monomial(5, 0));

        // d/dx * p1 = 4x^3 + 9x^2 - 16x + 5

        DifferentiatePolynomial differentiate = new DifferentiatePolynomial();

        assertTrue(differentiate.calculate(p1, p1).get(0).compareTo(result) == 0);
    }
}