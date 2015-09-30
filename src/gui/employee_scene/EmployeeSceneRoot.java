package gui.employee_scene;

import business_logic.Employee;
import core.ResourcesManager;
import gui.employee_scene.functionalities.AdminPromotionFunctionality;
import gui.employee_scene.functionalities.ChangePasswordFunctionality;
import gui.employee_scene.functionalities.EmployeePromotionFunctionality;
import gui.employee_scene.functionalities.MessageFunctionality;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class EmployeeSceneRoot extends BorderPane {
    //================================================================================
    // Fields
    //================================================================================
    
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
        ToolBar tb = new ToolBar();
        
        for(BaseFunctionality bf : functionalities) {
            tb.getItems().add(bf.button);
        }
        
        this.setTop(tb);
    }
    
    private void initiateFunctionalities() {
        functionalities = new ArrayList<>();
        functionalities.add(new ChangePasswordFunctionality(this, rManager));
        functionalities.add(new EmployeePromotionFunctionality(this, rManager));
        functionalities.add(new AdminPromotionFunctionality(this, rManager));
        functionalities.add(new MessageFunctionality(this, rManager));
        functionalities.add(new TeamViewFunctionality(this, rManager));
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
