package model.operations.operations_polynomial;

import model.datastructures.Monomial;
import model.datastructures.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractPolynomialTest {

    @Test
    void calculate() {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        Polynomial result = new Polynomial();

        p1.getMonomialList().add(new Monomial(4, 3));
        p1.getMonomialList().add(new Monomial(-13, 2));
        p1.getMonomialList().add(new Monomial(3, 1));
        p1.getMonomialList().add(new Monomial(-7,0));

        //p1 = 4x^3 - 13x^2 + 3x - 7

        p2.getMonomialList().add(new Monomial(1, 2));
        p2.getMonomialList().add(new Monomial(3, 1));
        p2.getMonomialList().add(new Monomial(-8, 0));

        //p2 = x^2 + 3x - 8

        result.getMonomialList().add(new Monomial(4, 3));
        result.getMonomialList().add(new Monomial(-14, 2));
        result.getMonomialList().add(new Monomial(1, 0));

        //p1 - p2 = 4x^3 - 14x^2 + 1

        SubtractPolynomial subtract = new SubtractPolynomial();

       assertTrue(subtract.calculate(p1, p2).get(0).compareTo(result) == 0);

       Polynomial nul = new Polynomial();
       nul.getMonomialList().add(new Monomial(0,0));

       Polynomial result1 = new Polynomial();
       result1.getMonomialList().add(new Monomial(-1, 2));
       result1.getMonomialList().add(new Monomial(-3, 1));
       result1.getMonomialList().add(new Monomial(8, 0));

        //0 - p1 = -x^2 - 3x + 8

        assertTrue(subtract.calculate(nul, p2).get(0).compareTo(result1) == 0);

        Polynomial p3 = new Polynomial();
        Polynomial p4 = new Polynomial();
        Polynomial result2 = new Polynomial();

        p3.getMonomialList().add(new Monomial(4, 3));
        p3.getMonomialList().add(new Monomial(-13, 2));
        //p3 = 4x^3 - 13x^2

        p4.getMonomialList().add(new Monomial(1, 2));
        p4.getMonomialList().add(new Monomial(3, 1));
        p4.getMonomialList().add(new Monomial(-8, 0));

        //p4 = x^2 + 3x - 8

        result2.getMonomialList().add(new Monomial(4, 3));
        result2.getMonomialList().add(new Monomial(-14, 2));
        result2.getMonomialList().add(new Monomial(-3, 1));
        result2.getMonomialList().add(new Monomial(8, 0));

        //p3 - p4 = 4x^3 - 14x^2 - 3x + 8

        assertTrue(subtract.calculate(p3, p4).get(0).compareTo(result2) == 0);
    }
}