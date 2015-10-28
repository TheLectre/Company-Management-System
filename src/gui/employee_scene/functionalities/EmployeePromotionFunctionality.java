package gui.employee_scene.functionalities;

import business_logic.Experience;
import business_logic.Promotion;
import core.ResourcesManager;
import gui.employee_scene.BaseFunctionality;
import gui.employee_scene.EmployeeSceneRoot;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class EmployeePromotionFunctionality extends BaseFunctionality {

    //================================================================================
    // Fields
    //================================================================================
    
    private VBox mainPane;
    
    private CheckBox updateSalary;
    private CheckBox updatePosition;
    private TextField freshSalary;
    private ComboBox<String> freshPosition;
    private TextArea message;
    private Label lettersLeft;
    private Button submit;

    //================================================================================
    // Constructors
    //================================================================================
    public EmployeePromotionFunctionality(EmployeeSceneRoot root, ResourcesManager rManager) {
        super(root, rManager);
    }

    //================================================================================
    // Methods
    //================================================================================
    @Override
    public String name() {
        return "Promotion";
    }

    @Override
    public Pane loadContent() {
        GridPane gPane = new GridPane();

        gPane.setHgap(20);
        gPane.setVgap(20);
        
        gPane.setAlignment(Pos.CENTER);

        initializeCheckBoxes();
        initializeToFill();
        initializeSubmitButton();

        gPane.add(updateSalary, 0, 0);
        gPane.add(updatePosition, 0, 1);
        gPane.add(freshSalary, 1, 0);
        gPane.add(freshPosition, 1, 1);

        mainPane = new VBox();

        mainPane.setSpacing(20);
        
        mainPane.setAlignment(Pos.CENTER);

        mainPane.getChildren().add(gPane);
        mainPane.getChildren().add(message);
        mainPane.getChildren().add(lettersLeft);
        mainPane.getChildren().add(submit);

        if(!isRequestAvailable()) {
            disableAll();
        }
        
        return mainPane;
    }

    private void initializeSubmitButton() {
        submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                onPromotionRequestAttempt();
            }
        });
    }

    private void initializeCheckBoxes() {
        updateSalary = new CheckBox("New salary:");
        updateSalary.setSelected(true);
        updateSalary.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                freshSalary.setDisable(!updateSalary.selectedProperty().get());
            }
        });

        updatePosition = new CheckBox("New position:");

        if (root.getEmployee().getExperience() == Experience.MANAGER) {
            updatePosition.setDisable(true);
        }

        updatePosition.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                freshPosition.setDisable(!updatePosition.selectedProperty().get());
            }
        });

    }

    private void initializeToFill() {
        freshSalary = new TextField();
        freshSalary.setPromptText("Numbers only");
        freshSalary.setText("" + (root.getEmployee().getSalary() + 500));

        freshPosition = new ComboBox();
        freshPosition.setDisable(true);

        if (root.getEmployee().getExperience() == Experience.JUNIOR) {
            freshPosition.getItems().add(Experience.REGULAR.toString());
            freshPosition.getItems().add(Experience.SENIOR.toString());
            freshPosition.getItems().add(Experience.MANAGER.toString());
            freshPosition.setValue(freshPosition.getItems().get(0));
        } else if (root.getEmployee().getExperience() == Experience.REGULAR) {
            freshPosition.getItems().add(Experience.SENIOR.toString());
            freshPosition.getItems().add(Experience.MANAGER.toString());
            freshPosition.setValue(freshPosition.getItems().get(0));
        } else if (root.getEmployee().getExperience() == Experience.SENIOR) {
            freshPosition.getItems().add(Experience.MANAGER.toString());
            freshPosition.setValue(freshPosition.getItems().get(0));
        }

        lettersLeft = new Label("250 characters left.");

        message = new TextArea();
        message.setWrapText(true);
        message.setMaxHeight(100);
        message.setMaxWidth(200);

        EventHandler<KeyEvent> eventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                lettersLeft.setText("" + (250 - message.getText().length()) + " characters left.");
                while (message.getText().length() >= 250) {
                    message.setText(message.getText().substring(0, 249));
                }
            }
        };

        message.setOnKeyReleased(eventHandler);
        message.setOnKeyTyped(eventHandler);
    }

    private void onPromotionRequestAttempt() {
        int salaryAmount;
        try {
            salaryAmount = Integer.parseInt(freshSalary.getText());
        } catch (Exception e) {
            printResultStage("Incorrect salary", "");
            return;
        }
        if (salaryAmount <= root.getEmployee().getSalary()) {
            printResultStage("You cannot lessen your salary", "");
            return;
        }
        if (message.getLength() < 15) {
            printResultStage("Your message is too short", "");
            return;
        }

        if (freshSalary.isDisabled() && freshPosition.isDisabled()) {
            printResultStage("Ask for some kind of promotion", "");
            return;
        } else if (freshSalary.isDisabled()) {
            rManager.addNewPromotion(new Promotion(root.getEmployee().getID(), freshPosition.getValue(), root.getEmployee().getSalary(), message.getText()));
        } else if (freshPosition.isDisabled()) {
            rManager.addNewPromotion(new Promotion(root.getEmployee().getID(), salaryAmount, root.getEmployee().getExperience(), message.getText()));
        }
        else {
            rManager.addNewPromotion(new Promotion(root.getEmployee().getID(), freshPosition.getValue(), salaryAmount, message.getText()));
        }

        printResultStage("Your promotion request", "has been sent to Administrator");
        disableAll();
    }

    private void disableAll() {
        for(Node x : mainPane.getChildren()) {
            x.setDisable(true);
        }
        Label label = new Label("You cannot have more than one\npromotion request at the time.");
        label.setTextFill(Color.RED);
        mainPane.getChildren().add(label);
    }
    
    private boolean isRequestAvailable() {
        List<Promotion> promotions = rManager.getAllPromotions();
        for(Promotion x : promotions) {
            if(x.getEmployeeID() == root.getEmployee().getID()) {
                return false;
            }
        }
        return true;
    }
    
        
    private void printResultStage(String information, String secondInformation) {
        Stage resultStage = new Stage();
        resultStage.setTitle("Information");

        Button okButton = new Button("OK");
        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                resultStage.close();
            }
        });

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(0, 10, 0, 10));
        vBox.getChildren().add(new Label(information));
        vBox.getChildren().add(new Label(secondInformation));
        vBox.getChildren().add(okButton);

        resultStage.setScene(new Scene(vBox, 280, 150));
        resultStage.show();
    }
    
    //================================================================================
    // Accessors
    //================================================================================
}
