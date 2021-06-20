package edu.unibo.martyadventure.view.character;

public enum Player {
    MARTY("Marty"),
    BIFF("Biff"),
    DOC("Doc");
    
    private final String name;

    Player(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }

}
