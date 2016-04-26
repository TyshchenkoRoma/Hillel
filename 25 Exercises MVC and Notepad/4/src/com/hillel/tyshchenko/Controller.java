package com.hillel.tyshchenko;

/**
 * Created by roman on 22.04.16.
 */
public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        view.concatenationAndPrint(view.MID, String.valueOf(model.getMiddleRange(model.array)));
    }
}
