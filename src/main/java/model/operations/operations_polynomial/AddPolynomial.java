package model.operations.operations_polynomial;

import model.datastructures.Polynomial;
import model.operations.operations_monomial.AddMonomial;
import model.datastructures.Monomial;

import java.util.ArrayList;
import java.util.List;

//Clasa pentru adunarea a doua polinoame

public class AddPolynomial implements OperationPolynomial {
    @Override
    public List<Polynomial> calculate(Polynomial polyOne, Polynomial polyTwo) {
        Polynomial result = new Polynomial();
        polyOne.sortPowers();                                                                                           //Se ordoneaza descrescator puterile celor doua polinoame
        polyTwo.sortPowers();
        int i = 0;
        int j = 0;

        while(i < polyOne.getMonomialList().size() && j < polyTwo.getMonomialList().size()){                            //Se aplica un mecanism similar interclasarii pentru a asigura ordonarea
            if(polyOne.getMonomialList().get(i).compareTo(polyTwo.getMonomialList().get(j)) == 0){                      //corecta a puterilor in cadrul polinomului rezultat,
                AddMonomial add = new AddMonomial();                                                                    //la o singura parcurgere a polinoamelor input
                Monomial mono = add.calculate(polyOne.getMonomialList().get(i), polyTwo.getMonomialList().get(j));
                if(mono.getCoefficient() != 0)
                    result.getMonomialList().add(mono);
                i++;
                j++;
            }
            else{
                if(polyOne.getMonomialList().get(i).compareTo(polyTwo.getMonomialList().get(j)) > 0){
                    if(polyOne.getMonomialList().get(i).getCoefficient() != 0)
                        result.getMonomialList().add(polyOne.getMonomialList().get(i));
                    i++;
                }
                else {
                    if(polyTwo.getMonomialList().get(j).getCoefficient() != 0)
                        result.getMonomialList().add(polyTwo.getMonomialList().get(j));
                    j++;
                }
            }
        }
        while(i < polyOne.getMonomialList().size()){
            if(polyOne.getMonomialList().get(i).getCoefficient() != 0)
                result.getMonomialList().add(polyOne.getMonomialList().get(i));
            i++;
        }
        while(j < polyTwo.getMonomialList().size()){
            if(polyTwo.getMonomialList().get(j).getCoefficient() != 0)
                result.getMonomialList().add(polyTwo.getMonomialList().get(j));
            j++;
        }
        result.compress();                                                                                              //Se elimina monoamele cu coeficientul 0 rezultate in urma adunarii
        result.ifNullThenZero();

        List<Polynomial> list = new ArrayList<Polynomial>();
        list.add(result);

        return list;
    }
}
