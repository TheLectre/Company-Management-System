package gui.employee_scene.functionalities;

import business_logic.Employee;
import business_logic.Team;
import business_logic.Technology;
import core.ResourcesManager;
import gui.employee_scene.BaseFunctionality;
import gui.employee_scene.EmployeeSceneRoot;
import java.util.ArrayList;
import java.util.LinkedList;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class TechnologiesFunctioanlity extends BaseFunctionality {

    //================================================================================
    // Fields
    //================================================================================
    private HBox mainPane;

    private VBox tablePane;
    private VBox addTechnologyPane;
    private VBox removeTechnologyPane;

    private TableView technologiesTable;

    private ArrayList<Technology> unusedTechnologies = new ArrayList<>();

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

        technologiesTable = createTechnologyTable();
        tablePane = createTablePane();
        refreshTechnologyTable();
        addTechnologyPane = createAddTechnologyPane();
        removeTechnologyPane = createRemoveTechnologyPane();

        mainPane.getChildren().addAll(tablePane, addTechnologyPane, removeTechnologyPane);

        return mainPane;
    }

    private VBox createTablePane() {
        VBox vBox = new VBox();
        vBox.setSpacing(15);
        vBox.setAlignment(Pos.TOP_CENTER);

        Label titleLabel = new Label("List");
        titleLabel.setFont(Font.font(null, FontWeight.BOLD, 16));

        vBox.getChildren().add(titleLabel);
        vBox.getChildren().add(technologiesTable);

        return vBox;
    }

    private TableView createTechnologyTable() {
        TableView<TechnologyDisplay> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<TechnologyDisplay, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<TechnologyDisplay, Integer> numberOfTeamsColumn = new TableColumn<>("Teams");
        numberOfTeamsColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfTeams"));
        numberOfTeamsColumn.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn<TechnologyDisplay, Integer> numberOfEmployeesColumn = new TableColumn<>("Employees");
        numberOfEmployeesColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfEmployees"));
        numberOfEmployeesColumn.setSortType(TableColumn.SortType.DESCENDING);

        table.getColumns().addAll(nameColumn, numberOfTeamsColumn, numberOfEmployeesColumn);

        return table;
    }

    private void refreshTechnologyTable() {
        ObservableList<TechnologyDisplay> data = FXCollections.observableArrayList();

        //clearing unusedTechnologies
        unusedTechnologies.clear();

        for (Technology p : rManager.getAllTechnologies()) {

            int numberOfTeams = 0;
            for (Team k : rManager.getAllTeams()) {
                if (k.getTechnology().equals(p)) {
                    numberOfTeams++;
                }
            }

            int numberOfEmployees = 0;
            for (Employee k : rManager.getAllAcceptedEmployees()) {
                if (k.getTechnology().equals(p)) {
                    numberOfEmployees++;
                }
            }

            //unused technology?
            if (numberOfTeams == 0 && numberOfEmployees == 0) {
                unusedTechnologies.add(p);
            }

            data.add(new TechnologyDisplay(p.getName(), numberOfTeams, numberOfEmployees));
        }

        technologiesTable.setItems(data);
        technologiesTable.getSortOrder().clear();
        technologiesTable.getSortOrder().add(technologiesTable.getColumns().get(2));
    }

    private void refreshRemoveTechnologyPane() {
        mainPane.getChildren().remove(removeTechnologyPane);
        removeTechnologyPane = createRemoveTechnologyPane();
        mainPane.getChildren().add(removeTechnologyPane);
    }

    private VBox createAddTechnologyPane() {
        VBox pane = new VBox();
        pane.setSpacing(15);
        pane.setAlignment(Pos.TOP_CENTER);
        
        Label titleLabel = new Label("Add");
        titleLabel.setFont(Font.font(null, FontWeight.BOLD, 16));

        TextField nameField = new TextField();
        nameField.setPromptText("Technology name");

        Label errorLabel = new Label();

        Button submitButton = new Button("Confirm");
        submitButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                String name = nameField.getText();
                nameField.setText("");
                
                if (rManager.getTechnologyID(name) != 0) {
                    errorLabel.setText(name + " is added already");
                } else if (name.length() > 20) {
                    errorLabel.setText("Name is too long");
                } else {
                    errorLabel.setVisible(false);
                    rManager.addNewTechnology(new Technology(name));
                    refreshTechnologyTable();
                    refreshRemoveTechnologyPane();
                }
            }
        });

        pane.getChildren().addAll(titleLabel, nameField, submitButton, errorLabel);

        return pane;
    }

    private VBox createRemoveTechnologyPane() {
        VBox majorpane = new VBox();
        majorpane.setSpacing(15);
        majorpane.setAlignment(Pos.TOP_CENTER);
        
        Label titleLabel = new Label("Remove");
        titleLabel.setFont(Font.font(null, FontWeight.BOLD, 16));

        Label warningLabel = new Label("You can only remove\n not used technologies");

        VBox minorPane = new VBox();

        LinkedList<Integer> checkedTechnologyIDs = new LinkedList<>();

        for (Technology p : unusedTechnologies) {
            HBox hBox = new HBox();

            CheckBox checkBox = new CheckBox();
            checkBox.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    if (checkBox.isSelected()) {
                        checkedTechnologyIDs.add(p.getID());
                    } else {
                        checkedTechnologyIDs.remove((Object) p.getID());
                    }
                }
            });

            Label nameLabel = new Label(p.getName());

            hBox.getChildren().addAll(checkBox, nameLabel);

            minorPane.getChildren().add(hBox);
        }

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setContent(minorPane);

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                for (Integer p : checkedTechnologyIDs) {
                    rManager.removeTechnology(p);
                    refreshTechnologyTable();
                    refreshRemoveTechnologyPane();
                }
            }
        });

        majorpane.getChildren().addAll(titleLabel, warningLabel, scrollPane, submitButton);

        return majorpane;
    }

    private HBox createMainPane() {
        HBox pane = new HBox();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(15, 15, 15, 15));
        pane.setSpacing(15);
        
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
