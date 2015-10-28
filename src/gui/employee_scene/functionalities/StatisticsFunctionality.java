package gui.employee_scene.functionalities;

import business_logic.Experience;
import business_logic.Team;
import business_logic.Technology;
import core.ResourcesManager;
import gui.employee_scene.BaseFunctionality;
import gui.employee_scene.EmployeeSceneRoot;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class StatisticsFunctionality extends BaseFunctionality {
    //================================================================================
    // Fields
    //================================================================================

    //data
    private ArrayList<String> technologyNames;

    //ui
    private HBox mainPane;
    private TreeView<String> technologiesTree;
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

        mainPane.setPadding(new Insets(15, 15, 15, 15));
        mainPane.setSpacing(15);
        
        initializeData();

        technologiesTree = createTechnologiesTreeView();
        infoPane = createInfoPane("Company", ViewType.COMPANY);

        mainPane.getChildren().add(technologiesTree);
        mainPane.getChildren().add(infoPane);

        return mainPane;
    }

    //concurrency possibility
    private void initializeData() {

        List<Technology> technologies = rManager.getAllTechnologies();

        technologyNames = new ArrayList<>();

        for (Technology p : technologies) {
            technologyNames.add(p.getName());
        }
    }

    private TreeView<String> createTechnologiesTreeView() {

        TreeItem<String> mainItem = new TreeItem<>("Company");

        for (String p : technologyNames) {

            TreeItem<String> majorItem = new TreeItem<>(p);

            for (Team t : rManager.getAllTeams()) {
                if (t.getTechnology().getName().equals(p)) {
                    TreeItem<String> minorItem = new TreeItem<>(t.getName());
                    majorItem.getChildren().add(minorItem);
                }
            }
            mainItem.getChildren().add(majorItem);
        }

        TreeView<String> mainTree = new TreeView<>(mainItem);
        mainTree.setMaxWidth(180);
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

        majorPane.setAlignment(Pos.CENTER);
        
        majorPane.setHgap(7);
        majorPane.setVgap(9);
        
        
        //our table
        final short width = 6;
        final short height = 6;

        Label[][] table = new Label[width][height];

        //empty
        table[0][0] = new Label("");

        //column names
        table[1][0] = new Label("Juniors");
        table[2][0] = new Label("Regulars");
        table[3][0] = new Label("Seniors");
        table[4][0] = new Label("Managers");
        table[5][0] = new Label("All");

        for(int i=0;i<width;i++) {
            table[i][0].setFont(Font.font(null, FontWeight.BOLD, 12));
        }
        
        //row names
        table[0][1] = new Label("Size");
        table[0][2] = new Label("Monthly cost");
        table[0][3] = new Label("AVG. salary");
        table[0][4] = new Label("Highest salary");
        table[0][5] = new Label("Lowest salary");

        for(int i=0;i<width;i++) {
            table[0][i].setFont(Font.font(null, FontWeight.BOLD, 12));
        }
        
        //data
        DataManager juniorDataManager = new DataManager(name, type, Experience.JUNIOR);
        for (int i = 1; i < table[1].length; i++) {
            table[1][i] = new Label("" + juniorDataManager.getDataRow(i - 1));
        }

        DataManager regularDataManager = new DataManager(name, type, Experience.REGULAR);
        for (int i = 1; i < table[2].length; i++) {
            table[2][i] = new Label("" + regularDataManager.getDataRow(i - 1));
        }

        DataManager seniorDataManager = new DataManager(name, type, Experience.SENIOR);
        for (int i = 1; i < table[3].length; i++) {
            table[3][i] = new Label("" + seniorDataManager.getDataRow(i - 1));
        }

        DataManager managerDataManager = new DataManager(name, type, Experience.MANAGER);
        for (int i = 1; i < table[4].length; i++) {
            table[4][i] = new Label("" + managerDataManager.getDataRow(i - 1));
        }

        DataManager allDataManager = new DataManager(name, type, null);
        for (int i = 1; i < table[5].length; i++) {
            table[5][i] = new Label("" + allDataManager.getDataRow(i - 1));
        }

        //visualising
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                majorPane.add(table[i][j], i, j);
            }
        }

        return majorPane;
    }

    private Label createHeaderLabel(String name) {
        Label label = new Label(name);
        label.setFont(Font.font(null, FontWeight.BOLD, 16));
        return label;
    }

    //================================================================================
    // Accessors
    //================================================================================
    //================================================================================
    // Inner classes
    //================================================================================
    public enum ViewType {

        COMPANY,
        TECHNOLOGY,
        TEAM
    }

    public class DataManager {

        private final String name;
        private final String[] data;
        private final List<Integer> salaries;

        public DataManager(String name, ViewType type, Experience experience) {
            this.name = name;
            salaries = initializeSalariesList(type, experience);
            data = new String[5];
            data[0] = fillSizeRow();
            data[1] = fillMonthlyCostRow();
            data[2] = fillAverageSalaryRow();
            data[3] = fillHighestSalaryRow();
            data[4] = fillLowestSalaryRow();
        }

        private List<Integer> initializeSalariesList(ViewType type, Experience exp) {
            List<Integer> temp;

            switch (type) {
                case COMPANY:
                    if (exp != null) {
                        temp = rManager.getSalariesOfAllEmployees(exp);
                    } else {
                        temp = new ArrayList<>();
                        temp.addAll(rManager.getSalariesOfAllEmployees(Experience.JUNIOR));
                        temp.addAll(rManager.getSalariesOfAllEmployees(Experience.REGULAR));
                        temp.addAll(rManager.getSalariesOfAllEmployees(Experience.SENIOR));
                        temp.addAll(rManager.getSalariesOfAllEmployees(Experience.MANAGER));
                    }
                    break;
                case TECHNOLOGY:
                    if (exp != null) {
                        temp = rManager.getSalariesOfTechnologyMembers(rManager.getTechnologyID(name), exp);
                    } else {
                        temp = new ArrayList<>();
                        temp.addAll(rManager.getSalariesOfTechnologyMembers(rManager.getTechnologyID(name), Experience.JUNIOR));
                        temp.addAll(rManager.getSalariesOfTechnologyMembers(rManager.getTechnologyID(name), Experience.REGULAR));
                        temp.addAll(rManager.getSalariesOfTechnologyMembers(rManager.getTechnologyID(name), Experience.SENIOR));
                        temp.addAll(rManager.getSalariesOfTechnologyMembers(rManager.getTechnologyID(name), Experience.MANAGER));
                    }
                    break;
                case TEAM:
                    if (exp != null) {
                        temp = rManager.getSalariesOfTeamMembers(rManager.getTeamID(name), exp);
                    } else {
                        temp = new ArrayList<>();
                        temp.addAll(rManager.getSalariesOfTeamMembers(rManager.getTeamID(name), Experience.JUNIOR));
                        temp.addAll(rManager.getSalariesOfTeamMembers(rManager.getTeamID(name), Experience.REGULAR));
                        temp.addAll(rManager.getSalariesOfTeamMembers(rManager.getTeamID(name), Experience.SENIOR));
                        temp.addAll(rManager.getSalariesOfTeamMembers(rManager.getTeamID(name), Experience.MANAGER));
                    }
                    break;
                default:
                    throw new IllegalArgumentException() {
                        @Override
                        public String getMessage() {
                            return "Invalid type passed.";
                        }
                    };
            }

            return temp;
        }

        private String fillSizeRow() {
            return "" + salaries.size();
        }

        private String fillMonthlyCostRow() {
            int temp = 0;

            for (Integer p : salaries) {
                temp += p;
            }

            return "" + temp + "‎€";
        }

        private String fillAverageSalaryRow() {
            float temp = 0.0f;

            for (Integer p : salaries) {
                temp += p;
            }

            return "" + Math.round(temp / (float) salaries.size()) + "‎€";
        }

        private String fillHighestSalaryRow() {
            int temp = 0;

            for (Integer p : salaries) {
                temp = Math.max(temp, p);
            }

            return "" + temp + "‎€";
        }

        private String fillLowestSalaryRow() {
            int temp = salaries.isEmpty() ? 0 : salaries.get(0);

            for (Integer p : salaries) {
                temp = Math.min(temp, p);
            }

            return "" + temp + "‎€";
        }

        private String getDataRow(int index) {
            return data[index];
        }

    }
}
