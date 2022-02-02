package model.operations.operations_polynomial;
import model.datastructures.Polynomial;

import java.util.List;

//Interfata implementata de toate clasele de operatii pe polinoame

public interface OperationPolynomial {
    public List<Polynomial> calculate(Polynomial polyOne, Polynomial polyTwo);
}
