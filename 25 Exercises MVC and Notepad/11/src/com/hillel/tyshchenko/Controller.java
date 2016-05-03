package com.hillel.tyshchenko;

import java.util.Arrays;

/**
 * Created by roman on 03.05.16.
 */
public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        int[] array = model.getZero();
        view.concatenationAndPrint(view.CHANGED_ARRAY, Arrays.toString(array));
    }
}

