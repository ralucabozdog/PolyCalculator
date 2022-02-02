package model.operations.operations_polynomial;

import model.datastructures.Polynomial;
import model.operations.operations_monomial.IntegrateMonomial;
import model.datastructures.Monomial;

import java.util.ArrayList;
import java.util.List;

//Clasa pentru integrarea unui polinom
//Cel de-al doilea polinom nu influenteaza calculele

public class IntegratePolynomial implements OperationPolynomial {
    @Override
    public List<Polynomial> calculate(Polynomial polyOne, Polynomial polyTwo) {
        Polynomial result = new Polynomial();

        for(Monomial m : polyOne.getMonomialList()){
            IntegrateMonomial integrate = new IntegrateMonomial();
            result.getMonomialList().add(integrate.calculate(m, m));
        }

        result.compress();
        result.sortPowers();                                //Este posibil ca polinomul sa fi fost introdus in alta ordine decat cea descrescatoare a puterilor lui x
        result.ifNullThenZero();                            //=> este nevoie de sortare pentru afisarea rezultatului

        List<Polynomial> list = new ArrayList<Polynomial>();
        list.add(result);

        return list;
    }
}
