package com.hillel.tyshchenko;

import javax.swing.text.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.processUser();

      //  System.out.println("count = " + model.count(model.array));
    }
}