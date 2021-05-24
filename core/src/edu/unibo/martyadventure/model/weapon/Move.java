package edu.unibo.martyadventure.model.weapon;

import java.util.Random;

/*
 * Enum class that contains all Move included in the game
 */
public enum Move {
    // moveNAME(name, dmg, failRatio, reloadTime , Melee or Ranged, lastUse)
    
    //FIST, BRASS KNUCKLES MOVE
    HOOK("Gancio", 5, 10, 1, 'M', 0),
    JAB("Diretto", 6, 20, 1, 'M', 0),
    UPPERCUT("Montate", 7, 30, 2, 'M', 0),
    SUPERMANPUNCH("SupermanPunch", 10, 40, 2, 'M', 0),
    
    //BASEBALL BAT, CROWBAR, SLEDGEHUMMER MOVE 
    LOWDAMAGE("Colpo Debole", 5, 10, 0, 'M', 0),
    HANDLESHOT("Colpo di Manico", 6, 20, 0, 'M', 0 ),
    HIGHDAMAGE("Colpo Potente", 8, 30, 2, 'M', 0 ),
    TEMPLESHOT("Colpo alla Tempia", 12, 40, 2, 'M', 0),
    
    //KNIFE MOVE
    THRUST("Pugnalata", 7, 20, 2, 'M', 0 ),
    STAB("Coltellata", 8, 20, 2, 'M', 0 ),
    TROW("Lancio", 15, 70, 5, 'R', 0),
    
    //REVOLVER MOVE
    GRAZEDSHOT("Colpo di Striscio", 10, 20, 2, 'R', 0),
    BODYSHOT("Colpo al Corpo", 15, 30, 4, 'R', 0),
    HEADSHOT("Colpo alla Testa", 30, 70, 4, 'R', 0);

    private final String name;
    private final int damage;
    private final int failRatio; // 0 success 100 fail
    private final int reloadTime;
    private final char MeleeOrRanged;
    private int lastUse; // last turn of use
    private Random rand = new Random();

    private Move(String name, int damage, int failRatio, int reloadTime, char MeleeOrRanged, int lastUse) {
        this.name = name;
        this.damage = damage;
        this.failRatio = failRatio;
        this.reloadTime = reloadTime;
        this.MeleeOrRanged = MeleeOrRanged;
        setLastUse(lastUse);
    }

    // Getter & Setter
    public int getDamage() {
        return damage;
    }

    public int getFailRatio() {
        return failRatio;
    }

    public int getReloadTime() {
        return reloadTime;
    }

    public char getMeleeOrRanged() {
        return MeleeOrRanged;
    }

    public int getLastUse() {
        return lastUse;
    }

    public String getName() {
        return name;
    }

    public void setLastUse(int lastUse) {
        this.lastUse = lastUse;
    }

    // Check if the move can be used
    public boolean isUsable(int fightTurn) {
        if (lastUse + reloadTime < fightTurn || lastUse == 0) {
            this.lastUse = fightTurn;
            return true;
        } else
            return false;
    }

    // Check if the move fail
    public boolean testFailure() {
        // random number (0 to 100) if it's >= than failRatio success(TRUE), else
        // fail(FALSE)
        return rand.nextInt(101) >= failRatio;
    }

    // Random Functions

    // Generic random move
    public static Move getRandomMove() {
        return values()[(int) (Math.random() * values().length)];
    }

    // Melee random move
    public static Move getRandomMeleeMove() {
        Move MELEE;
        do {
            MELEE = getRandomMove();
        } while (MELEE.getMeleeOrRanged() != 'M');

        return MELEE;
    }

    // Ranged random move
    public static Move getRandomRangedMove() {
        Move RANGED;
        do {
            RANGED = getRandomMove();
        } while (RANGED.getMeleeOrRanged() != 'R');

        return RANGED;
    }

}