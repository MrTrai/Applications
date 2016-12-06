package view;

import javafx.scene.control.Button;

import controller.GameController;

/**
 * Created by William on 11/11/2016.
 */

public class MilitaryMenu extends AbstractMenu {
    /**
    * Implement the buttons and actions associated with
    * the buttons for the military menu
    */
    private Button attackBtn = new Button("Attack");
    private Button moveBtn = new Button("Move");

    public MilitaryMenu() {
        addMenuItem(attackBtn);
        addMenuItem(moveBtn);

        attackBtn.setOnAction(e -> {
                GameController.attacking();
                GameController.updateResourcesBar();
            });

        moveBtn.setOnAction(e -> {
                GameController.moving();
                GameController.updateResourcesBar();
            });
    }
}
