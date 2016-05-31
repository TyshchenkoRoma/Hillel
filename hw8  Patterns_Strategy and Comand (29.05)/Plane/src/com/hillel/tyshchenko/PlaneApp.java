package com.hillel.tyshchenko;

public class PlaneApp {
    public static void main(String[] args) {
        PlaneStates ps = new Fly();
        PlaneStates psGround = new Ground();
        PlaneStates psShoot = new Shoot();

        Plane plane = new Plane(ps);

        plane.setPlaneStates(psShoot);
        plane.performAction(psShoot);

        plane.setPlaneStates(ps);
        plane.performAction(ps);

        plane.setPlaneStates(psShoot);
        plane.performAction(psShoot);

        plane.setPlaneStates(psGround);
        plane.performAction(psGround);

        plane.setPlaneStates(psShoot);
        plane.performAction(psShoot);

        plane.setPlaneStates(psShoot);
        plane.performAction(psShoot);

    }
}

class Plane {
    PlaneStates planeStates;
    private boolean isFlying;

    public Plane(PlaneStates planeStates) {
        this.planeStates = planeStates;
        isFlying = false;
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
        System.out.println("Plane on the grount");
    }
}

class Shoot implements PlaneStates {
    public void action() {
        System.out.println("Plain is SHOOT ......");
    }
}
