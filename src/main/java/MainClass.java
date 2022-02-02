import controller.Controller;
import model.Model;
import view.GUI;

//Clasa principala, care contine metoda main()
//De aici se pune in executie calculatorul de polinoame

public class MainClass {

    public static void main (String[] args){

        Model model = new Model();
        GUI view = new GUI();
        Controller controller = new Controller(view, model);
        view.setVisible(true);
    }
}
