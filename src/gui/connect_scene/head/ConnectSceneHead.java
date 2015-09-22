package gui.connect_scene.head;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;


public abstract class ConnectSceneHead extends HBox {
    //================================================================================
    // Fields
    //================================================================================

    private Button logInButton;
    private Button applyButton;

    //================================================================================
    // Constructors
    //================================================================================
    
    public ConnectSceneHead() {
        initiateLogInButton();
        initiateApplyButton();
        
        this.setPadding(new Insets(15, 12, 15, 12));
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
    }

    //================================================================================
    // Methods
    //================================================================================
	
    public abstract void onLogInButtonClick();
    
    public abstract void onApplyButtonClick();
    
    private void initiateLogInButton() {
        logInButton = new Button("Log in");
        
        logInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onLogInButtonClick();
            }
        });
        
        logInButton.setPrefSize(100, 25);
        this.getChildren().add(logInButton);
    }
    
    private void initiateApplyButton() {
        applyButton = new Button("Apply");
        
        applyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onApplyButtonClick();
            }
        });
        
        this.getChildren().add(applyButton);
    }

    //================================================================================
    // Accessors
    //================================================================================
}
