package com.hillel.tyshchenko;

/**
 * Created by roman on 22.04.16.
 */
public class View {
    public static final String MIN_VAL = " min value = ";
    public static final String MIN_INDEX = " min index =  ";

    public void concatenationAndPrint(String... s) {
        StringBuffer sb = new StringBuffer();
        for (String v : s) {
            sb.append(v);
        }
        System.out.println(sb);
    }
}
