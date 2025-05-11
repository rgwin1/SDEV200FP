package sdev200fp.ui;

import sdev200fp.MainApp;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class TasksPage {
    private MainApp mainApp;
    private BorderPane rootPane;

    public TasksPage(MainApp mainApp) {
        this.mainApp = mainApp;
        initialize();
    }

    private void initialize() {
        rootPane = new BorderPane();

        NavBar navBar = new NavBar(mainApp);
        rootPane.setTop(navBar.getNavBar());

        Label pageTitle = new Label("Tasks Page");

        TextField taskField = new TextField();
        taskField.setPromptText("Enter task description");

        DatePicker dueDatePicker = new DatePicker();

        Button addButton = new Button("Add Task");

        VBox taskList = new VBox(10);
        taskList.setPadding(new Insets(10));
        taskList.setAlignment(Pos.TOP_LEFT);

        addButton.setOnAction(e -> {
            String taskText = taskField.getText().trim();
            LocalDate dueDate = dueDatePicker.getValue();

            if (!taskText.isEmpty() && dueDate != null) {
                Label taskLabel = new Label("• " + taskText + " (Due: " + dueDate + ")");
                taskList.getChildren().add(taskLabel);
                taskField.clear();
                dueDatePicker.setValue(null);
            }
        });

        VBox centerBox = new VBox(15, pageTitle, taskField, dueDatePicker, addButton, taskList);
        centerBox.setAlignment(Pos.TOP_CENTER);
        centerBox.setPadding(new Insets(20));

        rootPane.setCenter(centerBox);
    }

    public BorderPane getView() {
        return rootPane;
    }
}
