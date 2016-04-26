package com.hillel.tyshchenko;



public class Main {
    public static void main(String[] args) {
        Mobel mobel = new Mobel();
        View view = new View();
        Controller controller = new Controller(mobel, view);

        controller.processUser();
    }
}
