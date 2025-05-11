package sdev200fp.ui;

import sdev200fp.MainApp;
import sdev200fp.model.FamilyMember;
import sdev200fp.util.DBManager;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.Modality;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.List;

public class FamilyPage {
    private MainApp mainApp;
    private BorderPane rootPane;

    public FamilyPage(MainApp mainApp) {
        this.mainApp = mainApp;
        initialize();
    }

    private void initialize() {
        rootPane = new BorderPane();

        //use shared nav bar
        NavBar navBar = new NavBar(mainApp);
        rootPane.setTop(navBar.getNavBar());

        Label label = new Label("Family Page");
        Button addFamilyMember = new Button("Add Family Member");
        FlowPane memberList = new FlowPane();
        memberList.setHgap(20);
        memberList.setVgap(20);
        memberList.setAlignment(Pos.CENTER);

        List<FamilyMember> members = DBManager.getAllFamilyMembers();
        for (FamilyMember member : members) {
            Label nameLabel = new Label(member.getFirstName() + " " + member.getLastName());
            Label dobLabel = new Label("DOB: " + member.getDateOfBirth());
            ImageView imageView = new ImageView();

            if (member.getPhotoString() != null && !member.getPhotoString().isEmpty()) {
                byte[] imageBytes = java.util.Base64.getDecoder().decode(member.getPhotoString());
                javafx.scene.image.Image image = new Image(new java.io.ByteArrayInputStream(imageBytes));
                imageView.setImage(image);
                imageView.setFitWidth(80);
                imageView.setFitHeight(80);
                imageView.setPreserveRatio(true);
            }

            VBox infoBox = new VBox(5, nameLabel, dobLabel);
            VBox entry = new VBox(15, imageView, infoBox);
            memberList.getChildren().add(entry);
        }

        addFamilyMember.setOnAction(e -> {
            FamilyMemberForm form = new FamilyMemberForm();
            Stage owner = (Stage) rootPane.getScene().getWindow();
            form.showAndWait(owner);
            mainApp.showFamilyPage();
        });

        VBox centerBox = new VBox(20,label, memberList, addFamilyMember);
        centerBox.setAlignment(Pos.CENTER);

        rootPane.setCenter(centerBox);
    }

    public BorderPane getView() {
        return rootPane;
    }
}


//next steps, create a family member object that shows 

//connect to database to generate UI objects of each family member in the database