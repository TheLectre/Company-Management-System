package gui.employee_scene.functionalities;

import business_logic.Employee;
import business_logic.Experience;
import business_logic.Team;
import business_logic.Technology;
import core.ResourcesManager;
import gui.employee_scene.BaseFunctionality;
import gui.employee_scene.EmployeeSceneRoot;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TeamViewFunctionality extends BaseFunctionality {

    //================================================================================
    // Fields
    //================================================================================
    //ui
    private VBox mainPane;
    private TableView<EmployeeDisplay> teamTable;
    private Node teamNameNode;
    private Label noTeamLabel;
    private Button addEmployeeButton;
    private Button removeEmployeeButton;
    private Button addNewTeamButton;
    private Button deleteTeamButton;

    //data
    private ObservableList<EmployeeDisplay> viewedEmployeeData;

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

        boolean admin = root.getEmployee().getExperience().equals(Experience.ADMINISTRATOR);

        if (root.getEmployee().getTeam() != null || admin) {
            teamTable = createTeamTableTemplate();
            teamNameNode = admin ? createTeamNameComboBox() : createTeamNameLabel();

            mainPane.getChildren().add(teamNameNode);
            mainPane.getChildren().add(teamTable);

            if (admin) {
                addEmployeeButton = createAddEmployeeButton();
                removeEmployeeButton = createRemoveEmployeeButton();
                addNewTeamButton = createAddNewTeamButton();
                deleteTeamButton = createDeleteTeamButton();

                HBox buttonBox = new HBox();
                buttonBox.getChildren().addAll(removeEmployeeButton, addEmployeeButton, addNewTeamButton, deleteTeamButton);
                mainPane.getChildren().add(buttonBox);
            }
        } else {
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

    private ComboBox<Team> createTeamNameComboBox() {
        ComboBox<Team> comboBox = new ComboBox<>();

        List<Team> teams = rManager.getAllTeams();

        for (Team p : teams) {
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
        //table
        TableView<EmployeeDisplay> tableView = new TableView<>();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setEditable(true);

        //columns
        TableColumn<EmployeeDisplay, Boolean> selectColumn = new TableColumn<>(" ");
        selectColumn.setCellValueFactory(new PropertyValueFactory<>("selected"));
        selectColumn.setCellFactory(CheckBoxTableCell.forTableColumn(selectColumn));
        selectColumn.maxWidthProperty().bind(tableView.widthProperty().multiply(0.10f));

        TableColumn<EmployeeDisplay, Integer> indexColumn = new TableColumn<>(" ");
        indexColumn.setCellValueFactory(new PropertyValueFactory<>("index"));
        indexColumn.maxWidthProperty().bind(tableView.widthProperty().multiply(0.10f));

        TableColumn<EmployeeDisplay, String> positionColumn = new TableColumn<>("Position");
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        positionColumn.maxWidthProperty().bind(tableView.widthProperty().multiply(0.20f));

        TableColumn<EmployeeDisplay, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameColumn.maxWidthProperty().bind(tableView.widthProperty().multiply(0.35f));

        TableColumn<EmployeeDisplay, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameColumn.maxWidthProperty().bind(tableView.widthProperty().multiply(0.20f)); //change to 35 after

        tableView.getColumns().addAll(selectColumn, indexColumn, positionColumn, firstNameColumn, lastNameColumn);

        return tableView;
    }

    private void refreshTeamTable(int team_id) {
        //data
        List<Employee> currentTeamMembers = rManager.getEmployeesByTeamID(team_id);

        viewedEmployeeData = FXCollections.observableArrayList();

        int index = 0;
        for (Employee p : currentTeamMembers) {
            viewedEmployeeData.add(new EmployeeDisplay(p.getID(), ++index, p.getFirstName(), p.getLastName(), p.getExperience().toString()));
        }
        
        teamTable.setItems(viewedEmployeeData);
    }

    private void refreshAdminView() {
        teamNameNode = createTeamNameComboBox();
        
        mainPane.getChildren().remove(0);
        mainPane.getChildren().add(0, teamNameNode);
        
        refreshTeamTable(((ComboBox<Team>)teamNameNode).getValue().getID());
    }
    
    private Button createAddEmployeeButton() {
        Button addButton = new Button("Assign employee");

        addButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                ComboBox<Team> teamComboBox = (ComboBox) teamNameNode; // safe downcasting, needed to get current technology

                //data
                int team_id = teamComboBox.getValue().getID();
                List<Employee> teamFreeEmployees = rManager.getTeamFreeEmployeesOfTechnologyID(teamComboBox.getValue().getTechnology().getID());

                //UI
                Stage employeePickStage = new Stage();

                //components of screenRoot
                Label techName = new Label("Team free " + teamComboBox.getValue().getTechnology().getName() + " employees");

                VBox minorPane = new VBox();

                ArrayList<Integer> checkedEmployeeIDs = new ArrayList<>();

                for (Employee p : teamFreeEmployees) {
                    HBox hBox = new HBox();

                    CheckBox checkBox = new CheckBox();
                    checkBox.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            if (checkBox.isSelected()) {
                                checkedEmployeeIDs.add(p.getID());
                            } else {
                                checkedEmployeeIDs.remove((Object) p.getID());
                            }
                        }
                    });

                    Label name = new Label("" + p.getFirstName() + " " + p.getLastName());
                    Label pos = new Label(p.getExperience().toString());

                    hBox.getChildren().addAll(checkBox, name, pos);

                    minorPane.getChildren().add(hBox);
                }

                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(minorPane);
                scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
                scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);

                HBox buttonBox = new HBox();
                buttonBox.setAlignment(Pos.CENTER);

                Button acceptButton = new Button("Accept");
                acceptButton.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {

                        for (Integer p : checkedEmployeeIDs) {
                            rManager.updateEmployeeTeam(p, team_id);
                        }

                        refreshTeamTable(team_id);
                        employeePickStage.close();
                    }

                });

                Button cancelButton = new Button("Cancel");
                cancelButton.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        employeePickStage.close();
                    }
                });

                buttonBox.getChildren().addAll(acceptButton, cancelButton);

                //screenRoot
                VBox majorPane = new VBox();
                majorPane.getChildren().addAll(techName, scrollPane, buttonBox);

                employeePickStage.setScene(new Scene(majorPane, 250, 150));
                employeePickStage.setTitle("Pick employee");
                employeePickStage.show();

            }
        });

        return addButton;
    }

    private Button createRemoveEmployeeButton() {
        Button removeButton = new Button("Remove selected");

        removeButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //counting remove requests
                ArrayList<Integer> removeCandidatesIDs = new ArrayList<>();
                for(EmployeeDisplay p : viewedEmployeeData) {
                    if(p.isSelected()) {
                        removeCandidatesIDs.add(p.getID());
                    }
                }
                
                //teamID
                ComboBox<Team> teamComboBox = (ComboBox) teamNameNode; // safe downcasting, needed to get current technology
                int team_id = teamComboBox.getValue().getID();
                
                //ui
                Stage removeEmployeesStage = new Stage();
                VBox majorBox = new VBox();
                Label infoLabel = new Label("Choose action for " +  (removeCandidatesIDs.isEmpty() ? "no" : removeCandidatesIDs.size()) + "employees");
                majorBox.getChildren().add(infoLabel);
                Label secondInfoLabel = new Label((removeCandidatesIDs.isEmpty() ? "Select employees first" : "Action cannot be reverted"));
                majorBox.getChildren().add(secondInfoLabel);
                if(removeCandidatesIDs.isEmpty()) {
                    Button okButton = new Button("OK");
                    okButton.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            removeEmployeesStage.close();
                        }
                    });
                    majorBox.getChildren().add(okButton);
                }
                else {
                    HBox buttonBox = new HBox();
                    Button removeButton = new Button("Remove");
                    removeButton.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            for(Integer p : removeCandidatesIDs) {
                                rManager.updateEmployeeTeam(p, null);
                            }
                            
                            removeEmployeesStage.close();
                            refreshTeamTable(team_id);
                        }
                    });
                    
                    Button fireButton = new Button("Fire");
                    fireButton.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            for(Integer p : removeCandidatesIDs) {
                                rManager.removeEmployee(p);
                            }
                            
                            removeEmployeesStage.close();
                            refreshTeamTable(team_id);
                        }
                    });
                    
                    Button cancelButton = new Button("Cancel");
                    cancelButton.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            removeEmployeesStage.close();
                        }
                    });
                    
                    buttonBox.getChildren().addAll(removeButton, fireButton, cancelButton);
                    majorBox.getChildren().add(buttonBox);
                }
                
                
                
                removeEmployeesStage.setTitle("Choose action");
                removeEmployeesStage.setScene(new Scene(majorBox, 250, 150));
                removeEmployeesStage.show();
            }
        });

        return removeButton;
    }

    private Button createAddNewTeamButton() {
        Button addButton = new Button("Create team");
        
        addButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                stage.setTitle("Creating team");
                
                TextField teamNameField = new TextField();
                teamNameField.setPromptText("Team name");
                
                ComboBox<String> technologyComboBox = new ComboBox<>();
                for(Technology p : rManager.getAllTechnologies()) {
                    technologyComboBox.getItems().add(p.getName());
                }
                technologyComboBox.setPromptText("Technology");
                
                Label errorLabel = new Label();
                
                Button addButton = new Button("Create");
                addButton.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        if(teamNameField.getText().length() > 20 || teamNameField.getText().length() < 3) {
                            errorLabel.setText("Invalid team name length <3-20> characters");
                        }
                        else if(rManager.getTeamID(teamNameField.getText()) != 0) {
                            errorLabel.setText("Team name already in use");
                        }
                        else if(technologyComboBox.getValue() == null) {
                            errorLabel.setText("Choose a technology");
                        }
                        else { // SUCCESSFUL
                            rManager.addNewTeam(new Team(teamNameField.getText(), new Technology(rManager.getTechnologyID(technologyComboBox.getValue()), technologyComboBox.getValue())));
                            stage.close();
                            refreshAdminView();
                        }
                    }
                });
                
                Button cancelButton = new Button("Cancel");
                cancelButton.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        stage.close();
                    }
                });
                                
                HBox buttons = new HBox();
                buttons.getChildren().addAll(addButton, cancelButton);
                
                
                VBox majorPane = new VBox();
                majorPane.getChildren().addAll(teamNameField, technologyComboBox, buttons, errorLabel);
                
                stage.setScene(new Scene(majorPane, 400, 300));
                stage.show();
            }
        });
        
        return addButton;
    }
    
    private Button createDeleteTeamButton() {
        Button deleteButton = new Button("Delete team");
        
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String teamName = ((ComboBox<Team>)teamNameNode).getValue().getName();
                Stage stage = new Stage();
                stage.setTitle("Deleting team");
                
                Label infoLabel = new Label("You are about to delete " + teamName + ".");
                Label secondInfoLabel = new Label("This action will not fire employees.");
                Label thirdInfoLabel = new Label("Are you sure? ");
                
                Button okButton = new Button("Delete");
                okButton.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        rManager.removeTeam(rManager.getTeamID(teamName));
                        stage.close();
                        refreshAdminView();
                    }
                });
                
                Button cancelButton = new Button("Cancel");
                cancelButton.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        stage.close();
                    }
                });
                
                HBox buttonsPane = new HBox();
                buttonsPane.getChildren().addAll(okButton, cancelButton);
                
                VBox majorPane = new VBox();
                majorPane.getChildren().addAll(infoLabel, secondInfoLabel, thirdInfoLabel, buttonsPane);
                
                stage.setScene(new Scene(majorPane, 300, 200));
                stage.show();
            }
        });
        
        return deleteButton;
    }
    
    //================================================================================
    // Accessors
    //================================================================================
    //================================================================================
    // Inner class
    //================================================================================
    public class EmployeeDisplay {

        private final int ID;
        private final int index;
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty position;

        private SimpleBooleanProperty selected;

        EmployeeDisplay(int ID, int index, String firstName, String lastName, String position) {
            this.ID = ID;
            this.index = index;
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
            this.position = new SimpleStringProperty(position);

            this.selected = new SimpleBooleanProperty(false);
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

        public boolean isSelected() {
            return selected.get();
        }

        public void setSelected(boolean selected) {
            this.selected.set(selected);
        }

        public BooleanProperty selectedProperty() {
            return selected;
        }
    }
}
