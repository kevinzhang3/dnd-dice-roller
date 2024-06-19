package Model;

import java.util.Observable;
import java.util.Random;

public class Model extends Observable {


    public Model() {
    }

    public boolean calculateAttack(int modifier, int profBonus, int enemyAC) {
        Random rand = new Random();

        // roll 1d20
        int roll = rand.nextInt(21) - 1;

        // return dice roll + bonuses vs. enemy armor class
        return (roll+modifier+profBonus) >= enemyAC;
    }

    public int calculateDamage(int sides, int count, int modifier, int profBonus, int enemyAC) {

        // true if hit succeeds false otherwise
        if (this.calculateAttack(modifier, profBonus, enemyAC)) {
            // store damage
            int damage = 0;

            // for randomizing rolls
            Random rand = new Random();

            // generate attack roll
            if (count > 1) {
                for (int i = 0; i < count; i++) {
                    damage += rand.nextInt(sides - 1) + 1;
                }
            } else {
                damage = rand.nextInt(sides - 1) + 1;
            }

            return (damage + modifier);
        }
        // miss hit
        return 0;
    }

}
