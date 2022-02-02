package model.operations.operations_polynomial;

import model.datastructures.Monomial;
import model.datastructures.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddPolynomialTest {

    @Test
    void calculate() {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        Polynomial result = new Polynomial();

        p1.getMonomialList().add(new Monomial(4, 3));
        p1.getMonomialList().add(new Monomial(-13, 2));
        p1.getMonomialList().add(new Monomial(2, 1));
        p1.getMonomialList().add(new Monomial(-7,0));

        //p1 = 4x^3 - 13x^2 + 2x - 7

        p2.getMonomialList().add(new Monomial(1, 2));
        p2.getMonomialList().add(new Monomial(3, 1));
        p2.getMonomialList().add(new Monomial(-8, 0));

        //p2 = x^2 + 3x - 8

        result.getMonomialList().add(new Monomial(4, 3));
        result.getMonomialList().add(new Monomial(-12, 2));
        result.getMonomialList().add(new Monomial(5, 1));
        result.getMonomialList().add(new Monomial(-15, 0));

        //p1 + p2 = 4x^3 - 12x^2 + 5x - 15

        AddPolynomial add = new AddPolynomial();

        assertTrue(add.calculate(p1, p2).get(0).compareTo(result) == 0);


        Polynomial p = new Polynomial();
        p.getMonomialList().add(new Monomial(7, 0));

        Polynomial result1 = new Polynomial();
        result1.getMonomialList().add(new Monomial(4, 3));
        result1.getMonomialList().add(new Monomial(-13, 2));
        result1.getMonomialList().add(new Monomial(2, 1));

        assertTrue(add.calculate(p1, p).get(0).compareTo(result1) == 0);


        Polynomial p4 = new Polynomial();
        Polynomial result2 = new Polynomial();

        p4.getMonomialList().add(new Monomial(1, 2));

        //p4 = x^2
        //p1 = 4x^3 - 13x^2 + 2x - 7

        result2.getMonomialList().add(new Monomial(4, 3));
        result2.getMonomialList().add(new Monomial(-12, 2));
        result2.getMonomialList().add(new Monomial(2, 1));
        result2.getMonomialList().add(new Monomial(-7, 0));

        //p1 + p4 = 4x^3 - 12x^2 + 2x - 7

        assertTrue(add.calculate(p1, p4).get(0).compareTo(result2) == 0);
        assertTrue(add.calculate(p4, p1).get(0).compareTo(result2) == 0);

    }
}