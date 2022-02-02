package model.operations.operations_polynomial;

import model.datastructures.Monomial;
import model.datastructures.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyPolynomialTest {

    @Test
    void calculate() {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        Polynomial result = new Polynomial();

        p1.getMonomialList().add(new Monomial(-1, 3));
        p1.getMonomialList().add(new Monomial(2, 2));
        p1.getMonomialList().add(new Monomial(3, 1));
        p1.getMonomialList().add(new Monomial(-4,0));

        //p1 = -x^3 + 2x^2 + 3x - 4

        p2.getMonomialList().add(new Monomial(1, 2));
        p2.getMonomialList().add(new Monomial(-5, 1));
        p2.getMonomialList().add(new Monomial(3, 0));

        //p2 = x^2 - 5x + 3

        result.getMonomialList().add(new Monomial(-1, 5));
        result.getMonomialList().add(new Monomial(7, 4));
        result.getMonomialList().add(new Monomial(-10, 3));
        result.getMonomialList().add(new Monomial(-13, 2));
        result.getMonomialList().add(new Monomial(29, 1));
        result.getMonomialList().add(new Monomial(-12, 0));

        //p1 * p2 = -x^5 + 7x^4 - 10x^3 - 13x^2 + 39x - 12

        MultiplyPolynomial multiply = new MultiplyPolynomial();

        assertTrue(multiply.calculate(p1, p2).get(0).compareTo(result) == 0);
    }
}