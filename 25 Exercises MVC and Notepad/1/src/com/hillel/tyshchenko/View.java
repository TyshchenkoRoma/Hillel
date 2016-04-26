package com.hillel.tyshchenko;

/**
 * Created by roman on 21.04.16.
 */
public class View {
    public final static String SUM = "sum = ";

    public void concatenstionMessege (String ... m) {
        StringBuffer mes = new StringBuffer();
        for (String v : m ) {
            mes.append(v);
        }
        System.out.println(mes);
    }
}
