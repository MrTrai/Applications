package view;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import controller.GameController;
import model.Building;
import model.Settlement;

/**
 * This class should represents the bulding menu
 */
public class BuildingMenu extends AbstractMenu {
    /**
    * there should be an invest and demolish button for this menu
    * as well as functions associated with the buttons
    */
    private Button investBtn = new Button("Invest");
    private Button demolishBtn = new Button("Demolish");

    public BuildingMenu() {
        addMenuItem(investBtn);
        addMenuItem(demolishBtn);

        investBtn.setOnAction(e -> {
                if (GameController.getCivilization()
                        .getTreasury().getCoins() >= 25) {

                    ((Building) (GameController.getLastClicked()
                        .getTile().getOccupant())).invest();

                    GameController.getCivilization().getTreasury().spend(25);

                    GameController.updateResourcesBar();
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText("Can't invest!");
                    alert.setTitle("Error!");
                    alert.showAndWait();
                }
            });
        demolishBtn.setOnAction(e -> {
                if (GameController.getCivilization()
                        .getNumSettlements() >= 1) {
                    if (GameController.getCivilization()
                            .getNumSettlements() == 1) {
                        if (GameController.getLastClicked()
                                .getTile().
                                getOccupant() instanceof Settlement) {
                            Alert alert = new Alert(Alert.
                                    AlertType.CONFIRMATION);
                            alert.
                                setHeaderText("Can't demolish!");
                            alert.setTitle("Error!");
                            alert.showAndWait();
                        } else {
                            ((Building) (GameController.getLastClicked()
                                .getTile().getOccupant())).demolish();

                            GameController.getLastClicked()
                                .getTile().setOccupant(null);

                            GameController.updateResourcesBar();
                        }
                    } else {
                        if (GameController.
                                getLastClicked()
                                .getTile().getOccupant()
                                instanceof Settlement) {

                            ((Building) (GameController.getLastClicked()
                                .getTile().
                                getOccupant())).demolish();

                            GameController.getCivilization()
                                .decrementNumSettlements();

                            GameController.getLastClicked()
                                .getTile().setOccupant(null);

                            GameController.updateResourcesBar();

                            GameController.getCivilization().
                                decrementNumSettlements();
                        } else {
                            ((Building) (GameController.
                                getLastClicked()
                                .getTile().getOccupant())).demolish();

                            GameController.getCivilization()
                                .decrementNumSettlements();

                            GameController.getLastClicked()
                                .getTile().setOccupant(null);

                            GameController.updateResourcesBar();
                        }
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText("Can't demolish!");
                    alert.setTitle("Error!");
                    alert.showAndWait();
                }
            });
    }
}
