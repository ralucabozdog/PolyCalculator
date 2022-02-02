package model.operations.operations_polynomial;

import model.datastructures.Polynomial;
import model.operations.operations_monomial.DifferentiateMonomial;
import model.datastructures.Monomial;

import java.util.ArrayList;
import java.util.List;

//Clasa pentru derivarea unui polinom
//Cel de-al doilea polinom este neglijat

public class DifferentiatePolynomial implements OperationPolynomial {
    @Override
    public List<Polynomial> calculate(Polynomial polyOne, Polynomial polyTwo) {
        Polynomial result = new Polynomial();

        for(Monomial m : polyOne.getMonomialList()){
            DifferentiateMonomial differentiate = new DifferentiateMonomial();

            Monomial r = differentiate.calculate(m,m);                          //se realizeaza operatia de derivare pentru fiecare monom al polinomului, succesiv
            if(r.getCoefficient() != 0)
                result.getMonomialList().add(r);
        }

        result.compress();
        result.sortPowers();
        result.ifNullThenZero();

        List<Polynomial> list = new ArrayList<Polynomial>();
        list.add(result);

        return list;
    }
}
