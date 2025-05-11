package sdev200fp.ui;

import sdev200fp.MainApp;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class CalendarPage {
    private MainApp mainApp;
    private BorderPane rootPane;

    public CalendarPage(MainApp mainApp) {
        this.mainApp = mainApp;
        initialize();
    }

    private void initialize() {
        rootPane = new BorderPane();

        NavBar navBar = new NavBar(mainApp);
        rootPane.setTop(navBar.getNavBar());

        Label label = new Label("Calendar (Select a date)");

        DatePicker calendar = new DatePicker();
        calendar.setValue(LocalDate.now());

        VBox centerBox = new VBox(20, label, calendar);
        centerBox.setAlignment(Pos.TOP_CENTER);
        centerBox.setPadding(new Insets(20));

        rootPane.setCenter(centerBox);

        // Show the calendar popup immediately
        calendar.show();
    }

    public BorderPane getView() {
        return rootPane;
    }
}
