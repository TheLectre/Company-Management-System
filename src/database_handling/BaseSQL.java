package database_handling;


public abstract class BaseSQL {
    //================================================================================
    // Fields
    //================================================================================
    
    protected SQLReader sqlReader;
    protected DataBaseConnector dbConnector;

    //================================================================================
    // Constructors
    //================================================================================

    public BaseSQL() {
        sqlReader = new SQLReader(generateQueryFileName());
        dbConnector = DataBaseConnector.getINSTANCE();
    }

    //================================================================================
    // Methods
    //================================================================================
    private String generateQueryFileName() {
        String tab[] = this.getClass().getName().split("\\.");
        return "src/queries/" + tab[tab.length-1] + "Queries.properties";
    }
    
    //================================================================================
    // Accessors
    //================================================================================
}