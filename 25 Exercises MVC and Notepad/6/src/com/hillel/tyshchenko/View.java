package com.hillel.tyshchenko;

/**
 * Created by roman on 22.04.16.
 */
public class View {
    public static final String NUMB_VALUES_0 = " number of 0 is ";

    public void concatenationAndPrint (String ... st) {
        StringBuffer sb = new StringBuffer();
        for (String v : st) {
            sb.append(v);
        }
        System.out.println(sb);
    }
}
