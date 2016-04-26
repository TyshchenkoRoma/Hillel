package com.hillel.tyshchenko;


import java.util.Arrays;

/**
 * Created by roman on 25.04.16.
 */
public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        view.concatenationAndPrint(view.ADDED_ARRAY, Arrays.toString(model.getArrayAddIndex()));
    }
}
