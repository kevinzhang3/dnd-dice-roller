package Controller;

import Model.Model;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.InvalidDiceException;

public class Controller {

    /**
     * reference to model
     */
    private Model model;

    /**
     * reference to gui
     */
    private View view;


    public class calcButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model.calculateDamage(view.getDiceSides(), view.getDiceCount(), view.getAbilityModifierInput(), view.getProfBonusInput(), view.getEnemyAcInput());
            } catch (InvalidDiceException ex) {
                view.getDamageResult().setText("Invalid dice!");
            }
        }
    }
    /**
     * Constructor for controller
     */
    public Controller(Model m, View v) {
        this.view = v;
        this.model = m;

        calcButtonListener b = new calcButtonListener();
        this.view.assignListener(b);
    }
}
