package model.datastructures;

import model.operations.operations_monomial.AddMonomial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Clasa pentru retinerea de polinoame si realizarea anumitor operatii de procesare pe acestea

public class Polynomial implements Comparable<Polynomial>{
    private List<Monomial> monomialList;        //un polinom este o lista de monoame

    public Polynomial(List<Monomial> monomialList) {
        this.monomialList = monomialList;
    }

    public Polynomial() {
        this.monomialList = new ArrayList<Monomial>();
    }

    public List<Monomial> getMonomialList() {
        return monomialList;
    }

    public void setMonomialList(List<Monomial> monomialList) {
        this.monomialList = monomialList;
    }

    //metoda pentru sortarea monoamelor polinomului in ordinea descrescatoare a gradelor
    public void sortPowers() {
        Collections.sort(this.monomialList);
        Collections.reverse(this.monomialList);
    }

    //metoda ce returneaza gradul polinomului
    //gradul unui polinom este gradul maxim dintre gradele monoamelor ce compun polinomul
    public int getDegree() {
        if (this.monomialList.size() != 0)
            return Collections.max(this.monomialList).getPower();
        return 0;
    }

    //metoda folosita la afisare
    //transforma un polinom intr-un sir de caractere
    public String print() {

        String poly = new String();

        for (Monomial m : this.monomialList) {
            poly = poly + m.print() + " ";
        }

        if (poly.length() > 2 && poly.charAt(0) == '+')
            poly = poly.substring(2);

        return poly;
    }

    //metoda ce elimina monoamele de acelasi grad din cadrul unui polinom
    //toate monoamele de acelasi grad se comprima intr-unul singur prin adunarea coeficientilor
    public void compress() {
        int i = 0;
        int j = 0;
        while (i < this.monomialList.size()) {
            j = i + 1;
            while(j < this.monomialList.size()) {
                if (this.monomialList.get(i).compareTo(this.monomialList.get(j)) == 0) {
                    AddMonomial add = new AddMonomial();

                    Monomial m = add.calculate(this.monomialList.get(i), this.monomialList.get(j));

                    if (m.getCoefficient() != 0) {
                        this.monomialList.set(i, m);
                        this.monomialList.remove(j);
                    } else {
                        this.monomialList.remove(i);
                        this.monomialList.remove(j - 1);
                    }
                }
                else
                    j++;
            }
            i++;
        }
    }

    //metoda ce elimina monoamele cu coeficientul 0 din cadrul unui polinom
    public void removeZero() {
        for (int i = 0; i < this.monomialList.size(); i++) {
            if (this.monomialList.get(i).getCoefficient() == 0)
                this.monomialList.remove(i);
        }
    }

    //metoda care insereaza un monom cu coeficientul 0 si gradul 0 in lista de monoame a unui polinom
    //ajuta la evitarea exceptiilor de tip NullPointerException si la afisare
    public void ifNullThenZero() {
        if (this.monomialList.size() == 0)
            this.monomialList.add(new Monomial(0, 0));
    }

    //returneaza true daca polinomul are lista de monoame vida
    //returneaza false daca polinomul are cel putin un monom in lista sa
    public boolean isNull() {
        if (this.monomialList.size() == 0)
            return true;
        return false;
    }

    //returneaza 0 daca doua polinoame sunt identice, si -1 in rest
    public int compareTo(Polynomial polynomial) {
        //used for testing => only relevant in checking the equality of two polynomials
        // 0 if the polynomials are equal, -1 otherwise
        int ok = 1;
        int i = 0;

        this.sortPowers();
        polynomial.sortPowers();

        if(this.getDegree() != polynomial.getDegree())
            return -1;
        while(i < this.monomialList.size() && ok == 1){
            if(Double.compare(this.monomialList.get(i).getCoefficient(), polynomial.monomialList.get(i).getCoefficient()) != 0
                    || this.monomialList.get(i).getPower() != polynomial.monomialList.get(i).getPower())
                ok = 0;
            i++;
        }
        if(ok == 1)
            return 0;
        return -1;
    }
}
