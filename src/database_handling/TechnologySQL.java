package database_handling;

import abstract_dao.TechnologyDAO;
import business_logic.Technology;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TechnologySQL extends BaseSQL implements TechnologyDAO {

    //================================================================================
    // Fields
    //================================================================================

    //================================================================================
    // Constructors
    //================================================================================

    
    //================================================================================
    // Methods
    //================================================================================

    @Override
    public void addItem(Technology item) {
        ArrayList parameters = new ArrayList();
        parameters.add(item.getName());
        dbConnector.sendQuery(sqlReader.getQuery("add"), parameters);
    }

    @Override
    public void updateItem(Technology item) throws IllegalArgumentException {
        if(item.getID() == 0) {
            throw new IllegalArgumentException() {
                @Override
                public String getMessage() {
                    return "Technology object needs to have id to be updated.";
                }
            };
        }
        
        ArrayList parameters = new ArrayList();
        parameters.add(item.getName());
        parameters.add(item.getID());
        dbConnector.sendQuery(sqlReader.getQuery("update"), parameters);
    }

    @Override
    public void removeItem(int pKey) {
        ArrayList parameters = new ArrayList();
        parameters.add(pKey);
        dbConnector.sendQuery(sqlReader.getQuery("remove"), parameters);
    }
    
    @Override
    public int getID(String name) {
        ArrayList parameters = new ArrayList();
        parameters.add(name);
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get_id"), parameters).get();
        try {
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(TechnologySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    @Override
    public Technology getItemByID(int id) {
        ArrayList parameters = new ArrayList();
        parameters.add(id);
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get"), parameters).get();
        try {
            rs.next();
            return new Technology(id, rs.getString(1));
        } catch (SQLException ex) {
            System.out.println("Exception while retrieving technology item. " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Technology> getAll() {
        List<Technology> technologies = new ArrayList<>();
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get_all")).get();
        try {
            while(rs.next()) {
                technologies.add(new Technology(rs.getInt(1), rs.getString(2)));
            }
            return technologies;
        } catch (SQLException ex) {
            Logger.getLogger(TechnologySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //================================================================================
    // Accessors
    //================================================================================
}
