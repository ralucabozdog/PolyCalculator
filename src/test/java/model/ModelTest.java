package model;

import model.datastructures.Monomial;
import model.datastructures.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @Test
    void getPolyOne() {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();

        p1.getMonomialList().add(new Monomial(1, 4));
        p1.getMonomialList().add(new Monomial(1, 3));
        p1.getMonomialList().add(new Monomial(1, 2));
        p1.getMonomialList().add(new Monomial(1, 1));
        p1.getMonomialList().add(new Monomial(1, 0));

        Model m = new Model();
        m.setPolyOne(p1);
        m.setPolyTwo(p2);

        assertTrue(m.getPolyOne().compareTo(p1) == 0);
    }

    @Test
    void setPolyOne() {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();

        p1.getMonomialList().add(new Monomial(1, 4));
        p1.getMonomialList().add(new Monomial(1, 3));
        p1.getMonomialList().add(new Monomial(1, 2));
        p1.getMonomialList().add(new Monomial(1, 1));
        p1.getMonomialList().add(new Monomial(1, 0));

        Model m = new Model();
        m.setPolyOne(p1);
        m.setPolyTwo(p2);

        assertTrue(m.getPolyOne().compareTo(p1) == 0);
    }

    @Test
    void getPolyTwo() {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();

        p1.getMonomialList().add(new Monomial(1, 4));
        p1.getMonomialList().add(new Monomial(1, 3));
        p1.getMonomialList().add(new Monomial(1, 2));
        p1.getMonomialList().add(new Monomial(1, 1));
        p1.getMonomialList().add(new Monomial(1, 0));

        Model m = new Model();
        m.setPolyOne(p2);
        m.setPolyTwo(p1);

        assertTrue(m.getPolyTwo().compareTo(p1) == 0);
    }

    @Test
    void setPolyTwo() {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();

        p1.getMonomialList().add(new Monomial(4, 4));
        p1.getMonomialList().add(new Monomial(2, 3));
        p1.getMonomialList().add(new Monomial(1, 2));

        Model m = new Model();
        m.setPolyOne(p1);
        m.setPolyTwo(p2);

        assertTrue(m.getPolyTwo().compareTo(p2) == 0);
    }
}