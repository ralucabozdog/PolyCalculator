package model.operations.operations_polynomial;

import model.datastructures.Monomial;
import model.datastructures.Polynomial;
import model.operations.operations_monomial.SubtractMonomial;

import java.util.ArrayList;
import java.util.List;

//Clasa pentru scaderea a doua polinoame
//Foarte similara cu cea pentru adunare

public class SubtractPolynomial implements OperationPolynomial {
    @Override
    public List<Polynomial> calculate(Polynomial polyOne, Polynomial polyTwo) {
        Polynomial result = new Polynomial();

        polyOne.sortPowers();
        polyTwo.sortPowers();

        int i = 0;
        int j = 0;

        while(i < polyOne.getMonomialList().size() && j < polyTwo.getMonomialList().size()){
            if(polyOne.getMonomialList().get(i).compareTo(polyTwo.getMonomialList().get(j)) == 0){
                SubtractMonomial subtract = new SubtractMonomial();
                Monomial mono = subtract.calculate(polyOne.getMonomialList().get(i), polyTwo.getMonomialList().get(j));
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
                    if(polyTwo.getMonomialList().get(j).getCoefficient() != 0){
                        SubtractMonomial subtract = new SubtractMonomial();
                        result.getMonomialList().add(subtract.calculate(new Monomial(0, polyTwo.getMonomialList().get(j).getPower()),polyTwo.getMonomialList().get(j)));
                        //Daca in primul polinom stiu sigur ca nu exista monom de acelasi grad cu un anumit monom din cel de-al doilea polinom
                        //scad monomul respectiv al celui de-al doilea polinom din monomul nul, si adaug rezultatul aceste operatii la lista de monoame a polinomului rezultat
                    }
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
            {
                SubtractMonomial subtract = new SubtractMonomial();
                result.getMonomialList().add(subtract.calculate(new Monomial(0, polyTwo.getMonomialList().get(j).getPower()),polyTwo.getMonomialList().get(j)));
            }
            j++;
        }

        result.compress();                          //Este posibil ca daca inputul era un polinom cu mai multe monoame de acelasi grad, sa fie nevoie sa rezolv aici situatia
        result.ifNullThenZero();

        List<Polynomial> list = new ArrayList<Polynomial>();
        list.add(result);

        return list;
    }
}
