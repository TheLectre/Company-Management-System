package gui.employee_scene.functionalities;

import business_logic.Employee;
import business_logic.Team;
import core.ResourcesManager;
import gui.employee_scene.BaseFunctionality;
import gui.employee_scene.EmployeeSceneRoot;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


public class TeamsFunctionality extends BaseFunctionality {
    //================================================================================
    // Fields
    //================================================================================

    //data
    private List<Employee> teamedEmployees;
    private List<Team> teams;
    private ArrayList<String> technologyNamesUsed;
    
    //ui
    private HBox mainPane;
    private TreeView<String> technologies;
    private GridPane infoPane;

    //================================================================================
    // Constructors
    //================================================================================

    public TeamsFunctionality(EmployeeSceneRoot root, ResourcesManager rManager) {
        super(root, rManager);
    }

    //================================================================================
    // Methods
    //================================================================================
	
    @Override
    public String name() {
        return "Teams";
    }

    @Override
    public Pane loadContent() {
        mainPane = new HBox();
        
        initializeData();
        
        technologies = createTechnologiesTreeView();
        infoPane = createInfoPane();
        
        mainPane.getChildren().add(technologies);
        mainPane.getChildren().add(infoPane);
        
        return mainPane;
    }
    
    //concurrency possibility
    private void initializeData() {
        teams = rManager.getAllTeams();
        
        teamedEmployees = rManager.getTeamedEmployees();
        
        technologyNamesUsed = new ArrayList<>();
        
        for(Team p : teams) {
            String techName = p.getTechnology().getName();
            if(!technologyNamesUsed.contains(p.getTechnology().getName())) {
                technologyNamesUsed.add(techName);
            }
        }
    }
    
    private TreeView<String> createTechnologiesTreeView() {  
        
        TreeItem<String> mainItem = new TreeItem<>("Technologies");
        mainItem.setExpanded(true);
        
        for(String p : technologyNamesUsed) {
            
            TreeItem<String> majorItem = new TreeItem<>(p);
            
                    
            for(Team t : teams) {
                if(t.getTechnology().getName().equals(p)) {
                    TreeItem<String> minorItem = new TreeItem<>(t.getName());
                    majorItem.getChildren().add(minorItem);
                }
            }
            mainItem.getChildren().add(majorItem);
        }
        
       
        TreeView<String> mainTree = new TreeView<>(mainItem);
        
        return mainTree;
    }
    
    private GridPane createInfoPane() {
        GridPane gPane = new GridPane();
        
        //TODO
        
        return gPane;
    }

    //================================================================================
    // Accessors
    //================================================================================
    
    
}
