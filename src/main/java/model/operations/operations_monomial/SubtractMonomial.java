package model.operations.operations_monomial;

import model.datastructures.Monomial;

//Clasa pentru scaderea a doua monoame de acelasi grad

public class SubtractMonomial implements OperationMonomial {

    @Override
    public Monomial calculate(Monomial monoOne, Monomial monoTwo) {
        Monomial result = new Monomial();

        result.setPower(monoOne.getPower());
        result.setCoefficient(monoOne.getCoefficient() - monoTwo.getCoefficient());

        return result;
    }
}
