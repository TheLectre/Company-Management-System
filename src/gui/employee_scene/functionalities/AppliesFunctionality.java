package gui.employee_scene.functionalities;

import business_logic.Employee;
import core.ResourcesManager;
import gui.employee_scene.BaseFunctionality;
import gui.employee_scene.EmployeeSceneRoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class AppliesFunctionality extends BaseFunctionality {

    //================================================================================
    // Fields
    //================================================================================
    
    //UI
    private VBox mainPane;
    private Node contentNode;

    //================================================================================
    // Constructors
    //================================================================================
    public AppliesFunctionality(EmployeeSceneRoot root, ResourcesManager rManager) {
        super(root, rManager);
    }


    //================================================================================
    // Methods
    //================================================================================
    @Override
    public String name() {
        return "Job Applies";
    }

    @Override
    public Pane loadContent() {
        mainPane = createMainPane();

        populateScreen();

       return mainPane;
    }
    
    private VBox createMainPane() {
        VBox pane = new VBox();
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(20);
        return pane;
    }
    
    private Label createNoAppliesLabel() {
        Label label = new Label("There are no applies at the moment.");
        label.setFont(Font.font(null, FontWeight.BOLD, 16));
        return label;
    }

    private VBox createApplyManagementPane(Employee employee) {
        VBox applyManagementPane = new VBox();
        applyManagementPane.setAlignment(Pos.CENTER);
        applyManagementPane.setSpacing(20);
        
        applyManagementPane.getChildren().add(createAppliesLeftLabel());
        applyManagementPane.getChildren().add(createApplyView(employee));
        applyManagementPane.getChildren().add(createApplyButtons(employee));
        
        return applyManagementPane;
    }
    
    private HBox createApplyView(Employee employee) {
        HBox majorBox = new HBox();
        majorBox.setAlignment(Pos.CENTER);
        majorBox.setSpacing(20);
        
        VBox minorRowNamesPane = new VBox();
        minorRowNamesPane.setAlignment(Pos.CENTER);
        minorRowNamesPane.setSpacing(20);
        for(Label p : createRowNames()) {
            minorRowNamesPane.getChildren().add(p);
        }
        
        VBox minorEmployeeInfoPane = new VBox();
        minorEmployeeInfoPane.setAlignment(Pos.CENTER);
        minorEmployeeInfoPane.setSpacing(20);
        for(Label p : createEmployeeInfoLabels(employee)) {
            minorEmployeeInfoPane.getChildren().add(p);
        }
        
        majorBox.getChildren().addAll(minorRowNamesPane, minorEmployeeInfoPane);
        
        return majorBox;
    }
   
    private HBox createApplyButtons(Employee employee) {
        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);
        
        Button acceptButton = new Button("Accept");
        acceptButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                rManager.acceptJobApply(employee.getID());
                populateScreen();
            }
        });
        
        Button rejectButton = new Button("Reject");
        rejectButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                rManager.removeEmployee(employee.getID());
                populateScreen();
            }
        });
        
        buttons.getChildren().addAll(acceptButton, rejectButton);
        
        return buttons;
    }
    
    private Label createAppliesLeftLabel() {
        Label label = new Label("Job applies left: " + rManager.getNumberOfApplies());
        label.setFont(Font.font(null, FontPosture.ITALIC, 14));
        return label;
    }
    
    private Label[] createRowNames() {
        Label[] labels = new Label[5];
        
        labels[0] = new Label("First name:");
        labels[1] = new Label("Last Name:");
        labels[2] = new Label("Technology:");
        labels[3] = new Label("Experience");
        labels[4] = new Label("Preferred salary");
        
        for(int i=0;i<labels.length;i++) {
            labels[i].setFont(Font.font(null, FontWeight.BOLD, 14));
        }
        
        return labels;
    }

    private Label[] createEmployeeInfoLabels(Employee empl) {
        
        //UI
        Label[] labels = new Label[5];
        
        labels[0] = new Label(empl.getFirstName());
        labels[1] = new Label(empl.getLastName());
        labels[2] = new Label(empl.getTechnology().getName());
        labels[3] = new Label(empl.getExperience().toString());
        labels[4] = new Label("" + empl.getSalary() + "€");
        
        for(int i=0;i<labels.length;i++) {
            labels[i].setFont(Font.font(null, FontWeight.NORMAL, 14));
        }
        
        return labels;
    }

    private void populateScreen() {
        Employee applyingEmployee = rManager.getNotAcceptedEmployee();
        
        contentNode = applyingEmployee != null ? createApplyManagementPane(applyingEmployee) : createNoAppliesLabel();
        
        mainPane.getChildren().clear();
        
        mainPane.getChildren().add(contentNode);
    }
}
