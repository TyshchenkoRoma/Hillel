package com.hillel.tyshchenko;


public class Main {

    public static void main(String[] args) {
        Station st1 = new Radio7();
        Radio radio = new Radio();
        radio.setStation(st1);
        for (int i = 0; i < 10; i++) {
            radio.play();
            radio.nextStation();
        }
    }
}
