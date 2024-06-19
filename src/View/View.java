package View;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class View extends JFrame implements Observer{

    /**
     * input number of dice and sides
     */
    private JTextField damageRollInput;

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
    private JTextField damageResult;

    /**
     * display enemy armor class
     */
    private JTextField enemyAcInput;

    /**
     * begin the calculation
     */
    private JButton startCalc;

    public View() {
        // do stuff
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
