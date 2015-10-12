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
        
        technologyTable = createTechnologyTable();
        addTechnologyPane = createAddTechnologyPane();
        removeTechnologyPane = createRemoveTechnologyPane();
        
        mainPane.getChildren().addAll();
        
        
        return mainPane;
    }
    
    private TableView createTechnologyTable() {
        TableView<TechnologyDisplay> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        TableColumn<TechnologyDisplay, String> nameColumn = new TableColumn<>("Name");
        table.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<TechnologyDisplay, Integer> numberOfTeamsColumn = new TableColumn<>("numberOfTeams");
        table.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<TechnologyDisplay, Integer> numberOfEmployeesColumn = new TableColumn<>("numberOfEmployees");
        table.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        tableView.getColumns().addAll(nameColumn, numberOfTeamsColumn, numberOfEmployeesColumn);
        
        return table;
    }
    
    private void refreshTechnologyTable() {
        ObservableList<TechnologyDisplay> data = FXCollections.observableArrayList();
        

        
        
        
        for(Technology p : rManager.getAllTechnologies()) {
            
            int numberOfTeams = 0;
            for(Team k : rManager.getAllTeams()) {
             if(k.getTechnology().equals(p)) {
                 numberOfTeams++;
                }
            }
            
            int numberOfEmployees = 0;
            for(Employee k : rManager.getAllEmployees()) {
             if(k.getTechnology().equals(p) && k.isAccepted) {
                 numberOfEmployees++;
                }
            }
            
            data.add(new TechnologyDisplay(p.getName(), numberOfTeams, numberOfEmployees));
        }
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
    //================================================================================
    // Inner class
    //================================================================================
    
    public class TechnologyDisplay {
        private final SimpleStringProperty name;
        private final int numberOfTeams;
        private final int numberOfEmployees;
        
        public TechnologyDisplay(String name, int numberOfTeams, int numberOfEmployees) {
            this.name = new SimpleStringProperty(name);
            this.numberOfTeams = numberOfTeams;
            this.numberOfEmployees = numberOfEmployees;
        }
        
        public String getName() {
            return name.get();
        }
        
        public int getNumberOfTeams() {
            return numberOfTeams;
        }
        
        public int getNumberOfEmployees() {
            return numberOfEmployees;
        }
    }
}
