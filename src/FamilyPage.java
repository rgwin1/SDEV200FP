//import required javafx classes
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

//class representing the family page
public class FamilyPage {
    //reference to main app
    private MainApp mainApp;
    //root pane for family page
    private BorderPane rootPane;

    //constructor
    public FamilyPage(MainApp mainApp) {
        this.mainApp = mainApp;
        //initialize family page
        initialize();
    }

    //initialize family page layout
    private void initialize() {
        //create border pane
        rootPane = new BorderPane();

        //create navigation bar
        HBox navBar = new HBox(10);
        navBar.setAlignment(Pos.CENTER);

        //create buttons
        Button homeButton = new Button("Home");
        Button familyButton = new Button("Family");
        Button tasksButton = new Button("Tasks");
        Button calendarButton = new Button("Calendar");

        //set button actions
        homeButton.setOnAction(e -> {
            mainApp.showHomePage();
        });

        familyButton.setOnAction(e -> {
            //do nothing if already on family page
        });

        tasksButton.setOnAction(e -> {
            mainApp.showTasksPage();
        });

        calendarButton.setOnAction(e -> {
            mainApp.showCalendarPage();
        });

        //add buttons to nav bar
        navBar.getChildren().addAll(homeButton, familyButton, tasksButton, calendarButton);

        //create label for placeholder
        Label label = new Label("Family Page");

        //center label
        VBox centerBox = new VBox(20, label);
        centerBox.setAlignment(Pos.CENTER);

        //set layout regions
        rootPane.setTop(navBar);
        rootPane.setCenter(centerBox);
    }

    //return the view
    public BorderPane getView() {
        return rootPane;
    }
}
