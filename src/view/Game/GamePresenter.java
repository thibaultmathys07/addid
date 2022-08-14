package view.Game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Addit;
import model.Rekenmachine;
import view.Over.OverPresenter;
import view.Over.OverView;
import view.Spelregels.SpelregelsPresenter;
import view.Spelregels.SpelregelsView;

/**
 * Thibault Mathys
 * 25/07/2022
 */

public class GamePresenter {
    private GameView view;
    private Addit model;
    private GameTimer gameTimer;
    private Rekenmachine rekenmachineSpeler1 = new Rekenmachine();
    private Rekenmachine rekenmachineSpeler2 = new Rekenmachine();

    public GamePresenter(Addit model, GameView view) {
        this.view = view;
        this.model = model;
        this.gameTimer = new GameTimer();
        addEventHandlers();
        //addMenuEventHandlers();

        // Klok instellen
        gameTimer.InstellenTimer((minuten, seconden) -> {
            //System.out.println(minuten + " : " + seconden);
        });
        gameTimer.Start();

        if (model.spelGedaan) {
            gameTimer.Stop();
        }
    }

    private void addEventHandlers() {
        view.getMenuSpelregels().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SpelregelsView spelregelsView = new SpelregelsView();
                SpelregelsPresenter aboutPresenter = new SpelregelsPresenter(model, spelregelsView);
                Stage spelregelsStage = new Stage();
                spelregelsStage.initOwner(view.getScene().getWindow());
                spelregelsStage.initModality(Modality.APPLICATION_MODAL);
                spelregelsStage.setTitle("Spelregels");
                spelregelsStage.setScene(new Scene(spelregelsView));
                spelregelsStage.setX(view.getScene().getWindow().getX() + 100);
                spelregelsStage.setY(view.getScene().getWindow().getY() + 100);
                spelregelsStage.showAndWait();
            }
        });

        view.getMenuOver().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                OverView overView = new OverView();
                OverPresenter overPresenter = new OverPresenter(model, overView);
                Stage overStage = new Stage();
                overStage.initOwner(view.getScene().getWindow());
                overStage.initModality(Modality.APPLICATION_MODAL);
                overStage.setTitle("Spelregels");
                overStage.setScene(new Scene(overView));
                overStage.setX(view.getScene().getWindow().getX() + 100);
                overStage.setY(view.getScene().getWindow().getY() + 100);
                overStage.showAndWait();
            }
        });

        //ButtonEvents
        view.getGooiDobbelstenen().setOnAction(actionEvent -> {
            int nieuwgetalofzo1 = this.model.Dobbelsteenos1();
            int nieuwgetalofzo2 = this.model.Dobbelsteenos2();
            int aantalgegooid = this.model.getAantalDobbelsteenGegooid();

            this.view.SetDobbelsteenEen(nieuwgetalofzo1);
            this.view.SetDobbelsteenTwee(nieuwgetalofzo2);

            System.out.println();
            System.out.println(aantalgegooid);
            System.out.println("getal dobel 1: " + nieuwgetalofzo1);
            System.out.println("getal dobel 2: " + nieuwgetalofzo2);
        });

        view.getPlus().setOnAction(actionEvent -> {
            rekenmachineSpeler1.plus();
            System.out.println(rekenmachineSpeler1.getResultaat());
            model.controleberkening();
        });

        view.getMin().setOnAction(actionEvent -> {
            rekenmachineSpeler1.min();
            System.out.println(rekenmachineSpeler1.getResultaat());
        });

        view.getMaal().setOnAction(actionEvent -> {
            rekenmachineSpeler1.maal();
            System.out.println(rekenmachineSpeler1.getResultaat());
        });

        view.getDelen().setOnAction(actionEvent -> {
            rekenmachineSpeler1.delen();
            System.out.println(rekenmachineSpeler1.getResultaat());

        });

        // Stenen speler 1
        view.SetClickStenenSpeler1(getal1 -> {
            rekenmachineSpeler1.getalToevoegen(getal1);
            System.out.println(getal1);
        });

        // Stenen speler 2
        view.SetClickStenenSpeler2(getal2 -> {
            rekenmachineSpeler1.getalToevoegen(getal2);
            System.out.println(getal2);
        });

//        view.getBtnClear().setOnAction(actionEvent -> {
//            model.clear();
//            updateView();
//        });
        }

//        /* Knop om naar het scorebord te gaan */
//        view.getMenuScorebord().setOnAction(actionEvent -> {
//            ScoreView scoreView = new ScoreView();
//            ScorePresenter scorePresenter = new ScorePresenter(model, scoreView);
//            Stage scoreStage = new Stage();
//            scoreStage.setTitle("Scorebord");
//            scoreStage.initOwner(view.getScene().getWindow());
//            scoreStage.initModality(Modality.APPLICATION_MODAL);
//            scoreStage.setScene(new Scene(scoreView));
//            scoreStage.setX(view.getScene().getWindow().getX() + 100);
//            scoreStage.setX(view.getScene().getWindow().getY() + 100);
//            scoreStage.showAndWait();
//        });

//        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
//            @Override
//            public void handle(WindowEvent event) {
//                Alert alert = new Alert(Alert.AlertType.WARNING);
//                alert.setHeaderText("Hierdoor stopt het spel!");
//                alert.setContentText("Ben je zeker?");
//                alert.setTitle("Opgelet!");
//                alert.getButtonTypes().clear();
//                ButtonType neen = new ButtonType("Neen");
//                ButtonType ja = new ButtonType("Ja");
//                alert.getButtonTypes().addAll(neen, ja);
//                alert.showAndWait();
//                if (alert.getResult() == null || alert.getResult().equals(neen)) {
//                    event.consume();
//                }
//            }
//        });

    private void updateView() {

//        model.getDobbelsteenEen();
//        model.getDobbelsteenTwee();

    }
}