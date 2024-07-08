package Model;

import java.util.Observable;
import java.util.Random;

// USE STRATEGY DESIGN PATTERN TO SWITCH BETWEEN WEAPONS INSTEAD OF PROMPTING FOR DICE SIDES AND DICE COUNT

public class Model extends Observable {

    private int finalDamage;

    private int finalAttackRoll;


    public Model() {
        this.finalDamage = 0;
    }


    public void calculateDamage(int sides, int count, int modifier, int profBonus, int enemyAC) throws InvalidDiceException {

        Random rand = new Random();

        if (sides == 0 || count == 0) {
            throw new InvalidDiceException("You must input a valid dice!");
        }

        int natAttack = rand.nextInt(20) + 1;
        int attackRoll = natAttack + profBonus + modifier;

        // critical miss
        if (natAttack == 1) {
            this.finalDamage = -1;
            this.setChanged();
            this.notifyObservers();
        }

        // miss
        else if (attackRoll < enemyAC) {
            this.finalDamage = -2;
            this.finalAttackRoll = attackRoll;
            this.setChanged();
            this.notifyObservers();
        }

        // true if hit succeeds false otherwise
        else {
            // store damage
            int damage = 0;

            // generate attack roll
            if (count > 1) {
                for (int i = 0; i < count; i++) {
                    damage += rand.nextInt(sides) + 1;
                }
            } else {
                damage = rand.nextInt(sides) + 1;
            }

            // final outputted damage
            this.finalDamage = (damage + modifier);
            this.setChanged();
            this.notifyObservers();
        }
    }

    public int getFinalDamage() {
        return finalDamage;
    }

    public int getFinalAttackRoll() {
        return finalAttackRoll;
    }
}
