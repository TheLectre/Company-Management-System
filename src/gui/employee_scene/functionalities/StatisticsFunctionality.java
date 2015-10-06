package gui.employee_scene.functionalities;

import business_logic.Employee;
import business_logic.Team;
import core.ResourcesManager;
import gui.employee_scene.BaseFunctionality;
import gui.employee_scene.EmployeeSceneRoot;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class StatisticsFunctionality extends BaseFunctionality {
    //================================================================================
    // Fields
    //================================================================================

    //data
    private List<Team> teams;
    private ArrayList<String> technologyNamesUsed;

    //ui
    private HBox mainPane;
    private TreeView<String> technologies;
    private BorderPane infoPane;

    //================================================================================
    // Constructors
    //================================================================================
    public StatisticsFunctionality(EmployeeSceneRoot root, ResourcesManager rManager) {
        super(root, rManager);
    }

    //================================================================================
    // Methods
    //================================================================================
    @Override
    public String name() {
        return "Statistics";
    }

    @Override
    public Pane loadContent() {
        mainPane = new HBox();

        initializeData();

        technologies = createTechnologiesTreeView();
        infoPane = createInfoPane("Company", ViewType.COMPANY);

        mainPane.getChildren().add(technologies);
        mainPane.getChildren().add(infoPane);

        return mainPane;
    }

    //concurrency possibility
    private void initializeData() {
        teams = rManager.getAllTeams();

        technologyNamesUsed = new ArrayList<>();

        for (Team p : teams) {
            String techName = p.getTechnology().getName();
            if (!technologyNamesUsed.contains(p.getTechnology().getName())) {
                technologyNamesUsed.add(techName);
            }
        }
    }

    private TreeView<String> createTechnologiesTreeView() {

        TreeItem<String> mainItem = new TreeItem<>("Company");

        for (String p : technologyNamesUsed) {

            TreeItem<String> majorItem = new TreeItem<>(p);

            for (Team t : teams) {
                if (t.getTechnology().getName().equals(p)) {
                    TreeItem<String> minorItem = new TreeItem<>(t.getName());
                    majorItem.getChildren().add(minorItem);
                }
            }
            mainItem.getChildren().add(majorItem);
        }

        TreeView<String> mainTree = new TreeView<>(mainItem);
        mainTree.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                
                TreeItem<String> selectedItem = (TreeItem<String>) newValue;

                ViewType type;

                if (selectedItem.getValue().equals("Company")) {
                    type = ViewType.COMPANY;
                } else if (selectedItem.getParent().getValue().equals("Company")) {
                    type = ViewType.TECHNOLOGY;
                } else {
                    type = ViewType.TEAM;
                }

                mainPane.getChildren().remove(infoPane);
                infoPane = createInfoPane(selectedItem.getValue(), type);
                mainPane.getChildren().add(infoPane);
            }

        });

        return mainTree;
    }

    private BorderPane createInfoPane(String name, ViewType type) {
        BorderPane bPane = new BorderPane();

        bPane.setTop(createHeaderLabel(name));
        bPane.setCenter(createStatisticsPane(name, type));

        return bPane;
    }

    private GridPane createStatisticsPane(String name, ViewType type) {
        GridPane majorPane = new GridPane();

        //column names
        Label[] columnNames = new Label[5];
        columnNames[0] = new Label("Managers");
        columnNames[1] = new Label("Seniors");
        columnNames[2] = new Label("Regulars");
        columnNames[3] = new Label("Juniors");
        columnNames[4] = new Label("All");

        //row names
        Label[] rowNames = new Label[5];
        rowNames[0] = new Label("Size");
        rowNames[1] = new Label("Monthly cost");
        rowNames[2] = new Label("AVG. salary");
        rowNames[3] = new Label("Highest salary");
        rowNames[4] = new Label("Lowest salary");

        //filled data
        DataManager dManager;
        switch(type) {
            case COMPANY: dManager = new CompanyDataManager();
            case TECHNOLOGY: dManager = new TechnologyDataManager();
            case TEAM: dManager = new TeamDataManager();
        }
        
        
        return majorPane;
    }

    private Label createHeaderLabel(String name) {
        Label label = new Label(name);

        return label;
    }
    
    //================================================================================
    // Accessors
    //================================================================================
    //================================================================================
    // Inner classes
    //============================================================        return majorPane;====================
    public enum ViewType {

        COMPANY,
        TECHNOLOGY,
        TEAM
    }
    
    public abstract class DataManager {

        private final String name;
        private int[][] data;
        private final List<Integer> salaries;
        

        public DataManager(String name) {
            this.name = name;
            data = new int[5][5];
            salaries = initializeSalariesList();
        }

        protected abstract List<Integer> initializeSalariesList();
        
        protected abstract void fillSizeRow();

        protected abstract void fillMonthlyCostRow();

        protected abstract void fillAverageSalaryRow();

        protected abstract void fillHighestSalaryRow();

        protected abstract void fillLowestSalaryRow();

        public int[][] getData() {
            return data;
        }

    }

    public final class CompanyDataManager extends DataManager {

        public CompanyDataManager(String name) {
            super(name);
        }
        
        @Override
        protected List<Integer> initializeSalariesList() {
            List<Integer> salaries = rManager.getSalariesOfAllEmployees();
            
            return salaries;
        }
        
        @Override
        protected void fillSizeRow() {
            
        }

        @Override
        protected void fillMonthlyCostRow() {

        }

        @Override
        protected void fillAverageSalaryRow() {

        }

        @Override
        protected void fillHighestSalaryRow() {

        }

        @Override
        protected void fillLowestSalaryRow() {

        }

        

    }

    public final class TechnologyDataManager extends DataManager {

        public TechnologyDataManager(String name) {
            super(name);
        }
        
        @Override
        protected List<Integer> initializeSalariesList() {
            List<Integer> salaries = rManager.getSalariesOfTechnologyMembers(technology_id);
            
            return salaries;
        }
        

        @Override
        protected void fillSizeRow() {

        }

        @Override
        protected void fillMonthlyCostRow() {

        }

        @Override
        protected void fillAverageSalaryRow() {

        }

        @Override
        protected void fillHighestSalaryRow() {

        }

        @Override
        protected void fillLowestSalaryRow() {

        }

    }

    public final class TeamDataManager extends DataManager {

        public TeamDataManager(String name) {
            super(name);
        }

        @Override
        protected List<Integer> initializeSalariesList() {
            List<Integer> salaries = rManager.getSalariesOfTeamMembers(team_id);
            
            return salaries;
        }

        
        @Override
        protected void fillSizeRow() {

        }

        @Override
        protected void fillMonthlyCostRow() {

        }

        @Override
        protected void fillAverageSalaryRow() {

        }

        @Override
        protected void fillHighestSalaryRow() {

        }

        @Override
        protected void fillLowestSalaryRow() {

        }
    }
}
