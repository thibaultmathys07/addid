package view.Start;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;
import model.Addit;
import view.Game.GamePresenter;
import view.Game.GameView;

/**
 * Thibault Mathys
 * 25/07/2022
 */
public class StartPresenter {
    private Addit model;
    private StartView view;

    public StartPresenter(Addit model, StartView view) {
        this.view = view;
        this.model = model;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getStartSpel().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                // Ophalen namen spelers
                String spelerEen = view.getNaamSpelerEen();
                String spelerTwee = view.getNaamSpelerTwee();

                // Nieuwe game view en presenter aanmaken
                GameView gameView = new GameView();
                GamePresenter gamePresenter = new GamePresenter(model, gameView);

                // Instellen speler namen
                gameView.SetSpelerEenNaam(spelerEen);
                gameView.SetSpelerTweeNaam(spelerTwee);

                // Tonen spel
                view.getScene().setRoot(gameView);
            }
        });
    }

    public void addWindowEventHandlers() {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Hierdoor stopt het spel!");
                alert.setContentText("Ben je zeker?");
                alert.setTitle("Opgelet!");
                alert.getButtonTypes().clear();
                ButtonType neen = new ButtonType("Neen");
                ButtonType ja = new ButtonType("Ja");
                alert.getButtonTypes().addAll(neen, ja);
                alert.showAndWait();
                if (alert.getResult() == null || alert.getResult().equals(neen)) {
                    event.consume();
                }
            }
        });
    }
}