package com.hillel.tyshchenko;

import java.util.Arrays;

/**
 * Created by roman on 26.04.16.
 */
public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        view.concatenationAndPrint(view.NEW_ARRAY, Arrays.toString(model.getZiroArrays()));
    }
}
