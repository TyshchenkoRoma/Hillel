package com.hillel.tyshchenko;

/**
 * Created by roman on 25.05.16.
 */
public class Radio {
    Station station;

    public void setStation(Station st) {
        this.station = st;
    }

    void nextStation() {
        if (station instanceof Radio7) {
            setStation(new RadioDFM());
        } else if (station instanceof RadioDFM) {
            setStation(new VestiFM());
        } else if (station instanceof VestiFM) {
            setStation(new Radio7());
        }
    }

    void play() {
        station.play();
    }
}
