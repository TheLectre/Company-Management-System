package gui.employee_scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


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
        creator.setTextFill(Color.BROWN);
        creator.setFont(Font.font(null, FontWeight.BOLD, FontPosture.ITALIC, 18));
        
        year = new Label("2015");
        year.setTextFill(Color.BROWN);
        year.setFont(Font.font(null, FontWeight.BOLD, FontPosture.ITALIC, 18));
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
