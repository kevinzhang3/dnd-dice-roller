package View;

import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class View extends JFrame implements Observer {

    /**
     * input number of dice and sides
     */
    private JTextField diceCount;
    private JTextField diceSides;

    /**
     * input any modifiers
     */
    private JTextField abilityModifierInput;

    /**
     * input any proficiency bonuses
     */
    private JTextField profBonusInput;

    /**
     * display outputted damage
     */
    private JLabel damageResult;

    /**
     * input enemy armor class
     */
    private JTextField enemyAcInput;

    /**
     * begin the calculation
     */
    private JButton startCalc;

    public View() {
        JPanel panel = new JPanel();
        diceCount = new JTextField("Input number of dice");
        diceSides = new JTextField("Input number of sides per die");
        abilityModifierInput = new JTextField("Input any modifiers (default 0)");
        profBonusInput = new JTextField("Input any proficiency bonuses (default 0)");
        enemyAcInput = new JTextField("Input enemy armor class");
        damageResult = new JLabel("");
        startCalc = new JButton("Calculate damage!");

        panel.setLayout(new GridLayout(4, 3));

        panel.add(diceCount);
        panel.add(diceSides);
        panel.add(abilityModifierInput);
        panel.add(profBonusInput);
        panel.add(enemyAcInput);
        panel.add(damageResult);
        panel.add(startCalc);

        this.setContentPane(panel);

    }

    /**
     * assign action listener
     * @param al
     */
    public void assignListener(ActionListener al) {
        startCalc.addActionListener(al);
    }

    /**
     * getters
     */
    public int getAbilityModifierInput() {
        String s = abilityModifierInput.getText();
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int getDiceCount() {
        String s = diceCount.getText();
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int getDiceSides() {
        String s = diceSides.getText();
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int getEnemyAcInput() {
        String s = enemyAcInput.getText();
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int getProfBonusInput() {
        String s = profBonusInput.getText();
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * getter for damageResult
     */
    public JLabel getDamageResult() {
        return damageResult;
    }

    /**
     * called whenever observable object is changed and view is notified
     * @param o     the observable object.
     * @param arg   an argument passed to the {@code notifyObservers}
     *                 method.
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Model) {
            Model m = (Model) o;
            int damage = m.getFinalDamage();
            int attack = m.getFinalAttackRoll();
            if (damage == -2) {
                damageResult.setText("Miss (You rolled " + attack + ")");
            } else if (damage == -1) {
                damageResult.setText("Critical miss...");
            } else damageResult.setText("You did " + damage + " damage!");
        }

    }
}
