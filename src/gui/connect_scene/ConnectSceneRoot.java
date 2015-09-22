package gui.connect_scene;

import business_logic.Employee;
import core.ResourcesManager;
import gui.connect_scene.body.ApplyGroup;
import gui.connect_scene.body.LogInGroup;
import gui.connect_scene.head.ConnectSceneHead;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public abstract class ConnectSceneRoot extends BorderPane {
    //================================================================================
    // Fields
    //================================================================================
    
    private ResourcesManager rManager;
    
    private HBox head;
    private Group body;
    
    //================================================================================
    // Constructors
    //================================================================================

    public ConnectSceneRoot(ResourcesManager rManager) {
        this.rManager = rManager;
        initiateHead();
        initiateBody();
        toLogInGroup();
    }

    //================================================================================
    // Methods
    //================================================================================

    private void initiateHead() {
        head = new ConnectSceneHead() {

            @Override
            public void onLogInButtonClick() {
                toLogInGroup();
            }

            @Override
            public void onApplyButtonClick() {
                toApplyGroup();
            }
        };
        
       this.setTop(head);
    }
    
    private void initiateBody() {
        toLogInGroup();
    }
    
    private void toApplyGroup() {
        body = new ApplyGroup(rManager) {
            
            @Override
            public void onSuccessfulApply() {
                toLogInGroup();
            }
        };
        this.setCenter(body);
    }
    
    private void toLogInGroup() {
        body = new LogInGroup(rManager) {
            @Override
            public void onSuccessfulLogIn(Employee employee) {
                logIn(employee);
            }
        };
        this.setCenter(body);
    }
    
    public abstract void logIn(Employee employee);
  
    //================================================================================
    // Accessors
    //================================================================================
}
