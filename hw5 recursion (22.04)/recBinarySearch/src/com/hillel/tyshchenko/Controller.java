package com.hillel.tyshchenko;

/**
 * Created by roman on 25.04.16.
 */
public class Controller {
    Model model;
    View view;

    //Consructor
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    // The Work method
    public void processUser() {
        model.binarySearchRecursion(model.getArray(), model.getValue());
        view.printMassege(String.format(view.MIN_EL, model.getArray(),
                model.binarySearchRecursion(model.getArray(), model.getValue())));
    }
}
