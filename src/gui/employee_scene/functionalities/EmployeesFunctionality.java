package gui.employee_scene.functionalities;

import core.ResourcesManager;
import gui.employee_scene.BaseFunctionality;
import gui.employee_scene.EmployeeSceneRoot;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class EmployeesFunctionality extends BaseFunctionality {

    //================================================================================
    // Fields
    //================================================================================
    private VBox mainPane;

    //================================================================================
    // Constructors
    //================================================================================
    public EmployeesFunctionality(EmployeeSceneRoot root, ResourcesManager rManager) {
        super(root, rManager);
    }

    //================================================================================
    // Methods
    //================================================================================
    @Override
    public String name() {
        return "Employees";
    }

    @Override
    public Pane loadContent() {
        mainPane = createMainPane();

        return mainPane;
    }

    private VBox createMainPane() {
        VBox pane = new VBox();

        return pane;
    }

}
