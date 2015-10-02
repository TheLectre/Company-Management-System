package gui.employee_scene.functionalities;

import business_logic.Employee;
import business_logic.Experience;
import business_logic.Team;
import core.ResourcesManager;
import gui.employee_scene.BaseFunctionality;
import gui.employee_scene.EmployeeSceneRoot;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class TeamViewFunctionality extends BaseFunctionality {

    //================================================================================
    // Fields
    //================================================================================
    
    //ui
    private VBox mainPane;
    private TableView<EmployeeDisplay> teamTable;
    private Node teamNameNode;
    private Label noTeamLabel;

    //================================================================================
    // Constructors
    //================================================================================
    public TeamViewFunctionality(EmployeeSceneRoot root, ResourcesManager rManager) {
        super(root, rManager);
    }

    //================================================================================
    // Methods
    //================================================================================
    @Override
    public String name() {
        return "Team View";
    }

    @Override
    public Pane loadContent() {
        mainPane = new VBox();

        mainPane.setAlignment(Pos.CENTER);

        if (root.getEmployee().getTeam() != null || root.getEmployee().getExperience().equals(Experience.ADMINISTRATOR)) {
            teamTable = createTeamTableTemplate();
            teamNameNode = root.getEmployee().getExperience().equals(Experience.ADMINISTRATOR) ? createTeamNameComboBox() : createTeamNameLabel();
            
            mainPane.getChildren().add(teamNameNode);
            mainPane.getChildren().add(teamTable);
        }
        else {
            noTeamLabel = createNoTeamLabel();
            mainPane.getChildren().add(noTeamLabel);
        }

        return mainPane;
    }

    private Label createNoTeamLabel() {
        Label label = new Label("You do not belong to any team.");

        return label;
    }
    
    private Label createTeamNameLabel() {
        refreshTeamTable(root.getEmployee().getTeam().getID());
        
        Label label = new Label(root.getEmployee().getTeam().getName());
        
        return label;
    }
    
    private ComboBox createTeamNameComboBox() {
        ComboBox<Team> comboBox = new ComboBox<>();
        
        List<Team> teams = rManager.getAllTeams();
        
        for(Team p : teams) {
            comboBox.getItems().add(p);
        }
        
        comboBox.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                refreshTeamTable(comboBox.getValue().getID());
            }
        });
        
        comboBox.setValue(comboBox.getItems().get(0));
        refreshTeamTable(comboBox.getValue().getID()); //no automatic refresh hard coded way
        
        return comboBox;
    }
    
    private TableView createTeamTableTemplate() {
        //table and columns
        TableView<EmployeeDisplay> tableView = new TableView<>();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setEditable(false);

        TableColumn indexColumn = new TableColumn(" ");
        indexColumn.setCellValueFactory(new PropertyValueFactory<>("index"));
        indexColumn.maxWidthProperty().bind(tableView.widthProperty().multiply(0.10f));
        
        TableColumn positionColumn = new TableColumn("Position");
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        positionColumn.maxWidthProperty().bind(tableView.widthProperty().multiply(0.20f));
        
        TableColumn firstNameColumn = new TableColumn("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameColumn.maxWidthProperty().bind(tableView.widthProperty().multiply(0.35f));

        TableColumn lastNameColumn = new TableColumn("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameColumn.maxWidthProperty().bind(tableView.widthProperty().multiply(0.35f));

        tableView.getColumns().addAll(indexColumn, positionColumn, firstNameColumn, lastNameColumn);
        
        return tableView;
    }
    
    private void refreshTeamTable(int team_id) {
        //data
        List<Employee> teamMembers = rManager.getEmployeesByTeamID(team_id);

        ObservableList<EmployeeDisplay> data = FXCollections.observableArrayList();

        int index = 0;
        for (Employee p : teamMembers) {
            data.add(new EmployeeDisplay(p.getID(), ++index, p.getFirstName(), p.getLastName(), p.getExperience().toString()));
        }
        
        teamTable.setItems(data);
    }
    //================================================================================
    // Accessors
    //================================================================================

    //================================================================================
    // Inner class
    //================================================================================
    public static class EmployeeDisplay {

        private final int ID;
        private final int index;
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty position;

        EmployeeDisplay(int ID, int index, String firstName, String lastName, String position) {
            this.ID = ID;
            this.index = index;
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
            this.position = new SimpleStringProperty(position);
        }

        public int getID() {
            return ID;
        }
        
        public int getIndex() {
            return index;
        }

        public String getFirstName() {
            return firstName.get();
        }

        public String getLastName() {
            return lastName.get();
        }

        public String getPosition() {
            return position.get();
        }
        
        
    }

}
