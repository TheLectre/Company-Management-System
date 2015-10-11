package gui.employee_scene.functionalities;

import core.ResourcesManager;
import gui.employee_scene.BaseFunctionality;
import gui.employee_scene.EmployeeSceneRoot;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class TechnologiesFunctioanlity extends BaseFunctionality {

    //================================================================================
    // Fields
    //================================================================================

    private HBox mainPane;
    private TableView technologyTable;
    private VBox addTechnologyPane;
    private VBox removeTechnologyPane;
    
    //================================================================================
    // Constructors
    //================================================================================
    public TechnologiesFunctioanlity(EmployeeSceneRoot root, ResourcesManager rManager) {
        super(root, rManager);
    }

    //================================================================================
    // Methods
    //================================================================================
    @Override
    public String name() {
        return "Technologies";
    }

    @Override
    public Pane loadContent() {
        mainPane = createMainPane();
        
        technologyTable = createTechnologyTablePane();
        addTechnologyPane = createAddTechnologyPane();
        removeTechnologyPane = createRemoveTechnologyPane();
        
        mainPane.getChildren().addAll();
        
        
        return mainPane;
    }
    
    private TableView createTechnologyTablePane() {
        TableView pane = new TableView();
        
        return pane;
    }
    
    private VBox createAddTechnologyPane() {
        VBox pane = new VBox();
        
        return pane;
    }
    
    private VBox createRemoveTechnologyPane() {
        VBox pane = new VBox();
        
        return pane;
    }
    
    private HBox createMainPane() {
        HBox pane = new HBox();
        
        return pane;
    }
    
    
}
