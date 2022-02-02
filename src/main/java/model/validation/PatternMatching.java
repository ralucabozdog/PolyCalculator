package model.validation;

import model.datastructures.Monomial;
import model.datastructures.Polynomial;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Clasa pentru verificarea inputului introdus de utilizator

public class PatternMatching {

    //metoda ce verifica daca un anumit sir de caratere este un monom
    public static boolean isMonomial(String possibleMonomial){

        String MONOMIAL_PATTERN_GENERAL = "[ ]*[-+]?[ ]*[0-9]*[ ]*[xX][ ]*\\^[ ]*[+]?[ ]*[0-9]+[ ]*";   //forma generala a unui monom
        String MONOMIAL_PATTERN_ONE = "[ ]*[-+]?[ ]*[0-9]*[ ]*[xX][ ]*";                                //forma particulara a unui monom de gradul 1
        String MONOMIAL_PATTERN_ZERO = "[ ]*[-+]?[ ]*[0-9]+[ ]*";                                       //forma particulara a unui monom de gradul 0
        Pattern pattern = Pattern.compile(MONOMIAL_PATTERN_GENERAL);
        Pattern pattern1 = Pattern.compile(MONOMIAL_PATTERN_ONE);
        Pattern pattern0 = Pattern.compile(MONOMIAL_PATTERN_ZERO);

        Matcher matcher = pattern.matcher(possibleMonomial);
        Matcher matcher1 = pattern1.matcher(possibleMonomial);
        Matcher matcher0 = pattern0.matcher(possibleMonomial);

        if(matcher.matches() || matcher1.matches() || matcher0.matches())
            return  true;
        return false;
    }

    //metoda ce transforma un sir de caractere (care a fost deja validat ca fiind un monom) intr-un obiect de tip Monomial
    public static Monomial stringToMonomial(String checkedMonomial){
        checkedMonomial = checkedMonomial.replaceAll("\\s+", "");
        int lower = checkedMonomial.indexOf('x');
        int upper = checkedMonomial.indexOf('X');
        int poz;
        int pw = checkedMonomial.indexOf('^');
        String coef = new String();
        int coefficient;
        int power;

        if(lower < 0 && upper < 0)
            return new Monomial(Integer.parseInt(checkedMonomial), 0);
        else {
            poz = Math.max(lower, upper);
            coef = checkedMonomial.substring(0, poz);
            if (coef.equals("+") || coef.equals(""))
                coefficient = 1;
            else
                if (coef.equals("-"))
                    coefficient = -1;
                else
                    coefficient = Integer.parseInt(coef);
            if (pw < 0)
                power = 1;
            else
                power = Integer.parseInt(checkedMonomial.substring(pw + 1));

            return new Monomial(coefficient, power);
        }
    }

    //metoda ce transforma un sir de caractere intr-un polinom
    //daca sirul de caractere nu este un polinom valid, se arunca o exceptie de tipul InvalidPolynomialException
    public static Polynomial stringToPolynomial(String polynomial) throws InvalidPolynomialException {
        String possibleMonomial = new String();
        int i = 0;
        int ok = 1;
        List<Monomial> monomialList = new ArrayList<>();

        while(i < polynomial.length() && ok == 1){

            int ep = polynomial.indexOf('+', i + 1);
            int em = polynomial.indexOf('-', i + 1);                //orice monom se incheie inainte de inceputul unui nou monom (intalnirea unui caracter + sau -)
                                                                                //sau la finalul sirului
            if(em == -1)
                em = polynomial.length();
            if(ep == -1)
                ep = polynomial.length();
            if(ep <= em){
                possibleMonomial = polynomial.substring(i, ep);
                i = ep;
            }
            else{
                possibleMonomial = polynomial.substring(i, em);
                i = em;
            }
            if(isMonomial(possibleMonomial))                                    //daca monomul este valid, il adaug la lista de monoame a polinomului ce urmeaza sa fie returnat
                monomialList.add(stringToMonomial(possibleMonomial));
            else
                ok = 0;                                                         //altfel variabila de validare devine 0 => sirul nu este un polinom
        }
        if(ok == 1){
            Polynomial P = new Polynomial(monomialList);
            P.removeZero();
            return P;
        }
        else{
            monomialList.clear();                                               //se 'curata' lista de monoame a polinomului
            throw new InvalidPolynomialException();                             //se arunca exceptia
        }
    }
}
