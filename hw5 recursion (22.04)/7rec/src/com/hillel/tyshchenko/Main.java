package com.hillel.tyshchenko;

public class Main {

    public static void main(String[] args) {

        //Inicialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(view, model);

        //Run
        controller.processUser();
    }
}
