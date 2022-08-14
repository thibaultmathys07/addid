package view.Game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.Addit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Thibault Mathys
 * 25/07/2022
 */

public class GameView extends GridPane {
    private MenuItem menuOpslaanGame;
    private MenuItem menuScorebord;
    private MenuItem menuSpelregels;
    private MenuItem menuOver;
    private MenuBar menuBar;

    private Button gooiDobbelstenen;
    private Button plus;
    private Button min;
    private Button maal;
    private Button delen;

    Addit addit = new Addit();
    private Label getaldobbel1;
    private Label getaldobbel2;

    private Label naamSpelerEen;
    private Label naamSpelerTwee;

    private List<Button> getalspeler1 = new ArrayList<>();
    private List<Button> getalspeler2 = new ArrayList<>();

    Button steentje;

    public GameView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        menuSpelregels = new MenuItem("Spelregels");
        menuOver = new MenuItem("Over");
        menuScorebord = new MenuItem("Scorebord");
        menuOpslaanGame = new MenuItem("Opslaan");

        getaldobbel1 = new Label();
        getaldobbel2 = new Label();

        naamSpelerEen = new Label();
        naamSpelerTwee = new Label();

        gooiDobbelstenen = new Button("Gooi dobbelstenen");
        plus = new Button("+");
        min = new Button("-");
        maal = new Button("x");
        delen = new Button(":");

        steentje = new Button(addit.stennenKrijgen1());
        steentje = new Button(addit.stennenKrijgen2());

        for (int i = 0; i < 5; i++)
        {
            Button button = new Button(addit.getp1().get(i).toString());
            getalspeler1.add(button);
        }

        for (int i = 0; i < 5; i++) {
            Button button = new Button(addit.getp2().get(i).toString());
            getalspeler2.add(button);
        }
    }

    private void layoutNodes() {
        Menu menuGame = new Menu("Opslaan", null, menuOpslaanGame);
        Menu menuHoofdOpslaan = new Menu("Score", null, menuScorebord);
        Menu menuHelp = new Menu("Help", null, menuSpelregels, menuOver);
        menuBar = new MenuBar(menuGame, menuHoofdOpslaan, menuHelp);

        this.add(naamSpelerEen, 3, 0,8,1);
        this.add(plus, 13, 2);
        this.add(getaldobbel1, 0, 4);
        this.add(getalspeler1.get(0), 4, 1);
        this.add(getalspeler1.get(1), 5, 1);
        this.add(getalspeler1.get(2), 6, 1);
        this.add(getalspeler1.get(3), 7, 1);
        this.add(getalspeler1.get(4), 8, 1);
        this.add(min, 13, 3);
        this.add(getaldobbel2, 1, 4);
        this.add(getalspeler2.get(0), 4, 6);
        this.add(getalspeler2.get(1), 5, 6);
        this.add(getalspeler2.get(2), 6, 6);
        this.add(getalspeler2.get(3), 7, 6);
        this.add(getalspeler2.get(4), 8, 6);
        this.add(maal, 13, 4);
        this.add(gooiDobbelstenen, 0,3, 2,1);
        this.add(naamSpelerTwee, 3, 7,8,1);
        this.add(delen, 13, 5);

        this.setAlignment(Pos.CENTER);
        this.setVgap(10);
        this.setHgap(10);

        //GridPane.setValignment(menuBar, VPos.TOP);
        //GridPane.setHalignment(menuBar, HPos.RIGHT);
    }

    public void SetSpelerEenNaam(String naam){
        this.naamSpelerEen.setText(naam);
    }

    public void SetSpelerTweeNaam(String naam){
        this.naamSpelerTwee.setText(naam);
    }

    public void SetDobbelsteenEen(int ogen){
        this.getaldobbel1.setText(String.valueOf(ogen));
    }

    public void SetDobbelsteenTwee(int ogen){
        this.getaldobbel2.setText(String.valueOf(ogen));
    }

    public void SetClickStenenSpeler1(Consumer<Integer> steenKlik){
        EventHandler handler = CreateEventHandlerSpeler(steenKlik);
        for (Button button : getalspeler1) {
            button.setOnAction(handler);
        }
    }

    public void SetClickStenenSpeler2(Consumer<Integer> steenKlik){
        EventHandler handler = CreateEventHandlerSpeler(steenKlik);
        for (Button button : getalspeler2) {
            button.setOnAction(handler);
        }
    }

    private EventHandler CreateEventHandlerSpeler(Consumer<Integer> steenKlik)
    {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button source = (Button) event.getSource();
                steenKlik.accept(Integer.valueOf(source.getText()));
            }
        };
    }

    MenuItem getMenuSpelregels() {
        return menuSpelregels;
    }

    MenuItem getMenuScorebord() {
        return menuScorebord;
    }

    MenuItem getMenuOpslaanGame() {
        return menuOpslaanGame;
    }

    MenuItem getMenuOver() {
        return menuOver;
    }

    Button getGooiDobbelstenen() {
        return gooiDobbelstenen;
    }

    public Button getPlus() {
        return plus;
    }

    public Button getMin() {
        return min;
    }

    public Button getMaal() {
        return maal;
    }

    public Button getDelen() {
        return delen;
    }
}