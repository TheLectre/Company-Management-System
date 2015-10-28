package gui.employee_scene.functionalities;

import business_logic.Employee;
import core.ResourcesManager;
import gui.employee_scene.BaseFunctionality;
import gui.employee_scene.EmployeeSceneRoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChangePasswordFunctionality extends BaseFunctionality {

    //================================================================================
    // Fields
    //================================================================================
    private Label[] labels;
    private PasswordField[] passwordFields;
    private Button submitButton;
    private Label warningLabel;

    private boolean[] valid;

    //================================================================================
    // Constructors
    //================================================================================
    public ChangePasswordFunctionality(EmployeeSceneRoot root, ResourcesManager rManager) {
        super(root, rManager);
    }

    //================================================================================
    // Methods
    //================================================================================
        @Override
    public String name() {
        return "Change password";
    }

    @Override
    public Pane loadContent() {

        initializeComponents();

        GridPane pane = new GridPane();
        
        pane.setHgap(40);
        pane.setVgap(40);
        
        pane.setAlignment(Pos.CENTER);

        pane.add(labels[0], 0, 0);
        pane.add(labels[1], 0, 1);
        pane.add(labels[2], 0, 2);

        pane.add(passwordFields[0], 1, 0);
        pane.add(passwordFields[1], 1, 1);
        pane.add(passwordFields[2], 1, 2);

        pane.add(submitButton, 1, 3);
        pane.add(warningLabel, 1, 4);

        return pane;
    }
    
    private void initializeComponents() {
        labels = new Label[3];
        passwordFields = new PasswordField[3];

        labels[0] = new Label("Current password");
        labels[1] = new Label("New password");
        labels[2] = new Label("Confirm");

        passwordFields[0] = new PasswordField();
        passwordFields[1] = new PasswordField();
        passwordFields[2] = new PasswordField();

        passwordFields[1].setPromptText("5-15 characters");
        passwordFields[2].setPromptText("5-15 characters");

        submitButton = new Button("Submit");
        submitButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (isFormCorrect()) {
                    handlePasswordChange();
                }
            }
        });

        warningLabel = new Label();
        warningLabel.setVisible(false);

        valid = new boolean[5];
    }

    private boolean isFormCorrect() {
        valid[0] = passwordFields[0].getText().equals(root.getEmployee().getPassword());
        valid[1] = passwordFields[1].getText().length() >= 5;
        valid[2] = passwordFields[1].getText().length() <= 15;
        valid[3] = passwordFields[2].getText().equals(passwordFields[1].getText());
        valid[4] = !passwordFields[0].getText().equals(passwordFields[1].getText());

        for (int i = 0; i < valid.length; i++) {
            if (!valid[i]) {
                printWarning(i);
                return false;
            }
        }
        return true;
    }

    private void printWarning(int i) {
        warningLabel.setVisible(true);
        switch (i) {
            case 0:
                warningLabel.setText("Wrong password");
                break;
            case 1:
                warningLabel.setText("New password is too short");
                break;
            case 2:
                warningLabel.setText("New password is too long");
                break;
            case 3:
                warningLabel.setText("Passwords have to match");
                break;
            case 4:
                warningLabel.setText("This ain't a password change, troll.");
                break;
        }
    }

    private void handlePasswordChange() {
        Employee empl = root.getEmployee();
        empl.setPassword(passwordFields[1].getText());
        rManager.updateEmployee(empl);

        Stage successfulPaswordChangeStage = new Stage();
        successfulPaswordChangeStage.setTitle("Success");

        Button okButton = new Button("OK");
        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                successfulPaswordChangeStage.close();
                passwordFields[0].setText("");
                passwordFields[1].setText("");
                passwordFields[2].setText("");
            }
        });

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(0, 10, 0, 10));
        vBox.getChildren().add(new Label("Your password has been changed."));
        vBox.getChildren().add(okButton);

        successfulPaswordChangeStage.setScene(new Scene(vBox, 220, 120));
        successfulPaswordChangeStage.show();
    }



    //================================================================================
    // Accessors
    //================================================================================
}
