package view.Over;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Thibault Mathys
 * 28/07/2022
 */
public class OverView extends VBox {
    private Button buttonOk;
    private Label labelGemaaktDoor;

    public OverView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        buttonOk = new Button("Sluit");
        labelGemaaktDoor = new Label("Dit spel is gemaakt door Thibault Mathys");
    }

    private void layoutNodes() {
        setPadding(new Insets(10));
        setSpacing(20);
        getChildren().addAll(labelGemaaktDoor, buttonOk);
        buttonOk.setMaxWidth(75);
        setAlignment(Pos.CENTER);
    }

    Button getButtonOk() {
        return buttonOk;
    }
}
