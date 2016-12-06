package view;


import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import controller.GameController;
import model.TerrainTile;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class TerrainTileFX extends StackPane {
    private Rectangle overlay;
    private ImageView background;
    private TerrainTile tile;
    private ImageView icon = new ImageView("File:./bologna");
    /**
     * Constructor for TerrainTileFX.
     * Creates a Rectangle for the highlighting and overlay
     * Creates ImageViews for the background terrain and icon
     * Transitions states when a tile is clicked
     * @param tile
     */
    public TerrainTileFX(TerrainTile tile) {
        this.tile = tile;
        overlay = new Rectangle(70, 70, Color.rgb(0, 0, 0, 0.0));
        overlay.setStroke(Color.BLACK);
        this.background = new ImageView(tile.getImage());
        this.getChildren().addAll(background, overlay);
        updateTileView();
        this.setOnMousePressed(event -> {
                GameController.setLastClicked(this);
            });
    }
    /**
     * gets the TerrainTile of this TerrainTileFX
     * @return TerrainTile
     */
    public TerrainTile getTile() {
        return tile;
    }

    public void updateTileView() {
        if (this == GameController.getLastClicked()) {
            overlay.setFill(Color.BLACK);
            overlay.setOpacity(0.5);
        } else {
            overlay.setFill(Color.TRANSPARENT);
        }

        if (this.getChildren().contains(icon)) {
            this.getChildren().remove(icon);
        }

        if (!tile.isEmpty()) {
            this.icon = new ImageView(tile.getOccupant().getImage());
            overlay.setFill(tile.getOccupant().getColor());
        } else {
            this.icon = new ImageView("File:./noicon");
        }

        this.getChildren().add(icon);
    }
}
