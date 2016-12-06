package view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import controller.GameController;

/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {

    private static ResourcesMenu resMenu = new ResourcesMenu();
    private static GridFX map = GridFX.getInstance();
    private static StatusMenu abstractMenu = new StatusMenu();
    private static MilitaryMenu military = new MilitaryMenu();
    private static WorkerMenu worker = new WorkerMenu();
    private static RecruitMenu recruit = new RecruitMenu();
    private static StatusMenu status = new StatusMenu();
    private static BuildingMenu building = new BuildingMenu();
    private static VBox menuContainer = new VBox();
    private static StackPane topPane = new StackPane();

    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {
        topPane.getChildren().add(resMenu.getRootNode());
        topPane.setStyle("-fx-background-color: white;");
        setTop(topPane);
        setCenter(map);
        menuContainer.getChildren().add(abstractMenu.getRootNode());
        setLeft(menuContainer);
        this.setId("pane");
    }

    /**
     * This method should update the gridfx and the resouce bar
     */
    public void update() {
        map.update();
        resMenu.update();
    }
    /**
     * this method should return the resource menu
     * @return reosuce menu
     */
    public static ResourcesMenu getResources() {
        return resMenu;
    }


    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    public static void switchMenu(GameController.GameState state) {
        //NEUTRAL, MILITARY, WORKER, BUILDING, RECRUITING;
        switch (state) {
        case NEUTRAL:
            menuContainer.getChildren().clear();
            menuContainer.getChildren().add(abstractMenu.getRootNode());
            break;
        case MILITARY:
            menuContainer.getChildren().clear();
            menuContainer.getChildren().add(military.getRootNode());
            break;
        case WORKER:
            menuContainer.getChildren().clear();
            menuContainer.getChildren().add(worker.getRootNode());
            break;
        case BUILDING:
            menuContainer.getChildren().clear();
            menuContainer.getChildren().add(building.getRootNode());
            break;
        case RECRUITING:
            menuContainer.getChildren().clear();
            menuContainer.getChildren().add(recruit.getRootNode());
            break;
        default:
            break;
        }
    }
}
