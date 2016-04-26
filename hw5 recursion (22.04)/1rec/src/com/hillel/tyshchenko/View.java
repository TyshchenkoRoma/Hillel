package com.hillel.tyshchenko;

/**
 * Created by roman on 25.04.16.
 */
public class View {

    // Constants
    public final static String SUM = "Sum of element is: ";

    // Work metods
    public void concatenationAndPrint(String... m) {
        StringBuffer sb = new StringBuffer();
        for (String v : m) {
            sb.append(v);
        }
        System.out.println(sb);
    }
}
