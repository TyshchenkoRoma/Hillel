package com.hillel.tyshchenko;

import java.util.ArrayList;

/**
 * Created by roman on 27.05.16.
 */
public class Human {
    ArrayList<State> states = new ArrayList<>();

    public void setState(State pl) {
        this.states.add(pl);
    }

    public void takeSomething() {
        for (State st : states) {
            st.takeSomething();
        }
        states.clear();
    }
}