package com.hillel.tyshchenko;

/**
 * Created by roman on 24.04.16.
 */
public class View {
    public static final String NEW_ARRAY = "Multiplicationed array is ";

    public void concatenationAndPrint(String... s) {
        StringBuffer sb = new StringBuffer();
        for (String v : s) {
            sb.append(v);
        }
        System.out.println(sb);
    }
}
