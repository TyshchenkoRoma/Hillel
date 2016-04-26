package com.Hillel.tyshchenko;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by roman on 10.04.16.
 */
public class Controller {

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    Model model = new Model();
    View view;
    int[] arrayInputValues = new int[3];

    public void processUser() {
        view.printMessageAndArray(view.INPUT_VALUES, inputValue(arrayInputValues));
        view.printMessageAndDoubl(view.MIDDLE, model.findMiddleValue(arrayInputValues));
        view.printMessageAndInt(view.NEAR_INT, Math.round((float) (model.findMiddleValue(arrayInputValues))));
    }

    public int[] inputValue(int[] arrayInputValues) {
        view.printMessage(view.ASK);
        for (int i = 0; i < arrayInputValues.length; i++) {
            Scanner sc = new Scanner(System.in);
            arrayInputValues[i] = sc.nextInt();
        }
        return arrayInputValues;
    }
}
