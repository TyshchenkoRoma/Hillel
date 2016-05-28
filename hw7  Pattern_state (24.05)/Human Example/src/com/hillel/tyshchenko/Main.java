package com.hillel.tyshchenko;

public class Main {

    public static void main(String[] args) {
        Human human = new Human();
        human.setState(new WeekEnd());
        human.doSomething();
        human.doSomething();
        human.doSomething();
        human.doSomething();
        human.doSomething();
        human.doSomething();
    }
}
