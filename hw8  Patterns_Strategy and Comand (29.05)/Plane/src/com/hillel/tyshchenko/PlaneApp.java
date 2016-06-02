package com.hillel.tyshchenko;

/**
 * Created by roman on 30.05.16.
 */
public class PlaneApp {
    public static void main(String[] args) {
        PlaneStates psFly = new Fly();
        PlaneStates psGround = new Ground();
        PlaneStates psShoot = new Shoot();
        PlaneStates psAmunition = new Amunition();
        //PlaneStates psMasinGun = new MachineGun();
        PlaneStates psRocket = new Rocket();

        Plane plane = new Plane(psFly);

        plane.setPlaneStates(psShoot);
        plane.performAction(psShoot);

        plane.setPlaneStates(psFly);
        plane.performAction(psFly);

        plane.setPlaneStates(psShoot);
        plane.performAction(psShoot);

        plane.setPlaneStates(psAmunition);
        plane.performAction(psAmunition);

        plane.setPlaneStates(psShoot);
        plane.performAction(psShoot);

        plane.setPlaneStates(psRocket);
        plane.performAction(psRocket);

        plane.setPlaneStates(psShoot);
        plane.performAction(psShoot);

        plane.setPlaneStates(psGround);
        plane.performAction(psGround);

        plane.setPlaneStates(psShoot);
        plane.performAction(psShoot);
    }
}

class Plane {
    PlaneStates planeStates;
    private boolean isFlying;
    private boolean isAmunition;
    private boolean isWeaponry;


    public Plane(PlaneStates planeStates) {
        this.planeStates = planeStates;
    }

    public void setPlaneStates(PlaneStates planeStates) {
        this.planeStates = planeStates;
    }

    void performAction(PlaneStates ps) {
        if (ps instanceof Shoot && !isFlying) {
            System.out.println("Plane on the ground! You can't shoot now!");
            return;
        }
        if (ps instanceof Fly) {
            isFlying = true;
        }
        if (ps instanceof Ground) {
            isFlying = false;
        }
        if (ps instanceof Shoot && !isAmunition) {
            System.out.println("Plane without amunition. You can't shoot now!");
            return;
        }
        if (ps instanceof Amunition) {
            isAmunition = true;
        }
        if (ps instanceof Shoot && !isWeaponry) {
            System.out.println("Plane without weapontry. You can't shoot now!");
            return;
        }
        if (ps instanceof Weaponry) {
            isWeaponry = true;
        }
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

class Shoot implements PlaneStates {

    public void action() {
        System.out.println("Plain is SHOOT ......");
    }
}

class Amunition implements PlaneStates {
    public void action() {
        System.out.println("Amunition is loaded");
    }
}

interface Weaponry {
    void action();
}

class MachineGun implements Weaponry, PlaneStates {
    public void action() {
        System.out.println("Machin gun is loaded");
    }
}

class Gun implements Weaponry, PlaneStates {
    public void action() {
        System.out.println("Gun is loaded");
    }
}

class Rocket implements Weaponry, PlaneStates {
    public void action() {
        System.out.println("Rocket is loaded");
    }
}
