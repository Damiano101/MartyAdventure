package test.edu.unibo.martyadventure.model.weapon;

import java.util.ArrayList;
import java.util.List;
import edu.unibo.martyadventure.model.weapon.*;
import edu.unibo.martyadventure.model.weapon.Weapon.WeaponType;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestWeaponFactory {
    String name = "Weapon1";
    WeaponType type = WeaponType.MELEE;
    int damageMultiplier = 10;
    List<Move> moveList = new ArrayList<>(List.of(Move.UPPERCUT, Move.HOOK, Move.JAB, Move.SUPERMANPUNCH));
    Weapon weaponTest = WeaponFactory.newWeapon(name, type, damageMultiplier, moveList);

    @Test
    void testNewWeapon() {
        weaponTest = WeaponFactory.newWeapon(name, type, damageMultiplier, moveList);
        assertEquals(name, weaponTest.getName());
        assertEquals(type, weaponTest.getType());
        assertEquals(damageMultiplier, weaponTest.getDamageMultiplier());
        assertEquals(moveList, weaponTest.getMoveList());

        // System.err.println("testLoadingWeapon ok");
    }

    @Test
    void testSetWeaponMove() {
        weaponTest = WeaponFactory.setWeaponMove(weaponTest, Move.UPPERCUT, Move.HOOK, Move.JAB, Move.SUPERMANPUNCH);
        assertEquals(moveList, weaponTest.getMoveList());

        // System.err.println("testCreateWeapon ok");
    }

    @Test
    void testCreateRandomWeapon() {
        weaponTest = WeaponFactory.createRandomWeapon(weaponTest.getName(), weaponTest.getDamageMultiplier());
        checkDuplicateItemsInMoveList(weaponTest);
        // weaponTest.printWeapon();
        // System.err.println("testCreateRandomWeapon ok");
    }

    @Test
    void testCreateRandomMeleeWeapon() {
        weaponTest = WeaponFactory.createRandomMeleeWeapon(weaponTest.getName(), weaponTest.getDamageMultiplier());
        checkDuplicateItemsInMoveList(weaponTest);
        // check if the items of moveList are all melee MOVE
        for (int i = 0; i < 4; i++) {
            assertEquals(weaponTest.getMoveList().get(i).getMeleeOrRanged(), 'M');
        }

        // weaponTest.printWeapon();
        // System.err.println("testCreateRandomWeapon ok");
    }

    @Test
    void testCreateRandomRangedWeapon() {
        weaponTest = WeaponFactory.createRandomRangedWeapon(weaponTest.getName(), weaponTest.getDamageMultiplier());
        checkDuplicateItemsInMoveList(weaponTest);
        // check if the items of moveList are all ranged MOVE
        for (int i = 1; i < 4; i++) {
            assertEquals(weaponTest.getMoveList().get(i).getMeleeOrRanged(), 'R');
        }

        // weaponTest.printWeapon();
        // System.err.println("testCreateRandomWeapon ok");
    }

    @Test
    void testRandomWeaponLevel() {
        for (int level = 1; level < 4; level++) {
            weaponTest = WeaponFactory.randomWeaponLevel(weaponTest.getName(), level);
            assertTrue(weaponTest.getDamageMultiplier() >= WeaponFactory.randomDamageMultiplier() * level
                    || weaponTest.getDamageMultiplier() <= WeaponFactory.randomDamageMultiplier() * level);
        }
    }

    // Function to check if there is a duplicate items in a moveList
    void checkDuplicateItemsInMoveList(Weapon weaponTest) {
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                assertNotEquals(weaponTest.getMoveList().get(i), weaponTest.getMoveList().get(j));
            }
        }
    }

}
