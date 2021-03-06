package gui.employee_scene;

import business_logic.Employee;
import business_logic.Experience;
import core.ResourcesManager;
import gui.employee_scene.functionalities.AdminPromotionFunctionality;
import gui.employee_scene.functionalities.AppliesFunctionality;
import gui.employee_scene.functionalities.ChangePasswordFunctionality;
import gui.employee_scene.functionalities.EmployeePromotionFunctionality;
import gui.employee_scene.functionalities.MessageFunctionality;
import gui.employee_scene.functionalities.EmployeesFunctionality;
import gui.employee_scene.functionalities.StatisticsFunctionality;
import gui.employee_scene.functionalities.TechnologiesFunctioanlity;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class EmployeeSceneRoot extends BorderPane {
    //================================================================================
    // Fields
    //================================================================================
    
    private ToolBar headBar;
    private ResourcesManager rManager;
    private Employee employee;
    private ArrayList<BaseFunctionality> functionalities;
    
    //================================================================================
    // Constructors
    //================================================================================

    public EmployeeSceneRoot(ResourcesManager rManager, Employee employee) {
        this.rManager = rManager;
        this.employee = employee;
        
        initiateFunctionalities();
        initiateHead();
        initiateInfoPanel();
        initiateFooter();
    }

    //================================================================================
    // Methods
    //================================================================================
    
    private void initiateHead() {
        headBar = new ToolBar();
        headBar.setPadding(new Insets(10, 5, 10, 5));
        
        for(BaseFunctionality bf : functionalities) {
            headBar.getItems().add(bf.button);
        }
        
        this.setTop(headBar);
    }
    
    private void initiateFunctionalities() {
        functionalities = new ArrayList<>();
        // loading admin's menu
        if(employee.getExperience().equals(Experience.ADMINISTRATOR)) {
            functionalities.add(new EmployeesFunctionality(this, rManager));
            functionalities.add(new AppliesFunctionality(this, rManager));
            functionalities.add(new AdminPromotionFunctionality(this, rManager));
            functionalities.add(new MessageFunctionality(this, rManager));
            functionalities.add(new TechnologiesFunctioanlity(this, rManager));
            functionalities.add(new StatisticsFunctionality(this, rManager));
            functionalities.add(new ChangePasswordFunctionality(this, rManager));
        }
        else {
            
            functionalities.add(new EmployeesFunctionality(this, rManager));
            functionalities.add(new EmployeePromotionFunctionality(this, rManager));
            functionalities.add(new MessageFunctionality(this, rManager));
            functionalities.add(new ChangePasswordFunctionality(this, rManager));
        }
    }
    
    private void initiateInfoPanel() {
        InfoPanel infoPanel = new InfoPanel(employee);
        this.setRight(infoPanel);
        BorderPane.setAlignment(infoPanel, Pos.TOP_RIGHT);
        
    }
    
    private void initiateFooter() {
        this.setBottom(new Footer());
    }
    
    public void setBody(Pane content) {
        this.setCenter(content);
    }

    //================================================================================
    // Accessors
    //================================================================================

    public Employee getEmployee() {
        return employee;
    }

    public ArrayList<BaseFunctionality> getFunctionalities() {
        return functionalities;
    }
    
}
