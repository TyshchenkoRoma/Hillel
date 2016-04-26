package com.Hillel.tyshchenko;


import java.util.Scanner;

/**
 * Created by roman on 07.04.16.
 */
public class Controller {
    private Model model;
    private View view;

    // Constructor
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    // The Work method
    public void processUser() {
        view.concatenationAndPrint(view.GUESS);
        Scanner sc = new Scanner(System.in);
        while (true) {
            int inputValue = chackingTruesEnter(sc);
            if (model.usersWin(inputValue)) break;
            model.comparindValues(inputValue);
            view.printInputValueAndHistory(inputValue, model.getMaxBarier(), model.getMinBarier(), model.getInputValueList());
        }
        view.concatenationAndPrint(view.CONGRATULATION);
    }

    // The Utility methods

    /**
     * this method cheching input values (inputValue)
     * to INTEGER, range and
     * invite user to enter values from diapasone,
     *
     */

    public int chackingTruesEnter(Scanner sc) {
        int next;
        while (true) {
            if (sc.hasNextInt()) {
                next = sc.nextInt();
                if (next >= model.getMinBarier() && next <= model.getMaxBarier())
                    break;
            } else {
                sc.next();
            }
            view.concatenationAndPrint(String.format(view.WRONG, model.getMinBarier(),
                    model.getMaxBarier()));
        }
        return next;
    }


}
