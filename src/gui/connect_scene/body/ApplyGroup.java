package gui.connect_scene.body;

import business_logic.Employee;
import business_logic.Experience;
import business_logic.Technology;
import core.ResourcesManager;
import java.util.Arrays;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public abstract class ApplyGroup extends Group {
    //================================================================================
    // Fields
    //================================================================================
    private final ResourcesManager rManager;
    
    private GridPane gridPane;
    private Label[] labels;
    private TextField[] textFields;
    private PasswordField[] passwordFields;
    private ComboBox<String>[] comboBoxes;
    private Label warningLabel;
    private Button submitButton;
    
    private boolean valid[];
    
    //================================================================================
    // Constructors
    //================================================================================

    public ApplyGroup(ResourcesManager rManager) {
        this.rManager = rManager;
        initiateLabels();
        initiateTextFields();
        initiatePasswordFields();
        initiateComboBoxes();
        initiateSubmitButton();
        initiateGridPane();
    }

    //================================================================================
    // Methods
    //================================================================================

    public abstract void onSuccessfulApply();
    
    private void initiateGridPane() {
        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(0, 10, 0, 10));
        this.getChildren().add(gridPane);
        
        for(int i=0;i<labels.length;i++) {
            gridPane.add(labels[i], 0, i);
        }
        
        gridPane.add(textFields[0], 1, 0);
        gridPane.add(textFields[1], 1, 1);
        gridPane.add(textFields[2], 1, 2);
        gridPane.add(passwordFields[0], 1, 3);
        gridPane.add(passwordFields[1], 1, 4);
        gridPane.add(comboBoxes[0], 1, 5);
        gridPane.add(comboBoxes[1], 1, 6);
        gridPane.add(textFields[3], 1, 7);
        gridPane.add(submitButton, 1, 8);
        gridPane.add(warningLabel, 1, 9);  
    }
    
    private void initiateLabels() {
        labels = new Label[8];
        String[] names = {"First Name", "Last Name", "Login", "Password", "Password Again", "Programming Language", "Experience", "Prefered Salary"};
           
        for(int i=0; i<labels.length; i++) {
            labels[i] = new Label(names[i]);
        }
        
        warningLabel = new Label();
        warningLabel.setVisible(false);
    }
    
    private void initiateTextFields() {
        textFields = new TextField[4];
        
        for(int i=0;i<textFields.length;i++) {
            textFields[i] = new TextField();
        }
        
        textFields[0].setPromptText("2-15 letters");
        textFields[1].setPromptText("2-15 letters");
        textFields[2].setPromptText("5-15 letters or numbers");
        textFields[3].setPromptText("up to 5 digit amount in €");
        
        textFields[0].setOnKeyReleased(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                valid[0] = isNameValid(textFields[0].getText());
            }
        });
        
        textFields[1].setOnKeyReleased(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                valid[1] = isNameValid(textFields[1].getText());
            }
        });
        
        textFields[2].setOnKeyReleased(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                valid[2] = rManager.getEmployeeByLogin(textFields[2].getText()) == null;
                
                valid[3] = isLoginValid(textFields[2].getText());
            }
        });
        
        textFields[3].setOnKeyReleased(new EventHandler<KeyEvent>() {
            
            @Override
            public void handle(KeyEvent event) {
                valid[8] = isSalaryValid(textFields[3].getText());
            }
        });
    }    
    
    private void initiatePasswordFields() {
        passwordFields = new PasswordField[2];
        
        for(int i=0;i<passwordFields.length;i++) {
            passwordFields[i] = new PasswordField();
        }
        
        passwordFields[0].setPromptText("5-15 signs");
        passwordFields[1].setPromptText("5-15 signs");
        
        passwordFields[0].setOnKeyReleased(new EventHandler<KeyEvent>() {
            
            @Override
            public void handle(KeyEvent event) {
                valid[4] = passwordFields[0].getText().length() >= 5 || passwordFields[0].getText().length() <= 15;
            }
        });
        
        passwordFields[1].setOnKeyReleased(new EventHandler<KeyEvent>() {
            
            @Override
            public void handle(KeyEvent event) {
                valid[5] = passwordFields[0].getText().equals(passwordFields[1].getText());
            }
        });
    }
    
    private void initiateComboBoxes() {
        comboBoxes = new ComboBox[2];
        for(int i=0;i<comboBoxes.length;i++) {
            comboBoxes[i] = new ComboBox();
        } 
        
        //Technology combo box filling
        List<Technology> technologies = rManager.getAllTechnologies();
        for (Technology technology : technologies) {
            comboBoxes[0].getItems().add(technology.getName());
        }
        
        //Experience combo box filling
        comboBoxes[1].getItems().add(Experience.JUNIOR.toString());
        comboBoxes[1].getItems().add(Experience.REGULAR.toString());
        comboBoxes[1].getItems().add(Experience.SENIOR.toString());
        comboBoxes[1].getItems().add(Experience.MANAGER.toString());
       
        comboBoxes[0].setPromptText("Your technology");
        comboBoxes[1].setPromptText("Your experience");
        
        comboBoxes[0].setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                valid[6] = true;
            }
            
        });
        
        comboBoxes[1].setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                valid[7] = true;
            }
            
        });
    }

    private void initiateSubmitButton() {
        submitButton = new Button("Submit");
        
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(handleMistakes()) {
                    rManager.addNewEmployee(new Employee
                                       (textFields[0].getText(), textFields[1].getText(), comboBoxes[1].getValue(),
                                        Integer.parseInt(textFields[3].getText()), new Technology(rManager.getTechnologyID(comboBoxes[0].getValue()),
                                        comboBoxes[0].getValue()), null, textFields[2].getText(), passwordFields[0].getText(), false));
                    
                    Stage AppliedStage = new Stage();
                    AppliedStage.setTitle("Applied");
                    Button button = new Button("Log In!");
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            AppliedStage.close();
                            onSuccessfulApply();
                        }
                    });
                    
                    VBox vBox = new VBox();
                    vBox.setAlignment(Pos.CENTER);
                    vBox.setSpacing(20);
                    vBox.setPadding(new Insets(0, 10, 0, 10));
                    vBox.getChildren().add(new Label("Your offer is sent to administrator."));
                    vBox.getChildren().add(new Label("Come back soon!"));
                    vBox.getChildren().add(button);
                    

                    AppliedStage.setScene(new Scene(vBox, 220, 120));
                    AppliedStage.show();
                    
                }
            }
        });
        
        valid = new boolean[9];
        Arrays.fill(valid, false);
        valid[2] = true; // login already exists error prompt
    }
    
    private boolean isNameValid(String text) {
        char[] charText = text.toCharArray();
        
        if(text.length() < 2 || text.length() > 15) {
            return false;
        }
        
        for (char c : charText) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isLoginValid(String text) {
        char[] charText = text.toCharArray();
        
        if(text.length() < 5 || text.length() > 15) {
            return false;
        }
        
        for (char c : charText) {
            if(!(Character.isLetter(c) || Character.isDigit(c))) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isSalaryValid(String text) {
        char[] charText = text.toCharArray();
        
        if(text.length() > 5) {
            return false;
        }
        
        for (char c : charText) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }
        
        return true;
    }  
    
    private int isFormCorrect() {
        for(int i=0;i<valid.length;i++) {
            if(!valid[i]) {
                return i;
            }
        }
        return -1;
    }
    
    private boolean handleMistakes() {
        int result = isFormCorrect();
        
        if(result == -1) {
            return true;
        }
        
        warningLabel.setVisible(true);
        
        switch(isFormCorrect()) {
            case 0: warningLabel.setText("Invalid first name"); return false;
            case 1: warningLabel.setText("Invalid last name"); return false;
            case 2: warningLabel.setText("Login already exists"); return false;
            case 3: warningLabel.setText("Invalid login"); return false;
            case 4: warningLabel.setText("Invalid password"); return false;
            case 5: warningLabel.setText("Passwords have to match"); return false;
            case 6: warningLabel.setText("Technology not chosen"); return false;
            case 7: warningLabel.setText("Experience not chosen"); return false;
            case 8: warningLabel.setText("Invalid salary"); return false;
        }
        return false;
    }
    
    //================================================================================
    // Accessors
    //================================================================================
}
