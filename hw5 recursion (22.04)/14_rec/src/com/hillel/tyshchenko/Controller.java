package com.hillel.tyshchenko;

/**
 * Created by roman on 10.05.16.
 */
public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        System.out.println(String.format(view.NUMBER, model.givenEl, model.getNumberEl(model.array)));
    }
}
