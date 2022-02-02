package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

//Clasa pentru construirea interfetei grafice

public class GUI extends JFrame{
    private JPanel panel;
    private JLabel labelPolynomialCalculator;
    private JLabel labelPolyOne;
    private JTextField polyOne;
    private JLabel labelPolyTwo;
    private JTextField polyTwo;
    private JLabel labelResult;
    private JTextField result;
    private JButton btnAdd;
    private JButton btnSubtract;
    private JButton btnMultiply;
    private JButton btnDivide;
    private JButton btnIntegrate;
    private JButton btnDifferentiate;
    private JButton reset;


    public GUI(){
        setTitle("Polynomial Calculator");
        setBounds(100, 100, 660, 740);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(new Color(186, 200, 222));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        labelPolynomialCalculator = new JLabel("Polynomial Calculator");
        labelPolynomialCalculator.setHorizontalAlignment(SwingConstants.CENTER);
        labelPolynomialCalculator.setForeground(new Color(188, 143, 143));
        labelPolynomialCalculator.setFont(new Font("Copper Black", Font.BOLD, 30));
        labelPolynomialCalculator.setBounds(0, 10, 650, 52);
        panel.add(labelPolynomialCalculator);

        labelPolyOne = new JLabel("First polynomial: ");
        labelPolyOne.setHorizontalAlignment(SwingConstants.LEFT);
        labelPolyOne.setForeground(new Color(188, 143, 143));
        labelPolyOne.setFont(new Font("Copper Black", Font.BOLD, 20));
        labelPolyOne.setBounds(20, 100, 200, 30);
        panel.add(labelPolyOne);

        polyOne = new JTextField();
        polyOne.setForeground(new Color(188, 143, 143));
        polyOne.setFont(new Font("Copper Black", Font.BOLD, 20));
        polyOne.setColumns(10);
        polyOne.setBounds(220, 100, 400, 30);
        panel.add(polyOne);

        labelPolyTwo = new JLabel("Second polynomial: ");
        labelPolyTwo.setHorizontalAlignment(SwingConstants.LEFT);
        labelPolyTwo.setForeground(new Color(188, 143, 143));
        labelPolyTwo.setFont(new Font("Copper Black", Font.BOLD, 20));
        labelPolyTwo.setBounds(20, 150, 200, 30);
        panel.add(labelPolyTwo);

        polyTwo = new JTextField();
        polyTwo.setForeground(new Color(188, 143, 143));
        polyTwo.setFont(new Font("Copper Black", Font.BOLD, 20));
        polyTwo.setColumns(10);
        polyTwo.setBounds(220, 150, 400, 30);
        panel.add(polyTwo);

        labelResult = new JLabel("Calculated result: ");
        labelResult.setHorizontalAlignment(SwingConstants.LEFT);
        labelResult.setForeground(new Color(188, 143, 143));
        labelResult.setFont(new Font("Copper Black", Font.BOLD, 20));
        labelResult.setBounds(20, 595, 200, 30);
        panel.add(labelResult);

        result = new JTextField();
        result.setForeground(new Color(188, 143, 143));
        result.setFont(new Font("Copper Black", Font.BOLD, 20));
        result.setColumns(10);
        result.setBounds(220, 595, 400, 30);
        panel.add(result);

        btnAdd = new JButton("+");
        btnAdd.setForeground(new Color(255, 255, 255));
        btnAdd.setFont(new Font("Copper Black", Font.BOLD, 40));
        btnAdd.setBackground(new Color(188, 143, 143));
        btnAdd.setBounds(100, 290, 220, 70);
        panel.add(btnAdd);

        btnSubtract = new JButton("-");
        btnSubtract.setForeground(new Color(255, 255, 255));
        btnSubtract.setFont(new Font("Copper Black", Font.BOLD, 40));
        btnSubtract.setBackground(new Color(188, 143, 143));
        btnSubtract.setBounds(330, 290, 220, 70);
        panel.add(btnSubtract);

        btnMultiply = new JButton("x");
        btnMultiply.setForeground(new Color(255, 255, 255));
        btnMultiply.setFont(new Font("Copper Black", Font.BOLD, 40));
        btnMultiply.setBackground(new Color(188, 143, 143));
        btnMultiply.setBounds(100, 370, 220 , 70);
        panel.add(btnMultiply);

        btnDivide = new JButton("/");
        btnDivide.setForeground(new Color(255, 255, 255));
        btnDivide.setFont(new Font("Copper Black", Font.BOLD, 40));
        btnDivide.setBackground(new Color(188, 143, 143));
        btnDivide.setBounds(330, 370, 220, 70);
        panel.add(btnDivide);

        btnIntegrate = new JButton("∫");
        btnIntegrate.setForeground(new Color(255, 255, 255));
        btnIntegrate.setFont(new Font("Copper Black", Font.BOLD, 40));
        btnIntegrate.setBackground(new Color(188, 143, 143));
        btnIntegrate.setBounds(100, 450, 220, 70);
        panel.add(btnIntegrate);

        btnDifferentiate = new JButton("d/dx");
        btnDifferentiate.setForeground(new Color(255, 255, 255));
        btnDifferentiate.setFont(new Font("Copper Black", Font.BOLD, 30));
        btnDifferentiate.setBackground(new Color(188, 143, 143));
        btnDifferentiate.setBounds(330, 450, 220, 70);
        panel.add(btnDifferentiate);

        reset = new JButton("Reset");
        reset.setForeground(new Color(255, 255, 255));
        reset.setFont(new Font("Copper Black", Font.BOLD, 15));
        reset.setBackground(new Color(188, 143, 143));
        reset.setBounds(520, 200, 100, 40);
        panel.add(reset);
    }

    public JTextField getPolyOne(){
        return this.polyOne;
    }

    public JTextField getPolyTwo(){
        return this.polyTwo;
    }

    public JTextField getResult(){
        return this.result;
    }

    public void setResult(String result){
        this.result.setText(result);
    }

    //Metode pentru adaugarea ActonListener pentru fiecare dintre cele 7 butoane ale interfetei (6 operatii + butonul de reset)

    public void addAdditionListener(ActionListener add){
        this.btnAdd.addActionListener(add);
    }

    public void addSubtractionListener(ActionListener subtract){
        this.btnSubtract.addActionListener(subtract);
    }

    public void addMultiplicationListener(ActionListener multiply){
        this.btnMultiply.addActionListener(multiply);
    }

    public void addDivisionListener(ActionListener divide){
        this.btnDivide.addActionListener(divide);
    }

    public void addIntegrationListener(ActionListener integrate){
        this.btnIntegrate.addActionListener(integrate);
    }

    public void addDifferentiationListener(ActionListener differentiate){
        this.btnDifferentiate.addActionListener(differentiate);
    }

    public void addResetListener(ActionListener reset){
        this.reset.addActionListener(reset);
    }
}
