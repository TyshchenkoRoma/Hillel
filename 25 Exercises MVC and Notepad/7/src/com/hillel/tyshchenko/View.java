package com.hillel.tyshchenko;

/**
 * Created by roman on 22.04.16.
 */
public class View {

    public final static String COUNT = "count values more then 0 is ";

    public void concatenationAndPrint(String... s) {
        StringBuffer sb = new StringBuffer();
        for (String m : s) {
            sb.append(m);
        }
        System.out.println(sb);
    }
}
