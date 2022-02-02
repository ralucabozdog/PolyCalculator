package model.operations.operations_monomial;

import model.datastructures.Monomial;

//Clasa pentru realizarea operatiei de derivare a unui monom
//Cel de-al doilea monom trimis ca parametru nu intervine in niciun fel in calcule

public class DifferentiateMonomial implements OperationMonomial {
    @Override
    public Monomial calculate(Monomial monoOne, Monomial monoTwo) {
        Monomial result = new Monomial();

        if(monoOne.getPower() != 0){
            result.setCoefficient(monoOne.getPower() * monoOne.getCoefficient());
            result.setPower(monoOne.getPower() - 1);
        }
        return result;
    }
}
