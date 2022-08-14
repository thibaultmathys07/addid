package view.Spelregels;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * Thibault Mathys
 * 25/07/2022
 */
public class SpelregelsView extends VBox {
    private Button buttonOk;
    private ImageView imageView = new ImageView();

    public SpelregelsView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        buttonOk = new Button("Sluit");
        Image image = new Image("Spelregels.jpg");
        imageView.setImage(image);
    }

    private void layoutNodes() {
        setPadding(new Insets(10));
        setSpacing(20);
        getChildren().addAll(imageView, buttonOk);
        buttonOk.setMaxWidth(75);
        setAlignment(Pos.CENTER);
    }

    Button getButtonOk() {
        return buttonOk;
    }
}
