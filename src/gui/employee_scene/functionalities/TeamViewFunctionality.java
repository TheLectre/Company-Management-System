public class TeamViewFunctionality extends BasicFunctionality {
    //================================================================================
    // Fields
    //================================================================================
    private VBox mainPane;
    private TableView<EmployeeDisplay> teamTable;
    private Label noTeamLabel;
    
    //================================================================================
    // Constructors
    //================================================================================
    public TeamViewFunctionality(EmployeeSceenRoot root, ResourceManager rManager) {
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
      
      if(root.getEmployee().getTeam() != null) {
      teamTable = createTeamTable();
      mainPane.getChildren().add(teamTable);
      }
      
      else {
        noTeamLabel = createNoTeamLabel();
        mainPane.getChildren.add(noTeamLabel);
      }
      
    }
    
    public Label createNoTeamLabel() {
      Label label = new Label("You do not belong to any team.");
      
      return label;
    }
    
    public TableView createTeamTable() {
        //table and columns
        TableView tableView<EmployeeDisplay> = new TableView<>();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setEditable(false);
        
        TableColumn firstNameColumn = new TableColumn("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        
        TableColumn lastNameColumn = new TableColumn("Last Name");
        fromColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        
        TableColumn positionColumn = new TableColumn("Position");
        fromColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        
        //data
        ArrayList teamMembers = rManager.getEmployeesByTeamID(/*teamID*/ rManager.getEmployee().getTeam().getID());

        ObservableList<EmployeeDisplay> data = FXCollections.observableArrayList();
        
        for(EmployeeDisplay p : teamMembers) {
            data.add(new EmployeeDisplay(p.getID(), p.getFirstName(), p.getLastName(), p.getExperience().toString()));
        }

        //visualization
        tableView.getColumns().add(firstNameColumn, lastNameColumn, positionColumn);
        tableView.setItems(data);

      return tableView();
    }
    //================================================================================
    // Accessors
    //================================================================================
    
    //================================================================================
    // Inner class
    //================================================================================
    private static class EmployeeDisplay {
      private final int ID;
      private final SimpleStringProperty firstName;
      private final SimpleStringProperty lastName;
      private final SimpleStringProperty position;
      
      public EmployeeDisplay(int ID, String firstName, String lastName, String position) {
          this.ID = ID;
          this.firstName = new SimpleStringProperty(firstName);
          this.lastName = new SimpleStringProperty(lastName);
          this.position = new SimpleStringProperty(position);
      }
    }
  
}
