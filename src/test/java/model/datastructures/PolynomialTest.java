package model.datastructures;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    @Test
    void getMonomialList() {
        Polynomial p = new Polynomial();

        p.getMonomialList().add(new Monomial(5, 5));
        p.getMonomialList().add(new Monomial(4, 4));
        p.getMonomialList().add(new Monomial(3, 3));
        p.getMonomialList().add(new Monomial(2, 2));
        p.getMonomialList().add(new Monomial(1, 1));
        p.getMonomialList().add(new Monomial(6, 0));

        List<Monomial> monomialList = new ArrayList<>();
        monomialList.add(new Monomial(5, 5));
        monomialList.add(new Monomial(4, 4));
        monomialList.add(new Monomial(3, 3));
        monomialList.add(new Monomial(2, 2));
        monomialList.add(new Monomial(1, 1));
        monomialList.add(new Monomial(6, 0));

        for(int i = 0; i < p.getMonomialList().size(); i++){
            assertEquals(p.getMonomialList().get(i).getCoefficient(), monomialList.get(i).getCoefficient(), 0.00001);
            assertEquals(p.getMonomialList().get(i).getPower(), monomialList.get(i).getPower());
        }
    }

    @Test
    void setMonomialList() {
        Polynomial p = new Polynomial();
        p.getMonomialList().add(new Monomial(1, 2));
        p.getMonomialList().add(new Monomial(2, 1));
        p.getMonomialList().add(new Monomial(1, 0));

        List<Monomial> list = new ArrayList<>();
        list.add(new Monomial(5, 5));
        list.add(new Monomial(4, 4));
        list.add(new Monomial(3, 3));
        list.add(new Monomial(2, 2));
        list.add(new Monomial(1, 1));
        list.add(new Monomial(6, 0));
        p.setMonomialList(list);

        List<Monomial> monomialList = new ArrayList<>();
        monomialList.add(new Monomial(5, 5));
        monomialList.add(new Monomial(4, 4));
        monomialList.add(new Monomial(3, 3));
        monomialList.add(new Monomial(2, 2));
        monomialList.add(new Monomial(1, 1));
        monomialList.add(new Monomial(6, 0));

        for(int i = 0; i < p.getMonomialList().size(); i++) {
            assertEquals(p.getMonomialList().get(i).getCoefficient(), monomialList.get(i).getCoefficient(), 0.00001);
            assertEquals(p.getMonomialList().get(i).getPower(), monomialList.get(i).getPower());
        }
    }

    @Test
    void sortPowers() {
        Polynomial p = new Polynomial();

        p.getMonomialList().add(new Monomial(5, 5));
        p.getMonomialList().add(new Monomial(4, 4));
        p.getMonomialList().add(new Monomial(3, 3));
        p.getMonomialList().add(new Monomial(2, 2));
        p.getMonomialList().add(new Monomial(1, 1));
        p.getMonomialList().add(new Monomial(6, 0));

        Polynomial unsortedP = new Polynomial();

        unsortedP.getMonomialList().add(new Monomial(1, 1));
        unsortedP.getMonomialList().add(new Monomial(4, 4));
        unsortedP.getMonomialList().add(new Monomial(2, 2));
        unsortedP.getMonomialList().add(new Monomial(5, 5));
        unsortedP.getMonomialList().add(new Monomial(6, 0));
        unsortedP.getMonomialList().add(new Monomial(3, 3));

        unsortedP.sortPowers();

        assertTrue(p.compareTo(unsortedP) == 0);
    }

    @Test
    void getDegree() {
        Polynomial p = new Polynomial();

        p.getMonomialList().add(new Monomial(5, 5));
        p.getMonomialList().add(new Monomial(4, 4));
        p.getMonomialList().add(new Monomial(3, 3));
        p.getMonomialList().add(new Monomial(2, 2));
        p.getMonomialList().add(new Monomial(1, 1));
        p.getMonomialList().add(new Monomial(6, 0));

        assertEquals(5, p.getDegree());
    }

    @Test
    void print() {
        Polynomial p = new Polynomial();

        p.getMonomialList().add(new Monomial(5, 5));
        p.getMonomialList().add(new Monomial(4, 4));
        p.getMonomialList().add(new Monomial(3, 3));
        p.getMonomialList().add(new Monomial(2, 2));
        p.getMonomialList().add(new Monomial(1, 1));
        p.getMonomialList().add(new Monomial(6, 0));

        assertTrue(p.print().equals("5x^5 + 4x^4 + 3x^3 + 2x^2 + x + 6 "));
    }

    @Test
    void compress() {
        Polynomial p = new Polynomial();
        p.getMonomialList().add(new Monomial(5, 5));
        p.getMonomialList().add(new Monomial(4, 5));
        p.getMonomialList().add(new Monomial(3, 5));
        p.getMonomialList().add(new Monomial(2, 2));
        p.getMonomialList().add(new Monomial(1, 1));
        p.getMonomialList().add(new Monomial(6, 0));
        p.compress();

        Polynomial q = new Polynomial();

        q.getMonomialList().add(new Monomial(12, 5));
        q.getMonomialList().add(new Monomial(2, 2));
        q.getMonomialList().add(new Monomial(1, 1));
        q.getMonomialList().add(new Monomial(6, 0));

        assertTrue(q.compareTo(p) == 0);

        Polynomial p1 = new Polynomial();
        System.out.println(p1.print());
        p1.getMonomialList().add(new Monomial(5, 5));
        p1.getMonomialList().add(new Monomial(-2, 5));
        p1.getMonomialList().add(new Monomial(-3, 5));
        p1.getMonomialList().add(new Monomial(2, 2));
        p1.getMonomialList().add(new Monomial(1, 1));
        p1.getMonomialList().add(new Monomial(6, 0));
        p1.compress();

        Polynomial q1 = new Polynomial();

        q1.getMonomialList().add(new Monomial(2, 2));
        q1.getMonomialList().add(new Monomial(1, 1));
        q1.getMonomialList().add(new Monomial(6, 0));

        assertTrue(q1.compareTo(p1) == 0);
    }

    @Test
    void removeZero() {
        Polynomial p = new Polynomial();

        p.getMonomialList().add(new Monomial(5, 5));
        p.getMonomialList().add(new Monomial(0, 4));
        p.getMonomialList().add(new Monomial(3, 3));
        p.getMonomialList().add(new Monomial(0, 2));
        p.getMonomialList().add(new Monomial(1, 1));
        p.getMonomialList().add(new Monomial(0, 0));
        p.removeZero();

        Polynomial q = new Polynomial();

        q.getMonomialList().add(new Monomial(5, 5));
        q.getMonomialList().add(new Monomial(3, 3));
        q.getMonomialList().add(new Monomial(1, 1));

        assertTrue(p.compareTo(q) == 0);
    }

    @Test
    void ifNullThenZero() {
        Polynomial p = new Polynomial();
        p.ifNullThenZero();

        Polynomial q = new Polynomial();
        q.getMonomialList().add(new Monomial(0, 0));

        assertTrue(p.compareTo(q) == 0);
    }

    @Test
    void isNull() {
        Polynomial p = new Polynomial();
        assertTrue(p.isNull());
    }

    @Test
    void compareTo() {
        Polynomial p = new Polynomial();

        p.getMonomialList().add(new Monomial(5, 5));
        p.getMonomialList().add(new Monomial(4, 4));
        p.getMonomialList().add(new Monomial(3, 3));
        p.getMonomialList().add(new Monomial(2, 2));
        p.getMonomialList().add(new Monomial(1, 1));
        p.getMonomialList().add(new Monomial(6, 0));
        p.removeZero();

        Polynomial q = new Polynomial();

        q.getMonomialList().add(new Monomial(5, 4));
        q.getMonomialList().add(new Monomial(3, 3));
        q.getMonomialList().add(new Monomial(1, 1));

        Polynomial equalsQ = new Polynomial();

        equalsQ.getMonomialList().add(new Monomial(5, 4));
        equalsQ.getMonomialList().add(new Monomial(3, 3));
        equalsQ.getMonomialList().add(new Monomial(1, 1));

        Polynomial q1 = new Polynomial();

        q1.getMonomialList().add(new Monomial(5, 5));
        q1.getMonomialList().add(new Monomial(3, 3));
        q1.getMonomialList().add(new Monomial(1, 1));

        assertTrue(p.compareTo(q) == -1);
        assertTrue(q.compareTo(equalsQ) == 0);
        assertTrue(p.compareTo(q1) == -1);
    }
}