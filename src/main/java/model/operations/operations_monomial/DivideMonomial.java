package model.operations.operations_monomial;

import model.datastructures.Monomial;

//Clasa pentru impartirea a doua monoame

public class DivideMonomial implements OperationMonomial {
    @Override
    public Monomial calculate(Monomial monoOne, Monomial monoTwo) {
        Monomial result = new Monomial();

        result.setCoefficient(monoOne.getCoefficient() / monoTwo.getCoefficient());
        result.setPower(monoOne.getPower() - monoTwo.getPower());

        return result;
    }
}
