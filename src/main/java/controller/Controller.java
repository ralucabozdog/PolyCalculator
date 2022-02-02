package controller;

import model.validation.InvalidPolynomialException;
import model.Model;
import model.validation.PatternMatching;
import model.datastructures.Polynomial;
import model.operations.operations_polynomial.*;
import view.ErrorPopUp;
import view.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Controller {
    private GUI view;
    private Model model;

    public Controller(GUI view, Model model){
        this.view = view;
        this.model = model;

        this.view.addAdditionListener(new AdditionListener());                  //Se adauga ActionListener pentru a putea capta informatia transmisa de user (ce operatie sa se execute)
        this.view.addSubtractionListener(new SubtractionListener());
        this.view.addMultiplicationListener(new MultiplicationListener());
        this.view.addDivisionListener(new DivisionListener());
        this.view.addIntegrationListener(new IntegrationListener());
        this.view.addDifferentiationListener(new DifferentiationListener());
        this.view.addResetListener(new ResetListener());
    }

    //Clase interne pentru definirea de ActionListener specifici pentru fiecare buton din interfata grafica

    class AdditionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                model.setPolyOne(PatternMatching.stringToPolynomial(view.getPolyOne().getText()));
                model.setPolyTwo(PatternMatching.stringToPolynomial(view.getPolyTwo().getText()));
                AddPolynomial addition = new AddPolynomial();
                view.setResult(addition.calculate(model.getPolyOne(), model.getPolyTwo()).get(0).print());
            }catch (InvalidPolynomialException exception){
                new ErrorPopUp("Invalid polynomial").setVisible(true);
            }
        }
    }

    class SubtractionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                model.setPolyOne(PatternMatching.stringToPolynomial(view.getPolyOne().getText()));
                model.setPolyTwo(PatternMatching.stringToPolynomial(view.getPolyTwo().getText()));
                SubtractPolynomial subtraction = new SubtractPolynomial();
                view.setResult(subtraction.calculate(model.getPolyOne(), model.getPolyTwo()).get(0).print());
            }catch (InvalidPolynomialException exception){
                new ErrorPopUp("Invalid polynomial").setVisible(true);
            }
        }
    }

    class MultiplicationListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                model.setPolyOne(PatternMatching.stringToPolynomial(view.getPolyOne().getText()));
                model.setPolyTwo(PatternMatching.stringToPolynomial(view.getPolyTwo().getText()));
                MultiplyPolynomial multiplication = new MultiplyPolynomial();
                view.setResult(multiplication.calculate(model.getPolyOne(), model.getPolyTwo()).get(0).print());
            }catch (InvalidPolynomialException exception){
                new ErrorPopUp("Invalid polynomial").setVisible(true);
            }
        }
    }

    class DivisionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                model.setPolyOne(PatternMatching.stringToPolynomial(view.getPolyOne().getText()));
                model.setPolyTwo(PatternMatching.stringToPolynomial(view.getPolyTwo().getText()));
                DividePolynomial division = new DividePolynomial();
                List<Polynomial> polynomialList = division.calculate(model.getPolyOne(), model.getPolyTwo());
                view.setResult("Quotient: " + polynomialList.get(0).print() + "     Remainder: " + polynomialList.get(1).print());
            }catch (InvalidPolynomialException exception){
                new ErrorPopUp("Invalid polynomial").setVisible(true);
            }
        }
    }

    class IntegrationListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                model.setPolyOne(PatternMatching.stringToPolynomial(view.getPolyOne().getText()));
                model.setPolyTwo(PatternMatching.stringToPolynomial(view.getPolyTwo().getText()));
                IntegratePolynomial integration = new IntegratePolynomial();
                view.setResult(integration.calculate(model.getPolyOne(), model.getPolyTwo()).get(0).print());
            }catch (InvalidPolynomialException exception){
                new ErrorPopUp("Invalid polynomial").setVisible(true);
            }
        }
    }

    class DifferentiationListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                model.setPolyOne(PatternMatching.stringToPolynomial(view.getPolyOne().getText()));
                model.setPolyTwo(PatternMatching.stringToPolynomial(view.getPolyTwo().getText()));
                DifferentiatePolynomial differentiation = new DifferentiatePolynomial();
                view.setResult(differentiation.calculate(model.getPolyOne(), model.getPolyTwo()).get(0).print());
            }catch (InvalidPolynomialException exception){
                new ErrorPopUp("Invalid polynomial").setVisible(true);
            }
        }
    }

    class ResetListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getPolyOne().setText("");
            view.getPolyTwo().setText("");
            view.getResult().setText("");
        }
    }

}
