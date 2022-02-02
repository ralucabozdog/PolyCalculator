package model.operations.operations_polynomial;

import model.datastructures.Polynomial;
import model.operations.operations_monomial.DivideMonomial;
import model.datastructures.Monomial;

import java.util.ArrayList;
import java.util.List;

//Clasa pentru impartirea a doua polinoame

public class DividePolynomial implements OperationPolynomial {
    @Override
    public List<Polynomial> calculate(Polynomial polyOne, Polynomial polyTwo){
        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial();

        polyOne.sortPowers();                                                                                           //Se sorteaza monoamele din lista polinoamelor in ordinea descrescatoare a gradelor lor
        polyTwo.sortPowers();

        Polynomial p = new Polynomial(polyOne.getMonomialList());
        Polynomial q = new Polynomial(polyTwo.getMonomialList());

        p.removeZero();                                                                                                 //Se elimina monoamele cu coeficientul 0 introduse de utilizator
        q.removeZero();

        if(p.getDegree() >= q.getDegree()){                                                                             //daca gradul primului polunom este mai mare decat gradul celui de-al doilea
            while(p.getDegree() >= q.getDegree() && p.isNull() == false && q.isNull() == false){                        //se poate realiza impartirea
                DivideMonomial divideMonomial = new DivideMonomial();

                Monomial m = divideMonomial.calculate(p.getMonomialList().get(0), q.getMonomialList().get(0));

                Polynomial forMultiplication = new Polynomial();
                forMultiplication.getMonomialList().add(m);

                quotient.getMonomialList().add(m);

                MultiplyPolynomial multiplyPolynomial = new MultiplyPolynomial();
                Polynomial intermediate = multiplyPolynomial.calculate(forMultiplication, q).get(0);

                SubtractPolynomial subtractPolynomial = new SubtractPolynomial();
                remainder = subtractPolynomial.calculate(p, intermediate).get(0);
                remainder.ifNullThenZero();

                p.setMonomialList(remainder.getMonomialList());
                p.removeZero();
                q.removeZero();
            }
        }
        else                                                                                                            //altfel catul va fi 0 si resul va fi cel de-al doilea polinom
            remainder = q;

        quotient.compress();
        remainder.compress();
        quotient.ifNullThenZero();
        remainder.ifNullThenZero();

        List<Polynomial> list = new ArrayList<Polynomial>();
        list.add(quotient);                                                                                             //Se adauga catul si restul in lista de monoame ce urmeaza sa fie returnata
        list.add(remainder);

        return list;
    }
}
