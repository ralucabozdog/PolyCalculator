package model.operations.operations_polynomial;

import model.datastructures.Monomial;
import model.datastructures.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DividePolynomialTest {

    @Test
    void calculate() {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial();

        p1.getMonomialList().add(new Monomial(-1, 5));
        p1.getMonomialList().add(new Monomial(7, 4));
        p1.getMonomialList().add(new Monomial(-10, 3));
        p1.getMonomialList().add(new Monomial(-13, 2));
        p1.getMonomialList().add(new Monomial(29, 1));
        p1.getMonomialList().add(new Monomial(-12, 0));

        //p1 = -x^5 + 7x^4 - 10x^3 - 13x^2 + 39x - 12

        p2.getMonomialList().add(new Monomial(1, 2));
        p2.getMonomialList().add(new Monomial(-5, 1));
        p2.getMonomialList().add(new Monomial(3, 0));

        //p2 = x^2 - 5x + 3

        quotient.getMonomialList().add(new Monomial(-1, 3));
        quotient.getMonomialList().add(new Monomial(2, 2));
        quotient.getMonomialList().add(new Monomial(3, 1));
        quotient.getMonomialList().add(new Monomial(-4,0));

        remainder.getMonomialList().add(new Monomial(0,0));

        //p1 / p2 => quotient: -x^3 + 2x^2 + 3x - 4     remainder: 0

        Polynomial p = new Polynomial();
        p.getMonomialList().add(new Monomial(0, 0));

        //p2 / p1 => quotient: 0       remainder: x^2 - 5x + 3

        DividePolynomial divide  = new DividePolynomial();

        assertTrue(divide.calculate(p1, p2).get(0).compareTo(quotient) == 0 && divide.calculate(p1, p2).get(1).compareTo(remainder) == 0);
        assertTrue(divide.calculate(p2, p1).get(0).compareTo(p) == 0 && divide.calculate(p2, p1).get(1).compareTo(p1) == 0);
    }
}