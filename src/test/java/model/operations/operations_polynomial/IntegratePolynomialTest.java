package model.operations.operations_polynomial;

import model.datastructures.Monomial;
import model.datastructures.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegratePolynomialTest {

    @Test
    void calculate() {
        Polynomial p1 = new Polynomial();
        Polynomial result = new Polynomial();

        p1.getMonomialList().add(new Monomial(4, 3));
        p1.getMonomialList().add(new Monomial(-13, 2));
        p1.getMonomialList().add(new Monomial(2, 1));
        p1.getMonomialList().add(new Monomial(-7,0));

        //p1 = 4x^3 - 13x^2 + 2x - 7

        result.getMonomialList().add(new Monomial(1, 4));
        result.getMonomialList().add(new Monomial(-4.333333333333333, 3));
        result.getMonomialList().add(new Monomial(1, 2));
        result.getMonomialList().add(new Monomial(-7, 1));

        // ∫p1 = x^4 - 4.3333x^3 + x^2 - 7x

        IntegratePolynomial integrate = new IntegratePolynomial();

        assertTrue(integrate.calculate(p1, p1).get(0).compareTo(result) == 0);
    }
}