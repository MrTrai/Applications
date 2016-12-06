package view;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import controller.GameController;

public class ResourcesMenu {

    //Delete this?
    private HBox resourceBar = new HBox(30);
    // return resourceBar;

    private double stratLvl = GameController.
        getCivilization().
        getStrategy().
        getStrategyLevel();
    private double resource = GameController.
        getCivilization().
        getResources();
    private double settlement = GameController.
        getCivilization().
        getNumSettlements();
    private double money = GameController.
        getCivilization().
        getTreasury().
        getCoins();
    private double food = GameController.
        getCivilization().
        getFood();
    private double happiness = GameController.
        getCivilization().
        getHappiness();

    private Label stratLabel = new Label("Strat level: " + stratLvl);
    private Label resLabel = new Label("Resources: " + resource);
    private Label settleLabel = new Label("Settlements: " + settlement);
    private Label moneyLabel = new Label("Money: " + money);
    private Label foodLabel = new Label("Food: " + food);
    private Label happinessLabel = new Label("Happiness: " + happiness);

    public ResourcesMenu() {
        resourceBar.getChildren().add(stratLabel);
        resourceBar.getChildren().add(resLabel);
        resourceBar.getChildren().add(settleLabel);
        resourceBar.getChildren().add(moneyLabel);
        resourceBar.getChildren().add(foodLabel);
        resourceBar.getChildren().add(happinessLabel);
    }
    /**
     * should update all the resouce values to the current
     * state of your resource values
     */
    public void update() {
        stratLvl = GameController.
            getCivilization().
            getStrategy().
            getStrategyLevel();
        resource = GameController.
            getCivilization().
            getResources();
        settlement = GameController.
            getCivilization().
            getNumSettlements();
        money = GameController.
            getCivilization().
            getTreasury().
            getCoins();
        food = GameController.
            getCivilization().
            getFood();
        happiness = GameController.
            getCivilization().
            getHappiness();

        stratLabel.setText("Strat level: " + stratLvl);
        resLabel.setText("Resources: " + resource);
        settleLabel.setText("Settlements: " + settlement);
        moneyLabel.setText("Money: " + money);
        foodLabel.setText("Food: " + food);
        happinessLabel.setText("Happiness: " + happiness);


        resourceBar.getChildren().clear();

        resourceBar.getChildren().add(stratLabel);
        resourceBar.getChildren().add(resLabel);
        resourceBar.getChildren().add(settleLabel);
        resourceBar.getChildren().add(moneyLabel);
        resourceBar.getChildren().add(foodLabel);
        resourceBar.getChildren().add(happinessLabel);
    }
    /**
     * updates the resource bar and returns the resource bar
     * @return a hbox representation of the resource bar
     */
    public HBox getRootNode() {
        return resourceBar;
    }
}
