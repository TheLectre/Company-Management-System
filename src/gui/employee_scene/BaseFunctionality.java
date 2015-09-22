package gui.employee_scene;

import core.ResourcesManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;


public abstract class BaseFunctionality {
  
    //================================================================================
    // Fields
    //================================================================================
    
    protected EmployeeSceneRoot root;
    protected ResourcesManager rManager;
    
    protected ToggleButton button;
    protected Pane content;

    //================================================================================
    // Constructors
    //================================================================================

    public BaseFunctionality(EmployeeSceneRoot root, ResourcesManager rManager) {
        this.root = root;
        this.rManager = rManager;
        
        initializeButton();
    }

    //================================================================================
    // Methods
    //================================================================================
    
    private void initializeButton() {
        button = new ToggleButton(name());
        
        button.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                for(BaseFunctionality p : root.getFunctionalities()) {
                    p.button.setSelected(false);
                }
                button.setSelected(true);
                content = loadContent();
                root.setBody(content);
            }
        });
    }
    
    public abstract String name();
    
    public abstract Pane loadContent();
    
    //================================================================================
    // Accessors
    //================================================================================ 
}
