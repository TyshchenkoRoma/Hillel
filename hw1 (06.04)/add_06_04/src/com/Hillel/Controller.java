package com.Hillel;

import java.util.Scanner;

/**
 * Created by roman on 07.04.16.
 */
public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }



    /*Adding values*/
    public void processUser() {
        Scanner sc = new Scanner(System.in);
        model.setValueA(inputIntValueWithScanner(sc));
        model.setValueB(inputIntValueWithScanner(sc));

       int resultOfAdding = model.addValue(model.getValueA(), model.getValueB());
        view.printResult(view.RESULT, resultOfAdding);
    }

    public int inputIntValueWithScanner(Scanner sc) {
        view.printMessege(view.INPUT_VALUE);
        while (!sc.hasNextInt()) {
            view.printMessege(view.WRONG_ONPUT + view.INPUT_VALUE);
            sc.next();
        }
        return sc.nextInt();
    }
}
