package model.operations.operations_polynomial;

import model.datastructures.Polynomial;
import model.operations.operations_monomial.MultiplyMonomial;
import model.datastructures.Monomial;

import java.util.ArrayList;
import java.util.List;

//Clasa pentru inmultirea a doua polinoame

public class MultiplyPolynomial implements OperationPolynomial {
    @Override
    public List<Polynomial> calculate(Polynomial polyOne, Polynomial polyTwo) {
        Polynomial result = new Polynomial();

        for(Monomial i : polyOne.getMonomialList()){
            for(Monomial j : polyTwo.getMonomialList()){
                MultiplyMonomial multiply = new MultiplyMonomial();
                Monomial r = multiply.calculate(i, j);
                if(r.getCoefficient() != 0)                             //daca obtin un monom cu coeficientul 0, nu il adaug la lista de monoame a polinomului rezultat
                result.getMonomialList().add(r);
            }
        }

        result.compress();                                              //pot obtine mai multe monoame de acelasi grad in cadrul polinomului rezultat
        result.ifNullThenZero();
        result.sortPowers();                                            //este nevoie de sortarea puterilor pentru afisare

        List<Polynomial> list = new ArrayList<Polynomial>();
        list.add(result);

        return list;
    }
}
