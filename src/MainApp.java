//import required javafx classes
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import page classes
import javafx.scene.layout.BorderPane;

public class MainApp extends Application {
    //stage reference for scene switching
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        //set primary stage
        this.primaryStage = primaryStage;

        //show home page initially
        showHomePage();
        
        //set stage title
        primaryStage.setTitle("Family Tracker");
        //show stage
        primaryStage.show();
    }

    //method to show home page
    public void showHomePage() {
        HomePage homePage = new HomePage(this);
        Scene scene = new Scene(homePage.getView(), 800, 600);
        primaryStage.setScene(scene);
    }

    //method to show family page
    public void showFamilyPage() {
        FamilyPage familyPage = new FamilyPage(this);
        Scene scene = new Scene(familyPage.getView(), 800, 600);
        primaryStage.setScene(scene);
    }

    //method to show tasks page
    public void showTasksPage() {
        TasksPage tasksPage = new TasksPage(this);
        Scene scene = new Scene(tasksPage.getView(), 800, 600);
        primaryStage.setScene(scene);
    }

    //method to show calendar page
    public void showCalendarPage() {
        CalendarPage calendarPage = new CalendarPage(this);
        Scene scene = new Scene(calendarPage.getView(), 800, 600);
        primaryStage.setScene(scene);
    }

    //main method to launch application
    public static void main(String[] args) {
        launch(args);
    }
}
