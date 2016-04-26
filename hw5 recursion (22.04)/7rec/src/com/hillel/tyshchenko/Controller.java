package com.hillel.tyshchenko;

/**
 * Created by roman on 26.04.16.
 */
public class Controller {
    Model model;
    View view;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }
    public void processUser () {
       view.printMassege(String.format(view.NUMBER_SERO,
               model.countElMorZero(model.array, model.getCount(), model.getIndex())));
    }
}
