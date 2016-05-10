package com.hillel.tyshchenko;

public class Main {

// 14. count number elements equal given

    public static void main(String[] args) {

        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        //Run
        controller.processUser();
    }
}
