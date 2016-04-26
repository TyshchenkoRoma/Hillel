package com.hillel.tyshchenko;

/**
 * Created by roman on 22.04.16.
 */
public class View {
    public final static String MID = "number of values = ";

    public void concatenationAndPrint(String... m) {
        StringBuffer sb = new StringBuffer();
        for (String s : m) {
            sb.append(s);
        }
        System.out.println(sb);
    }
}
