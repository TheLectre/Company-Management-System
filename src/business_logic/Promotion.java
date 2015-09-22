package business_logic;


public class Promotion {
    //================================================================================
    // Fields
    //================================================================================

    private int id;
    private int employee_id;
    private int newSalary;
    private Experience newExperience;
    private String message;
    
    //================================================================================
    // Constructors
    //================================================================================

    public Promotion(int employee_id, int newSalary, Experience newExperience, String message) {
        this.employee_id = employee_id;
        this.newSalary = newSalary;
        this.newExperience = newExperience;
        this.message = message;
    }

    public Promotion(int id, int employee_id, int newSalary, String newExperience,  String message) {
        this.id = id;
        this.employee_id = employee_id;
        this.newSalary = newSalary;
        this.message = message;
        
        if(newExperience != null) {
            convertExperience(newExperience);
        }
    }
    
    public Promotion(int employee_id, String newExperience, int newSalary, String message) {
        this.employee_id = employee_id;
        this.newSalary = newSalary;
        this.message = message;
        
        if(newExperience != null) {
            convertExperience(newExperience);
        }
    }
    
    //================================================================================
    // Methods
    //================================================================================

    private void convertExperience(String experience) {
         switch(experience) {
            case "Junior": this.newExperience = Experience.JUNIOR; break;
            case "Regular": this.newExperience = Experience.REGULAR; break;
            case "Senior": this.newExperience = Experience.SENIOR; break;
            case "Manager": this.newExperience = Experience.MANAGER; break;
            case "Administrator": this.newExperience = Experience.ADMINISTRATOR; break;
        }
    }

    //================================================================================
    // Accessors
    //================================================================================

    public int getID() {
        return id;
    }

    public int getEmployeeID() {
        return employee_id;
    }

    public int getNewSalary() {
        return newSalary;
    }

    public Experience getNewExperience() {
        return newExperience;
    }

    public String getMessage() {
        return message;
    }
}
