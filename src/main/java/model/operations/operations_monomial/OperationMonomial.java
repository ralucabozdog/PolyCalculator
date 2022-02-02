package model.operations.operations_monomial;

import model.datastructures.Monomial;

//Interfata implementata de toate clasele de operatii pe monoame

public interface OperationMonomial {
    public Monomial calculate(Monomial monoOne, Monomial monoTwo);
}
