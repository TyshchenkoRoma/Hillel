package com.hillel.tyshchenko;

public class Main {

    public static void main(String[] args) {
        Human human = new Human();
        State riverCoast = new RiversCoast();
        human.setState(riverCoast);
        human.takeSomething();
        State wood = new Wood();
        human.setState(wood);
        human.takeSomething();
        State enimal = new Enimal();
        human.setState(enimal);
        human.takeSomething();
    }
}
