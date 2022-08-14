package view.Over;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Addit;

/**
 * Thibault Mathys
 * 25/07/2022
 */
public class OverPresenter {
    private Addit model;
    private OverView overView;

    public OverPresenter(Addit model, OverView spelregelsView) {
        this.model = model;
        this.overView = spelregelsView;
        AddEventHandlers();
    }

    private void AddEventHandlers() {
        overView.getButtonOk().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                overView.getScene().getWindow().hide();
            }
        });
    }
}

