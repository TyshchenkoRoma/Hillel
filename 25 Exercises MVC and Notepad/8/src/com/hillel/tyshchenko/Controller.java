package com.hillel.tyshchenko;

import java.util.Arrays;

/**
 * Created by roman on 24.04.16.
 */
public class Controller {
    Mobel mobel;
    View view;

    public Controller(Mobel mobel, View view) {
        this.mobel = mobel;
        this.view = view;
    }
    public void processUser() {
        view.concatenationAndPrint(String.format(view.NEW_ARRAY, Arrays.toString(mobel.multiplication())));
    }
}
