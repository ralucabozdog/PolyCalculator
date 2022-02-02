package model.validation;

import model.datastructures.Monomial;
import model.datastructures.Polynomial;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class PatternMatchingTest {

    @Test
    void stringToMonomial() {
        String validMonomial = "-5  x^ 3";
        Monomial m = new Monomial(-5, 3);
        assertTrue(PatternMatching.stringToMonomial(validMonomial).getCoefficient() == m.getCoefficient() && PatternMatching.stringToMonomial(validMonomial).getPower() == m.getPower());
    }

    @Test
    void isMonomial() {
        String validMonomial = "-  x ^ 8";
        String invalidMonomial = "--2x ^3 ";

        assertTrue(PatternMatching.isMonomial(validMonomial));
        assertFalse(PatternMatching.isMonomial(invalidMonomial));
    }

    @Test
    void stringToPolynomial() throws InvalidPolynomialException {
        String validPolynomial = "-x^5 +   4x ^ 4  -22x^3+x^2    -   x+1000000";
        Polynomial p = new Polynomial();

        p.getMonomialList().add(new Monomial(-1, 5));
        p.getMonomialList().add(new Monomial(4, 4));
        p.getMonomialList().add(new Monomial(-22, 3));
        p.getMonomialList().add(new Monomial(1, 2));
        p.getMonomialList().add(new Monomial(-1, 1));
        p.getMonomialList().add(new Monomial(1000000, 0));

        assertTrue(p.compareTo(PatternMatching.stringToPolynomial(validPolynomial)) == 0);

        String invalidPolynomial = "-x^5 +   4x ^ 4  -22x^3+x^2    -   x+100000O";      // capital letter 'o' as last digit
        assertThrows(InvalidPolynomialException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                Polynomial p = PatternMatching.stringToPolynomial(invalidPolynomial);
            }
        });
    }
}