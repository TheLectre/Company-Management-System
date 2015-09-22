package gui.employee_scene;

import business_logic.Employee;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class InfoPanel extends BorderPane {
    //================================================================================
    // Fields
    //================================================================================

    private Employee empl;
    
    private VBox top;
    private VBox bottom;

    //================================================================================
    // Constructors
    //================================================================================
    
    public InfoPanel(Employee empl) {
        this.empl = empl;
        initiateTop();
        initiateBottom();
        initiateThis();
    }

    //================================================================================
    // Methods
    //================================================================================
	
    private void initiateTop() {
        top = new VBox();
        top.setPadding(new Insets(10));
        top.setSpacing(8);
        top.setAlignment(Pos.CENTER);
        
        Label greeting = new Label("Welcome, ");
        top.getChildren().add(greeting);
        Label name = new Label(empl.getFirstName());
        top.getChildren().add(name);
        
        if(empl.getExperience().toString().equals("Administrator")) {
            Label admin = new Label("Administrator");
            top.getChildren().add(admin);
        }
        else {
            Label experience = new Label(empl.getExperience().toString());
            top.getChildren().add(experience);
            Label technology = new Label(empl.getTechnology().getName());
            top.getChildren().add(technology);
            
            if(!empl.getExperience().toString().equals("Manager")) {
                Label developer = new Label("Developer");
                top.getChildren().add(developer);
            }
            
            if(empl.getTeam() != null) {
                Label in = new Label("in");
                top.getChildren().add(in);
                Label teamName = new Label(empl.getTeam().getName());
                top.getChildren().add(teamName);
            }
            
        }
    }
    
    private void initiateBottom() {
        bottom = new VBox();
        bottom.setPadding(new Insets(10));
        bottom.setSpacing(8);
        bottom.setAlignment(Pos.CENTER);
        
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        
        Label dayName = new Label(simpleDateFormat.format(date));
        
        simpleDateFormat.applyPattern("d MMMM");
        Label dayAndMonth = new Label(simpleDateFormat.format(date));
        
        simpleDateFormat.applyPattern("YYYY");
        Label year = new Label(simpleDateFormat.format(date));
        
        bottom.getChildren().add(dayName);
        bottom.getChildren().add(dayAndMonth);
        bottom.getChildren().add(year);
    }
    
    private void initiateThis() {
        BorderPane.setMargin(this, new Insets(12,12,12,12));
        this.setTop(top);
        this.setBottom(bottom);
    }

    //================================================================================
    // Accessors
    //================================================================================
}
