package model;

import model.datastructures.Polynomial;

//Clasa pentru retinerea celor doua polinoame transmise ca input si apoi validate

public class Model {
    private Polynomial polyOne;
    private Polynomial polyTwo;

    public Model(){
        polyOne = null;
        polyTwo = null;
    }

    public Polynomial getPolyOne() {
        return polyOne;
    }

    public void setPolyOne(Polynomial polyOne) {
        this.polyOne = polyOne;
    }

    public Polynomial getPolyTwo() {
        return polyTwo;
    }

    public void setPolyTwo(Polynomial polyTwo) {
        this.polyTwo = polyTwo;
    }
}
