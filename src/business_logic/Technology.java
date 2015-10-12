package business_logic;

public class Technology {

    //================================================================================
    // Fields
    //================================================================================
    private int id;
    private String name;

    //================================================================================
    // Constructors
    //================================================================================
    public Technology(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Technology(String name) {
        this.name = name;
    }
    

    //================================================================================
    // Methods
    //================================================================================

    @Override
    public String toString() {
        return "name";
    }
    
    @Override
    public boolean equals(Object obj) {
        Technology temp;
        try {
            temp = (Technology)obj;
        }
        catch(Exception e) {
            return false;
        }
        return this.getName().equals(temp.getName());
    }
    
    //================================================================================
    // Accessors
    //================================================================================
    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }
}
