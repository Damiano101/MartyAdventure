package edu.unibo.martyadventure.model.character;

public enum Shoes {
    FAST("Running", 10), SLOW("Normal", 5);

    private String name;
    private int speed;

    Shoes(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}