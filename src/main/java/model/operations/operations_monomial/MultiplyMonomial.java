package model.operations.operations_monomial;

import model.datastructures.Monomial;

//Clasa pentru inmultirea a doua monoame

public class MultiplyMonomial implements OperationMonomial {
    @Override
    public Monomial calculate(Monomial monoOne, Monomial monoTwo) {
        Monomial result = new Monomial();

        result.setPower(monoOne.getPower() + monoTwo.getPower());
        result.setCoefficient(monoOne.getCoefficient() * monoTwo.getCoefficient());

        return result;
    }
}
