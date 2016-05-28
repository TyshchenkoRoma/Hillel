package com.hillel.tyshchenko;

/**
 * Created by roman on 27.05.16.
 */
public class Human {
    State plase;

    public void setState(State pl) {
        this.plase = pl;
    }

    public void takeSomething() {
        plase.takeSomething();
    }
}
