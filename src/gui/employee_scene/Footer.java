package gui.employee_scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


public class Footer extends HBox {
    //================================================================================
    // Fields
    //================================================================================

    private Label creator;
    private Label year;

    //================================================================================
    // Constructors
    //================================================================================
    
    public Footer() {
        initiateLabels();
        initiateThis();
    }

    //================================================================================
    // Methods
    //================================================================================
	
    private void initiateLabels() {
        creator = new Label("Lectre");
        year = new Label("2015");
    }
    
    private void initiateThis() {
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(15, 12, 15, 12));
        this.setSpacing(10);
        
        this.getChildren().add(creator);
        this.getChildren().add(year);
    }

    //================================================================================
    // Accessors
    //================================================================================
}
