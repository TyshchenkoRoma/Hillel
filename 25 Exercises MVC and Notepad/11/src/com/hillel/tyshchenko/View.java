package com.hillel.tyshchenko;

/**
 * Created by roman on 03.05.16.
 */
public class View {

    public final static String CHANGED_ARRAY = "New array is: %d";

    public void concatenationAndPrint(String... s) {
        StringBuffer sb = new StringBuffer();
        for (String mes : s) {
            sb.append(mes);
        }
        System.out.println(sb);
    }
}
