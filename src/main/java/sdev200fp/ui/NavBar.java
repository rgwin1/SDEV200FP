package sdev200fp.ui;

import sdev200fp.MainApp;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
public class NavBar {
    private MainApp mainApp; 
   
    //constructor that takes MainApp? or should it take each page as well?
    
    public NavBar(MainApp mainApp){
        this.mainApp = mainApp;
    
    }
   
    public HBox getNavBar() {
        HBox navBar = new HBox(10);
        navBar.setAlignment(Pos.CENTER);

        Button homeButton = new Button("Home");
        Button familyButton = new Button("Family");
        Button tasksButton = new Button("Tasks");
        Button calendarButton = new Button("Calendar");

        homeButton.setOnAction(e -> {
            mainApp.showHomePage();
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

        navBar.getChildren().addAll(homeButton, familyButton, tasksButton, calendarButton);
        return navBar;
    }

 
}