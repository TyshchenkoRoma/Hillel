package com.Hillel.tyshchenko;

import java.util.List;

/**
 * Created by roman on 07.04.16.
 */
public class View {
    // Text's constants
    public final String GUESS = "Input value from 0 to 100";
    public final String INPUT = "Input new Value from %d to %d";
    public final String CONGRATULATION = "CONGRATULATION YOU WIN";
    public final String WRONG = "Wrong value! input INT from %d to %d ";
    public final String LAST_VALUES = "Last Entered values is:";
    public final String ENTERED_VALUES = "Entered values is:";

    public void concatenationAndPrint(String... message) {
        StringBuffer concatString = new StringBuffer();
        for (String v : message) {
            concatString = concatString.append(v);
        }
        System.out.println(concatString);
    }

    /**
     * this metod invite user to enter values from diapasone,
     * print last input values and all input values
     *
     * @param inputValueList all input values
     */
    public void printInputValueAndHistory(int inputValue, int maxBarier, int minBarier, List inputValueList) {
        concatenationAndPrint(String.format(INPUT, minBarier, maxBarier));
        concatenationAndPrint(LAST_VALUES, String.valueOf(inputValue));
        concatenationAndPrint(ENTERED_VALUES, String.valueOf(inputValueList));
    }
}
