package Controller;

import Model.Model;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            model.calculateDamage(view.getDiceSides(), view.getDiceCount(), view.getAbilityModifierInput(), view.getProfBonusInput(), view.getEnemyAcInput());
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
