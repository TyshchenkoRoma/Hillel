package com.hillel.tyshchenko;

/**
 * Created by roman on 27.05.16.
 */
public class Work implements Activity {
    public void doSomething (Human context){
        System.out.println("Working .... ");
        context.setState(new  WeekEnd());
    }
}
