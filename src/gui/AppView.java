package gui;

import business_logic.Employee;
import core.ResourcesManager;
import gui.connect_scene.ConnectSceneRoot;
import gui.employee_scene.EmployeeSceneRoot;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppView extends Application {

    //================================================================================
    // Fields
    //================================================================================
    private ResourcesManager rManager;

    private Stage primaryStage;

    private Scene connectScene;
    private Scene employeeScene;

    //================================================================================
    // Constructors
    //================================================================================
    //================================================================================
    // Methods
    //================================================================================
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        rManager = new ResourcesManager();

        toConnectScene();
        initializeStage();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void initializeStage() {
        primaryStage.setTitle("Company Management System");
        primaryStage.show();
    }

    public void toEmployeeScene(Employee employee) {
        initializeEmployeeScene(employee);
        primaryStage.setScene(employeeScene);
        if(connectScene != null) {
            connectScene = null;
        }
    }

    public void toConnectScene() {
        initializeConnectScene();
        
        if(employeeScene != null) {
            employeeScene = null;
        }
    }

    private void initializeEmployeeScene(Employee employee) {
        employeeScene = new Scene(new EmployeeSceneRoot(rManager, employee), 500, 400);
    }

    private void initializeConnectScene() {
        connectScene = new Scene(new ConnectSceneRoot(rManager) {

            @Override
            public void logIn(Employee employee) {
                toEmployeeScene(employee);
            }
        }, 500, 400);
        primaryStage.setScene(connectScene);
    }

    //================================================================================
    // Accessors
    //================================================================================
    public Stage getPrimaryStage() {
        return primaryStage;
    }

}
