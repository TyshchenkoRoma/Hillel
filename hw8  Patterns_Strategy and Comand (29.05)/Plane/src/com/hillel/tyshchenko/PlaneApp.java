package com.hillel.tyshchenko;

/**
 * Created by roman on 30.05.16.
 */
public class PlaneApp {
    public static void main(String[] args) {
        PlaneStates ps = new Fly();
        PlaneStates psGround = new Ground();
        PlaneStates psShoot = new Shoot();

        Plane plane = new Plane(ps);
        plane.setPlaneStates(ps);
        plane.performAction(ps);

        plane.setPlaneStates(psShoot);
        plane.performAction(psShoot);
    }
}

class Plane {
    PlaneStates planeStates;

    public Plane(PlaneStates planeStates) {
        this.planeStates = planeStates;
    }

    public void setPlaneStates(PlaneStates planeStates) {
        this.planeStates = planeStates;
    }

    void performAction(PlaneStates ps) {

        ps.action();
    }
}

interface PlaneStates {
    void action();
}

class Fly implements PlaneStates {
    @Override
    public void action() {
        System.out.println("Plane is flying");
    }
}

class Ground implements PlaneStates {
    @Override
    public void action() {
        //     if ()
        System.out.println("Plane on the grount");
    }
}

class Shoot extends Fly {
    public void action(Fly fly) {
        System.out.println("Plain is SHOOT ......");
    }
}
