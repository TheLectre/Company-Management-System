package gui.connect_scene.body;

import business_logic.Employee;
import core.ResourcesManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class LogInGroup extends Group {

    //================================================================================
    // Fields
    //================================================================================
    private final ResourcesManager rManager;

    private GridPane gridPane;
    private Label[] labels;
    private TextField loginField;
    private PasswordField passwordField;
    private Button submitButton;

    //================================================================================
    // Constructors
    //================================================================================
    public LogInGroup(ResourcesManager rManager) {
        this.rManager = rManager;

        initializeLabels();
        initializeFields();
        initializeSubmitButton();
        initializeGridPane();
    }

    //================================================================================
    // Methods
    //================================================================================
    private void initializeGridPane() {
        gridPane = new GridPane();
        gridPane.setHgap(30);
        gridPane.setVgap(40);
        gridPane.setPadding(new Insets(0, 10, 0, 10));
        this.getChildren().add(gridPane);

        gridPane.add(labels[0], 0, 0);
        gridPane.add(labels[1], 0, 1);
        gridPane.add(loginField, 1, 0);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(submitButton, 1, 2);
    }

    private void initializeLabels() {
        labels = new Label[2];
        labels[0] = new Label("Login");
        labels[1] = new Label("Password");
    }

    private void initializeFields() {
        loginField = new TextField();
        loginField.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER) {
                    proceedSubmitEvent();
                }
            }
            
        });
        
        passwordField = new PasswordField();
        passwordField.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER) {
                    proceedSubmitEvent();
                }
            }
            
        });
    }

    private void initializeSubmitButton() {
        submitButton = new Button("Submit");

        submitButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                proceedSubmitEvent();
            }
        });
        
        submitButton.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER) {
                    proceedSubmitEvent();
                }
            }
            
        });
    }

    private void proceedSubmitEvent() {
        if (loginField.getText().length() < 5 || loginField.getText().length() > 15 || passwordField.getText().length() < 5 || passwordField.getText().length() > 15) {
            createFailLogInAttemptStage("Enter valid login and password", "Try again!");
        } else {
            proceedLogIn(loginField.getText(), passwordField.getText());
        }
    }

    private void proceedLogIn(String login, String password) {
        Employee empl = rManager.getEmployeeByLogin(login);
        if (empl == null) {
            createFailLogInAttemptStage("There is no employee with such login.", "You may have been fired or rejected.");
        } else {
            if (password.equals(empl.getPassword())) {
                //successful log in
                onSuccessfulLogIn(empl);
            } else {
                createFailLogInAttemptStage("Incorrect password for user " + login, "Try again!");
            }
        }
    }

    private void createFailLogInAttemptStage(String info, String secondInfo) {
        Stage stage = new Stage();
        stage.setTitle("Fail attempt");
        Button button = new Button("Okay");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });
        button.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                stage.close();
            }
            
        });

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(0, 10, 0, 10));
        vBox.getChildren().add(new Label(info));
        vBox.getChildren().add(new Label(secondInfo));
        vBox.getChildren().add(button);

        stage.setScene(new Scene(vBox, 220, 120));
        stage.show();
    }

    public abstract void onSuccessfulLogIn(Employee employee);

    //================================================================================
    // Accessors
    //================================================================================
}
