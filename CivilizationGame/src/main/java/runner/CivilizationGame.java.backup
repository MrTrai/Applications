package runner;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import controller.GameController;
import model.Bandit;
import model.Egypt;
import model.QinDynasty;
import model.RomanEmpire;
import view.CivEnum;
import view.GameScreen;
import view.GridFX;
import view.StartScreen;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */

    private Stage stage;

    public void start(Stage primaryStage) {
        stage = primaryStage;

        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Civilization Game");
        primaryStage.setScene(startGame());
        primaryStage.show();
    }
    /**
     * This is the main method that launches the javafx application
     */
    public static void main(String[] args) {
        Application.launch();
    }
    /**
     * This method is responsible for setting the scene to the corresponding
     * layout.
     * and returning the scene.
     * @return Scene
     */

    public Scene startGame() {
        //Scene
        StartScreen startScreen = new StartScreen();

        startScreen.getStartButton().setOnAction(e -> {
                TextInputDialog dialog = new TextInputDialog();
                dialog.hide();
                dialog.setHeaderText("You built your Settlement!");
                Optional<String> res = dialog.showAndWait();


                if (res.isPresent()) {
                    res.ifPresent(a -> {
                            CivEnum selected = startScreen.
                                getCivList().
                                getSelectionModel().getSelectedItem();
                            switch (selected) {
                            case QIN_DYNASTY:
                                dialog.setContentText(
                                        "Enter your first Qin town");
                                GameController.
                                    setCivilization(new QinDynasty());
                                GridFX.getInstance().getMap()
                                    .putSettlement(dialog
                                            .getEditor().getText(),
                                        GameController.
                                        getCivilization(), 5, 5);
                                break;
                            case ANCIENT_EGYPT:
                                dialog.setContentText(
                                        "Enter your first Egypt town");
                                GameController.
                                    setCivilization(new Egypt());
                                GridFX.getInstance().getMap()
                                    .putSettlement(dialog
                                            .getEditor().getText(),
                                        GameController.
                                        getCivilization(), 5, 5);
                                break;
                            case ROMAN_EMPIRE:
                                dialog.setContentText(
                                        "Enter your first Rome town");
                                GameController.
                                    setCivilization(new RomanEmpire());
                                GridFX.getInstance().getMap()
                                    .putSettlement(dialog
                                            .getEditor().getText(),
                                        GameController.
                                        getCivilization(), 5, 5);
                                break;
                            default:
                                break;
                            }

                            //set bandit
                            GridFX.getInstance().
                                getMap().addEnemies(new Bandit(), 4);
                            GameScreen gameScreen = new GameScreen();

                            Scene gameScene = new Scene(gameScreen);
                            gameScene.getStylesheets().addAll(this.getClass().
                                    getResource("style.css").toExternalForm());
                            stage.setScene(gameScene);
                            gameScreen.update();
                        });
                } else {
                    return;
                }
            });


        return new Scene(startScreen, 1000, 1000);
    }
}
