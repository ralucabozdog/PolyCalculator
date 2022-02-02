package model.operations.operations_monomial;

import model.datastructures.Monomial;

//Clasa pentru realizarea operatiei de integrare a unui monom
//Cel de-al doilea monom trimis ca parametru metodei calculate() este ignorat

public class IntegrateMonomial implements OperationMonomial {
    @Override
    public Monomial calculate(Monomial monoOne, Monomial monoTwo) {
        Monomial result = new Monomial();

        result.setPower(monoOne.getPower() + 1);
        result.setCoefficient(monoOne.getCoefficient() / (monoOne.getPower() + 1));

        return result;
    }
}
