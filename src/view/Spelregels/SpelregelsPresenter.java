package view.Spelregels;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Addit;

/**
 * Thibault Mathys
 * 25/07/2022
 */
public class SpelregelsPresenter {
    private Addit model;
    private SpelregelsView spelregelsView;

    public SpelregelsPresenter(Addit model, SpelregelsView spelregelsView) {
        this.model = model;
        this.spelregelsView = spelregelsView;
        AddEventHandlers();
    }

    private void AddEventHandlers() {
        spelregelsView.getButtonOk().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                spelregelsView.getScene().getWindow().hide();
            }
        });
    }
}
