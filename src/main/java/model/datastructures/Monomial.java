package model.datastructures;

import java.text.DecimalFormat;

//Clasa pentru retinerea, compararea si afisarea de monoame

public class Monomial implements Comparable<Monomial>{
    private double coefficient;     //coeficientul de dinaintea lui x in monom
    private int power;              //puterea lui x in monom => gradul monomului

    public Monomial(double coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    public Monomial (){
        this.coefficient = 0;
        this.power = 0;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    //metoda pentru compararea a doua monoame dupa grad
    //returneaza 0 daca monoamele au acelasi grad
    //returneaza -1 daca gradul monomului curent este mai mic decat gradul polinomului trimis ca parametru
    //returneaza 1 daca gradul monomului curent este mai mare decat gradul polinomului trimis ca parametru
    public int compareTo(Monomial mon) {
        if(this.power > mon.getPower())
            return 1;
        if(this.power < mon.getPower())
            return -1;
        return 0;
    }

    //metoda folosita la afisare
    //transforma un monom intr-un sir de caractere
    public String print(){

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(4);

        String mono = new String();

        if(this.coefficient > 0)
            mono = "+ ";
        else
            if(this.coefficient < 0)
                mono = "- ";

        if(this.coefficient != 1 && this.coefficient != -1 || this.power == 0)
           if((this.coefficient % 1) != 0)
               mono = mono + df.format(Math.abs(this.coefficient));
           else
               mono = mono + Math.abs((int)this.coefficient);

        if(this.power > 0)
            mono = mono + "x";
        if(this.power > 1)
            mono = mono + "^" + this.power;

        return mono;
    }
}
