package com.hillel.tyshchenko;

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
        model.setMinEl(model.min(model.array, model.getIndex(), model.getMinEl()));
        view.printMassege(String.format(view.MIN_EL_AND_INDEX,
                model.getMinEl(),
                model.findIndexMinEl(model.array, model.getMinEl(), model.getIndexMinEL())));
    }
}
