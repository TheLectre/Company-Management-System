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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


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
        greeting.setTextFill(Color.DARKCYAN);
        greeting.setFont(Font.font(null, FontPosture.ITALIC, 16));
        top.getChildren().add(greeting);
        Label name = new Label(empl.getFirstName());
        name.setTextFill(Color.DARKCYAN);
        name.setFont(Font.font(null, FontPosture.ITALIC, 16));
        top.getChildren().add(name);
        
        if(empl.getExperience().toString().equals("Administrator")) {
            Label admin = new Label("Administrator");
            admin.setTextFill(Color.DARKCYAN);
            admin.setFont(Font.font(null, FontPosture.ITALIC, 16));
            top.getChildren().add(admin);
        }
        else {
            Label experience = new Label(empl.getExperience().toString());
            experience.setTextFill(Color.DARKCYAN);
            experience.setFont(Font.font(null, FontPosture.ITALIC, 16));
            top.getChildren().add(experience);
            Label technology = new Label(empl.getTechnology().getName());
            technology.setTextFill(Color.DARKCYAN);
            technology.setFont(Font.font(null, FontPosture.ITALIC, 16));
            top.getChildren().add(technology);
            
            if(!empl.getExperience().toString().equals("Manager")) {
                Label developer = new Label("Developer");
                developer.setTextFill(Color.DARKCYAN);
                developer.setFont(Font.font(null, FontPosture.ITALIC, 16));
                top.getChildren().add(developer);
            }
            
            if(empl.getTeam() != null) {
                Label in = new Label("in");
                in.setTextFill(Color.DARKCYAN);
                in.setFont(Font.font(null, FontPosture.ITALIC, 16));
                top.getChildren().add(in);
                Label teamName = new Label(empl.getTeam().getName());
                teamName.setTextFill(Color.DARKCYAN);
                teamName.setFont(Font.font(null, FontPosture.ITALIC, 16));
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
        dayName.setTextFill(Color.GOLDENROD);
        dayName.setFont(Font.font(null, FontPosture.ITALIC, 16));
        
        simpleDateFormat.applyPattern("d MMMM");
        Label dayAndMonth = new Label(simpleDateFormat.format(date));
        dayAndMonth.setTextFill(Color.GOLDENROD);
        dayAndMonth.setFont(Font.font(null, FontPosture.ITALIC, 16));
        
        simpleDateFormat.applyPattern("YYYY");
        Label year = new Label(simpleDateFormat.format(date));
        year.setTextFill(Color.GOLDENROD);
        year.setFont(Font.font(null, FontPosture.ITALIC, 16));
        
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
