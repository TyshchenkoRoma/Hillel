package com.hillel.tyshchenko;

/**
 * Created by roman on 27.05.16.
 */
public class Human {
    private Activity state;
    public void setState(Activity s) {state = s;}

    public void doSomething(){
        state.doSomething(this.state);
    }

}
