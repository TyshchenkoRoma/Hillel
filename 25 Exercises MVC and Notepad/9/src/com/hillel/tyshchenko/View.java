package com.hillel.tyshchenko;

/**
 * Created by roman on 25.04.16.
 */
public class View {
    // Text's constants
    public final static String ADDED_ARRAY = "Result array is: ";

    public void concatenationAndPrint(String... s) {
        StringBuffer sb = new StringBuffer();
        for (String v : s) {
            sb.append(v);
        }
        System.out.println(sb);
    }
}
