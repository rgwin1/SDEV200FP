//import required javafx classes
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

//class representing the home page
public class HomePage {
    //reference to main app
    private MainApp mainApp;
    //root pane for home page
    private BorderPane rootPane;

    //constructor
    public HomePage(MainApp mainApp) {
        this.mainApp = mainApp;
        //initialize home page
        initialize();
    }

    //initialize home page layout
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
            //do nothing if already on home
        });

        familyButton.setOnAction(e -> {
            mainApp.showFamilyPage();
        });

        tasksButton.setOnAction(e -> {
            mainApp.showTasksPage();
        });

        calendarButton.setOnAction(e -> {
            mainApp.showCalendarPage();
        });

        //add buttons to nav bar
        navBar.getChildren().addAll(homeButton, familyButton, tasksButton, calendarButton);

        //create welcome label
        Label welcomeLabel = new Label("Welcome");

        //center welcome label
        VBox centerBox = new VBox(20, welcomeLabel);
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
