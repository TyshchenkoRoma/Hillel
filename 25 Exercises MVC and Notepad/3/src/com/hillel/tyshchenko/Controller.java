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
        int minValue = model.getMin(model.array, model.min);
        view.concatenationAndPrint(view.MIN_VAL, String.valueOf(model.getMin(model.array, model.min)),
                view.MIN_INDEX, String.valueOf(model.getMinIndex(model.array, minValue)));

    }
}
