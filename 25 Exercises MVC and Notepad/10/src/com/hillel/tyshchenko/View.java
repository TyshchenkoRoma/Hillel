package com.hillel.tyshchenko;

/**
 * Created by roman on 26.04.16.
 */
public class View {
    // Text's constants
    public static final String NEW_ARRAY = "Array whis zeros is: ";

    public void concatenationAndPrint(String... s) {
        StringBuffer sb = new StringBuffer();
        for (String v : s) {
            sb.append(v);
        }
        System.out.println(sb);
    }
}
