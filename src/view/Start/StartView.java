package view.Start;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * Thibault Mathys
 * 25/07/2022
 */

public class StartView extends GridPane {
    private Button startSpel;
    private ImageView addit;
    private TextField naamSpelerTwee;
    private TextField naamSpelerEen;
    private Label naamEersteSpeler;
    private Label naamTweedeSpeler;

    public StartView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.startSpel = new Button("Start Addit");
        this.startSpel.setFont(new Font(20));
        this.addit = new ImageView("addit.jpg");
        this.naamSpelerEen = new TextField();
        this.naamSpelerTwee = new TextField();
        this.naamEersteSpeler = new Label("Naam speler 1:");
        this.naamEersteSpeler.setFont(new Font(15));
        this.naamTweedeSpeler = new Label("Naam speler 2:");
        this.naamTweedeSpeler.setFont(new Font(15));
    }

    private void layoutNodes() {
        this.add(addit, 0, 0, 2, 1);
        this.add(naamEersteSpeler, 0, 1);
        this.add(naamTweedeSpeler, 0, 2);
        this.add(naamSpelerEen, 1, 1);
        this.add(naamSpelerTwee, 1, 2);
        this.add(startSpel, 0, 3, 2, 1);

        this.setAlignment(Pos.CENTER);
        this.setVgap(10);
        this.setHgap(10);
        GridPane.setHalignment(startSpel, HPos.CENTER);
    }

    Button getStartSpel() {
        return startSpel;
    }

    public String getNaamSpelerEen() {
        return naamSpelerEen.getText();
    }

    public String getNaamSpelerTwee() {
        return naamSpelerTwee.getText();
    }
}