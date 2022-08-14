import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Addit;
import view.Start.StartPresenter;
import view.Start.StartView;

/**
 * Thibault Mathys
 * 25/07/2022
 */

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Addit model = new Addit();
        StartView view = new StartView();
        StartPresenter startPresenter = new StartPresenter(model, view);
        Scene scene = new Scene(view);

        primaryStage.setScene(scene);
        startPresenter.addWindowEventHandlers();
        primaryStage.setTitle("Addit");
        primaryStage.setWidth(700);
        primaryStage.setHeight(600);
        primaryStage.show();
    }
}