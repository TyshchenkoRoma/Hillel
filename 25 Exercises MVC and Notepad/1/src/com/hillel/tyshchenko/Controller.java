package com.hillel.tyshchenko;

/**
 * Created by roman on 21.04.16.
 */
public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        view.concatenstionMessege(view.SUM, String.valueOf(model.getSumArray(model.array)));
    }
}
