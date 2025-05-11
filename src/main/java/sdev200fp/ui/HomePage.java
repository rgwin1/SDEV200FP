package sdev200fp.ui;

import sdev200fp.MainApp;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class HomePage {
    private MainApp mainApp;
    private BorderPane rootPane;

    public HomePage(MainApp mainApp) {
        this.mainApp = mainApp;
        initialize();
    }

    private void initialize() {
        rootPane = new BorderPane();

        //reuse shared nav bar
        NavBar navBar = new NavBar(mainApp);
        rootPane.setTop(navBar.getNavBar());

        Label welcomeLabel = new Label("Welcome");

        VBox centerBox = new VBox(20, welcomeLabel);
        centerBox.setAlignment(Pos.CENTER);

        rootPane.setCenter(centerBox);
    }

    public BorderPane getView() {
        return rootPane;
    }
}
