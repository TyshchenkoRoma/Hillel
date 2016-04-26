package com.hillel.tyshchenko;

/**
 * Created by roman on 25.04.16.
 */
public class Controller {
    Model model;
    View view;
    // Constructor
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    // The Work method
    public void processUser() {
        view.concatenationAndPrint(view.SUM, String.valueOf(model.fact(model.array, model.getIndex())));
    }
}
