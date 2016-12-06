package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import controller.GameController;
import model.Unit;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class RecruitMenu extends AbstractMenu {
    /**
     * recuit menu should have a list of worker/units
     * to choose from. There should also be a select button
     * and the function of the button should be implemented
     *here
     */
    private ObservableList list = FXCollections.observableArrayList(
            "Melee Unit",
            "Ranged Unit",
            "Hybrid Unit",
            "Siege Unit",
            "Settlers",
            "Farmers",
            "Coal Miners",
            "Anglers",
            "Master Builders");

    private ListView<String> recruitList = new ListView<>(list);
    private Button select = new Button("Select");

    public RecruitMenu() {
        recruitList.setPrefHeight((list.size() * 24) + 2);
        addMenuItem(recruitList);
        addMenuItem(select);
        select.setOnAction(e -> {
                Unit newUnit;
                switch (recruitList.getSelectionModel().getSelectedItem()) {
                case "Melee Unit":
                    newUnit = GameController
                        .getCivilization().getMeleeUnit();
                    if (newUnit.isAffordable()) {
                        newUnit.applyInitialCosts();
                        GameController
                            .getLastClicked().getTile().setOccupant(
                                GameController
                                .getCivilization().getMeleeUnit());
                    } else {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setHeaderText("Can't afford there!");
                        alert.setTitle("Error!");
                        alert.showAndWait();
                    }
                    break;
                case "Ranged Unit":
                    newUnit = GameController
                        .getCivilization().getRangedUnit();
                    if (newUnit.isAffordable()) {
                        newUnit.applyInitialCosts();
                        GameController
                            .getLastClicked().getTile().setOccupant(
                                GameController
                                .getCivilization().getRangedUnit());
                    } else {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setHeaderText("Can't afford there!");
                        alert.setTitle("Error!");
                        alert.showAndWait();
                    }
                    break;
                case "Hybrid Unit":
                    newUnit = GameController
                        .getCivilization().getRangedUnit();
                    if (newUnit.isAffordable()) {
                        newUnit.applyInitialCosts();
                        GameController
                            .getLastClicked().getTile().setOccupant(
                                GameController
                                .getCivilization().getHybridUnit());
                    } else {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setHeaderText("Can't afford there!");
                        alert.setTitle("Error!");
                        alert.showAndWait();
                    }
                    break;
                case "Siege Unit":
                    newUnit = GameController
                        .getCivilization().getSiegeUnit();
                    if (newUnit.isAffordable()) {
                        newUnit.applyInitialCosts();
                        GameController
                            .getLastClicked().getTile().setOccupant(
                                    GameController
                                    .getCivilization().getSiegeUnit());
                    } else {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setHeaderText("Can't afford there!");
                        alert.setTitle("Error!");
                        alert.showAndWait();
                    }
                    break;
                case "Settlers":
                    newUnit = GameController
                        .getCivilization().getSettlerUnit("settler");
                    if (newUnit.isAffordable()) {
                        newUnit.applyInitialCosts();
                        GameController
                            .getLastClicked().getTile().setOccupant(
                                    GameController
                                    .getCivilization().
                                    getSettlerUnit("settler"));
                    } else {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setHeaderText("Can't afford there!");
                        alert.setTitle("Error!");
                        alert.showAndWait();
                    }
                    break;
                case "Farmers":
                    newUnit = GameController
                        .getCivilization().getFarmerUnit();
                    if (newUnit.isAffordable()) {
                        newUnit.applyInitialCosts();
                        GameController
                            .getLastClicked().getTile().setOccupant(
                                    GameController
                                    .getCivilization().getFarmerUnit());
                    } else {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setHeaderText("Can't afford there!");
                        alert.setTitle("Error!");
                        alert.showAndWait();
                    }
                    break;
                case "Coal Miners":
                    newUnit = GameController
                        .getCivilization().getCoalMinerUnit();
                    if (newUnit.isAffordable()) {
                        newUnit.applyInitialCosts();
                        GameController
                            .getLastClicked().getTile().setOccupant(
                                    GameController
                                    .getCivilization().getCoalMinerUnit());
                    } else {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setHeaderText("Can't afford there!");
                        alert.setTitle("Error!");
                        alert.showAndWait();
                    }
                    break;
                case "Anglers":
                    newUnit = GameController
                        .getCivilization().getAnglerUnit();
                    if (newUnit.isAffordable()) {
                        newUnit.applyInitialCosts();
                        GameController
                            .getLastClicked().getTile().setOccupant(
                                    GameController
                                    .getCivilization().getAnglerUnit());
                    } else {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setHeaderText("Can't afford there!");
                        alert.setTitle("Error!");
                        alert.showAndWait();
                    }
                    break;
                case "Master Builders":
                    newUnit = GameController
                        .getCivilization().getMasterBuilderUnit();
                    if (newUnit.isAffordable()) {
                        newUnit.applyInitialCosts();
                        GameController
                            .getLastClicked().getTile().setOccupant(
                                    GameController
                                    .getCivilization().getMasterBuilderUnit());
                    } else {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setHeaderText("Can't afford there!");
                        alert.setTitle("Error!");
                        alert.showAndWait();
                    }
                    break;
                default:
                    break;
                }
                GameController.updateResourcesBar();
            });
    }
}
