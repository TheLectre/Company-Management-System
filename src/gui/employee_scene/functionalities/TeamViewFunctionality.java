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
      TableView tableView<EmployeeDisplay> = new TableView<>();
      
      ArrayList teamMembers = rManager.getEmployeesByTeamID(/*teamID*/ rManager.getEmployee().getTeam().getID());

    

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
      private final SimpleStringProperty technologyName;
      private final SimpleStringProperty position;
      
    }
  
}
