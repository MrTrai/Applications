package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import model.Civilization;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 * This class represents the Start Screen for the Civ applicatios. This is the
 * layout that should be displayed upon running the Civ application.
 *
 * This class should have and display
 * 1. a background
 * 2. a list of Civilizations
 * 3. a Start button
 */
public class StartScreen extends StackPane {
    private Civilization civ;
    private Button startBtn = new Button("Start");
    private ObservableList items = FXCollections.
        observableArrayList(CivEnum.QIN_DYNASTY,
                CivEnum.ANCIENT_EGYPT, CivEnum.ROMAN_EMPIRE);
    private ListView<CivEnum> myList = new ListView<>(items);

    public StartScreen() {
        Image background = new Image(
                "file:./src/main/java/view/civ_background.png");
        getChildren().add(new ImageView(background));

        myList.setPrefWidth(200);
        myList.setPrefHeight((items.size() * 24) + 2);

        VBox container = new VBox(20);
        myList.setMaxWidth(200);
        container.setPrefWidth(200);

        container.getChildren().add(myList);
        container.getChildren().add(startBtn);
        container.setAlignment(Pos.CENTER);

        getChildren().add(container);
    }
    /**
     * gets the start button
     * @return the start button
     */
    public Button getStartButton() {
        return startBtn;
    }

    public ListView<CivEnum> getCivList() {
        return myList;
    }
    /**
     * shoud set the civilization taken in by the method to the civilization
     * selected for this screen
     */
    // public void setCivilization(Civilization c) {
    //     //Not understandin?
    //     GameController.setCivilization(c);
    // }

}
