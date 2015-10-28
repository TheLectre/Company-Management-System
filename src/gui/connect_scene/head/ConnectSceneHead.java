package gui.connect_scene.head;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


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
        
        this.setPadding(new Insets(40, 40, 40, 40));
        this.setSpacing(40);
        this.setAlignment(Pos.CENTER);
    }

    //================================================================================
    // Methods
    //================================================================================
	
    public abstract void onLogInButtonClick();
    
    public abstract void onApplyButtonClick();
    
    private void initiateLogInButton() {
        logInButton = new Button("Log in");
        logInButton.setFont(Font.font(null, FontWeight.BOLD, 18));
        
        logInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onLogInButtonClick();
            }
        });
        
        this.getChildren().add(logInButton);
    }
    
    private void initiateApplyButton() {
        applyButton = new Button("Apply");
        applyButton.setFont(Font.font(null, FontWeight.BOLD, 18));
        
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
