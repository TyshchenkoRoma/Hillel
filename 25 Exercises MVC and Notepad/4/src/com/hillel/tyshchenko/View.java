package com.hillel.tyshchenko;

/**
 * Created by roman on 22.04.16.
 */
public class View {
    public static final String MID = "middle range  = ";

    public void concatenationAndPrint(String... s) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String v : s) {
            stringBuffer.append(v);
        }
        System.out.println(stringBuffer);
    }
}
