package sdev200fp.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Window;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicReference;
import sdev200fp.model.FamilyMember;
import sdev200fp.util.ValidationUtils;
import sdev200fp.util.DBManager;

public class FamilyMemberForm {

    public void showAndWait(Stage owner) {
        Stage formStage = new Stage();
        formStage.initModality(Modality.WINDOW_MODAL);
        formStage.initOwner(owner);
        formStage.setTitle("Add Family Member");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20));
        grid.setAlignment(Pos.CENTER);
        
        //add pic
        Button selectPhoto = new Button("Select Photo");
        
        
        Image defaultImage = new Image(getClass().getResource("/images/avatar.png").toExternalForm());
        ImageView photoImageView = new ImageView(defaultImage);
        photoImageView.setFitWidth(250);
        photoImageView.setFitHeight(250);
        photoImageView.setPreserveRatio(true);
        
        //first Name
        Label firstNameLabel = new Label("First Name*:");
        TextField firstNameField = new TextField();

        //last Name
        Label lastNameLabel = new Label("Last Name*:");
        TextField lastNameField = new TextField();
        
        //middle name
        Label middleNameLabel = new Label("Middle Name:");
        TextField middleNameField = new TextField();

        //dob
        Label dobLabel = new Label("Date of Birth*:");
        DatePicker dobPicker = new DatePicker();

        //email
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        //medical Info
        Label medicalLabel = new Label("Medical Info:");
        TextArea medicalArea = new TextArea();

        //notes
        Label notesLabel = new Label("Notes:");
        TextArea notesArea = new TextArea();

        //submit button
        Button submitButton = new Button("Submit");

        //layout setup
        grid.add(firstNameLabel, 0, 0);
        grid.add(firstNameField, 1, 0);
        grid.add(lastNameLabel, 0, 1);
        grid.add(lastNameField, 1, 1);
        grid.add(middleNameLabel,0, 2);
        grid.add(middleNameField,1, 2);
        grid.add(dobLabel, 0, 3);
        grid.add(dobPicker, 1, 3);
        grid.add(emailLabel, 0, 4);
        grid.add(emailField, 1, 4);
        grid.add(medicalLabel, 0, 5);
        grid.add(medicalArea, 1, 5);
        grid.add(notesLabel, 0, 6);
        grid.add(notesArea, 1, 6);
        grid.add(submitButton, 1, 7);
        
        AtomicReference<String> base64image = new AtomicReference<>(null);
        
        selectPhoto.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Photo");

            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
            );

            File selectedFile = fileChooser.showOpenDialog(formStage); //pass parent stage here?
            try {
                byte[] imageBytes = Files.readAllBytes(selectedFile.toPath());
                String encodedString = Base64.getEncoder().encodeToString(imageBytes);
                base64image.set(encodedString);
            } catch (IOException ioe){
                ioe.printStackTrace();
            }
         

            if (selectedFile != null){
                String path = selectedFile.getAbsolutePath();
                Image userImage = new Image(selectedFile.toURI().toString());
                photoImageView.setImage(userImage);
                }
            }
        );

        submitButton.setOnAction(e -> {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String middleName = middleNameField.getText();  
            LocalDate dateOfBirth = dobPicker.getValue();
            String email = emailField.getText();
            String medicalInfo = medicalArea.getText();
            String notes = notesArea.getText();
            
            if (!ValidationUtils.isValidName(firstName)) {
                showError("Invalid first name.");
                return;
            }
            if (!ValidationUtils.isValidName(lastName)) {
                showError("Invalid last name.");
                return;
            }
            if (dobPicker.getValue() == null) {
                showError("Date of birth is required.");
                return;
            }
            if (!email.isBlank() && !ValidationUtils.isValidEmail(email)) {
                showError("Invalid email.");
                return;
            }

            //build FamilyMember object here if needed
            String photo = base64image.get();
            FamilyMember member = new FamilyMember(firstName, lastName, middleName, dateOfBirth, email, medicalInfo, notes, photo);
            
            try {
                DBManager.insertFamilyMember(member);
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
                
            formStage.close();
        });
        
        VBox vbox = new VBox(50);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(photoImageView,selectPhoto, grid);
        Scene scene = new Scene(vbox, 700, 800);
        formStage.setScene(scene);
        formStage.showAndWait();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Validation Error");
        alert.setContentText(message);
        alert.showAndWait();
    }
}

//submit information to database
