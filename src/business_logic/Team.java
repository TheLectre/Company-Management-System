package business_logic;

public class Team {

    //================================================================================
    // Fields
    //================================================================================
    private int id;
    private String name;
    private Technology technology;

    //================================================================================
    // Constructors
    //================================================================================
    public Team(int id, String name, Technology technology) {
        this.id = id;
        this.name = name;
        this.technology = technology;
    }

    public Team(String name, Technology technology) {
        this.name = name;
        this.technology = technology;
    }
    
    
    //================================================================================
    // Methods
    //================================================================================

    //================================================================================
    // Accessors
    //================================================================================

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Technology getTechnology() {
        return technology;
    }
    
}
