package view;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import controller.GameController;
import model.Convertable;
import model.TerrainTile;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class WorkerMenu extends AbstractMenu {
    /**
    * There should be a convert and move button
    * as well as the functions associated with those
    * buttons
    */
    private Button moveBtn = new Button("Move");
    private Button convertBtn = new Button("Convert");

    public WorkerMenu() {
        addMenuItem(moveBtn);
        addMenuItem(convertBtn);

        moveBtn.setOnAction(e -> {
                TerrainTile tile = GameController.getLastClicked().getTile();
                GameController.moving();
                GameController.updateResourcesBar();
            });

        convertBtn.setOnAction(e -> {
                TerrainTile tile = GameController.getLastClicked().getTile();
                if (((Convertable) (tile.getOccupant()))
                        .canConvert(tile.getType())) {
                    tile.setOccupant(((Convertable) (tile.getOccupant()))
                            .convert());

                    GameController.getLastClicked().updateTileView();
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText("Can't convert there!");
                    alert.setTitle("Error!");
                    alert.showAndWait();
                }
                GameController.updateResourcesBar();
            });
    }
}
