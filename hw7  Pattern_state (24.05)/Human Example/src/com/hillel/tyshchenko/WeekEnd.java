package com.hillel.tyshchenko;

/**
 * Created by roman on 27.05.16.
 */
public class WeekEnd implements Activity {
    private int count = 0;
   public void doSomething (Human context){
        if (count < 3) {
            System.out.println("I am free ------------");
            count++;
        } else {
            context.setState(new Work());
        }

    };
}
