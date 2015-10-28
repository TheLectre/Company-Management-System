package gui.employee_scene.functionalities;

import business_logic.Employee;
import business_logic.Promotion;
import core.ResourcesManager;
import gui.employee_scene.BaseFunctionality;
import gui.employee_scene.EmployeeSceneRoot;
import java.util.Iterator;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class AdminPromotionFunctionality extends BaseFunctionality {

    //================================================================================
    // Fields
    //================================================================================
    private List<Promotion> promotions;
    private Iterator<Promotion> promotionsIterator;
    private Promotion currentPromotion;
    private Employee currentEmployee;

    private VBox mainPane;

    private Label requestsLeft;
    private Label employeeName;
    private Label employeeNamesticker;
    private GridPane requestView;
    private Label messageSticker;
    private TextArea messageArea;
    private HBox decisionButtons;

    //================================================================================
    // Constructors
    //================================================================================
    public AdminPromotionFunctionality(EmployeeSceneRoot root, ResourcesManager rManager) {
        super(root, rManager);
    }

    //================================================================================
    // Methods
    //================================================================================
    @Override
    public String name() {
        return "Promotions";
    }

    @Override
    public Pane loadContent() {
        mainPane = new VBox();
        mainPane.setAlignment(Pos.CENTER);
        
        mainPane.setSpacing(10);

        promotions = rManager.getAllPromotions();
        promotionsIterator = promotions.iterator();

        //content
        if (nextRequest()) {
            initializeRequestView();
            showNewRequest();
            initializeRequestsLeftLabel();
            initializeEmployeeNameLabel();
            initializeEmployeeNameSticker();
            initializeMessageSticker();
            initializeMessageArea();
            initializeDecisionButtons();

            //assigning content
            mainPane.getChildren().add(requestsLeft);
            mainPane.getChildren().add(employeeName);
            mainPane.getChildren().add(employeeNamesticker);
            mainPane.getChildren().add(requestView);
            mainPane.getChildren().add(messageSticker);
            mainPane.getChildren().add(messageArea);
            mainPane.getChildren().add(decisionButtons);
        } else {
            onNoRequests();
        }

        return mainPane;
    }

    private void refreshAll() {
        refreshRequestsLeftNumber();

        employeeName.setText(currentEmployee.getFirstName() + " " + currentEmployee.getLastName());
        messageArea.setText(currentPromotion.getMessage());
        showNewRequest();
    }

    private void onNoRequests() {
        mainPane.getChildren().clear();

        Label info = new Label("There are no requests at the moment.");
        info.setFont(Font.font(null, FontWeight.BOLD, 16));

        mainPane.getChildren().add(info);
    }

    private void requestAccepted() {
        promotionsIterator.remove();
        
        currentEmployee.setSalary(currentPromotion.getNewSalary());
        currentEmployee.setExperience(currentPromotion.getNewExperience());

        rManager.removePromotion(currentPromotion.getID());
        rManager.updateEmployee(currentEmployee);
    }
    
    private void requestRefused() {
        promotionsIterator.remove();
        
        rManager.removePromotion(currentPromotion.getID());
    }
    
    private void refreshRequestsLeftNumber() {
        int numberOfRequests = promotions.size();
        if (numberOfRequests == 0) {
            requestsLeft.setText("There are no promotion requests at the time");
        } else if (numberOfRequests == 1) {
            requestsLeft.setText("There is one promotion request left");
        } else {
            requestsLeft.setText("There are " + numberOfRequests + " promotion requests left");
        }
    }

    private boolean nextRequest() {
        if (promotionsIterator.hasNext()) {
            currentPromotion = promotionsIterator.next();
            currentEmployee = rManager.getEmployeeByID(currentPromotion.getEmployeeID());
            return true;
        }
        return false;
    }

    private void showNewRequest() {
        requestView.getChildren().clear();

        //standard structure
        Label[] columnNames = new Label[3];
        columnNames[0] = new Label("Type");
        columnNames[1] = new Label("Current");
        columnNames[2] = new Label("New");
        Label[] types = new Label[2];
        types[0] = new Label("Salary");
        types[1] = new Label("Position");
        Label salaryArrow = new Label("->");
        Label positionArrow = new Label("->");

        //specific promotion informations
        Label currentSalary = new Label("" + currentEmployee.getSalary());
        currentSalary.setFont(Font.font(null, FontWeight.BOLD, 14));
        Label freshSalary = new Label("" + currentPromotion.getNewSalary());
        freshSalary.setFont(Font.font(null, FontWeight.BOLD, 14));
        Label currentPosition = new Label(currentEmployee.getExperience().toString());
        currentPosition.setFont(Font.font(null, FontWeight.BOLD, 14));
        Label freshPosition;
        

        if (currentPromotion.getNewExperience() == null) {
            //position is not updated
            freshPosition = new Label(currentPosition.getText());
        } else {
            //position is updated
            freshPosition = new Label(currentPromotion.getNewExperience().toString());
        }
        
        freshPosition.setFont(Font.font(null, FontWeight.BOLD, 14));

        //adding components to pane
        requestView.add(columnNames[0], 0, 2);
        requestView.add(columnNames[1], 1, 2);
        requestView.add(columnNames[2], 3, 2);
        requestView.add(types[0], 0, 3);
        requestView.add(types[1], 0, 4);

        requestView.add(currentSalary, 1, 3);
        requestView.add(salaryArrow, 2, 3);
        requestView.add(freshSalary, 3, 3);

        requestView.add(currentPosition, 1, 4);
        requestView.add(positionArrow, 2, 4);
        requestView.add(freshPosition, 3, 4);

    }

    private void initializeRequestView() {
        requestView = new GridPane();
        requestView.setVgap(10);
        requestView.setHgap(10);
        requestView.setAlignment(Pos.CENTER);
    }

    private void initializeDecisionButtons() {
        decisionButtons = new HBox();
        decisionButtons.setSpacing(30);
        decisionButtons.setAlignment(Pos.CENTER);

        Button acceptButton = createAcceptRequestButton();
        Button refuseButton = createRefuseRequestButton();

        decisionButtons.getChildren().add(acceptButton);
        decisionButtons.getChildren().add(refuseButton);
    }

    private void initializeEmployeeNameLabel() {
        employeeName = new Label(currentEmployee.getFirstName() + " " + currentEmployee.getLastName());
        employeeName.setFont(Font.font(null, FontWeight.BOLD, 18));
    }

    private void initializeEmployeeNameSticker() {
        employeeNamesticker = new Label("asks for advancement");
        employeeNamesticker.setFont(Font.font(null, FontPosture.ITALIC, 14));
    }
    
    private void initializeMessageSticker() {
        messageSticker = new Label("included message");
        messageSticker.setFont(Font.font(null, FontPosture.ITALIC, 14));
    }

    private void initializeRequestsLeftLabel() {
        requestsLeft = new Label();
        requestsLeft.setFont(Font.font(null, FontPosture.ITALIC, 14));
        refreshRequestsLeftNumber();
    }

    private void initializeMessageArea() {
        messageArea = new TextArea();
        messageArea.setWrapText(true);
        messageArea.setEditable(false);
        messageArea.setMaxHeight(100);
        messageArea.setMaxWidth(200);
        messageArea.setText(currentPromotion.getMessage());
    }
    
    private Button createAcceptRequestButton() {
        Button acceptButton = new Button("Accept");

        acceptButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                requestAccepted();
                if (nextRequest()) {
                    refreshAll();
                } else {
                    onNoRequests();
                }
            }
        });

        return acceptButton;
    }

    private Button createRefuseRequestButton() {
        Button refuseButton = new Button("Refuse");
        refuseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                requestRefused();
                if (nextRequest()) {
                    refreshAll();
                } else {
                    onNoRequests();
                }
            }
        });
        return refuseButton;
    }

}
