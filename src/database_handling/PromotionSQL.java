package database_handling;

import abstract_dao.PromotionDAO;
import business_logic.Promotion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PromotionSQL extends BaseSQL implements PromotionDAO {

    
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
    public void addItem(Promotion item) {
        ArrayList parameters = new ArrayList();
        parameters.add(item.getEmployeeID());
        parameters.add(item.getNewSalary());
        parameters.add(item.getNewExperience().toString());
        parameters.add(item.getMessage());
        
        dbConnector.sendQuery(sqlReader.getQuery("add"), parameters);
    }

    @Override
    public void updateItem(Promotion item) throws IllegalArgumentException {
        ArrayList parameters = new ArrayList();
        parameters.add(item.getNewSalary());
        parameters.add(item.getNewExperience());
        parameters.add(item.getMessage());
        
        if(item.getID() == 0) {
            throw new IllegalArgumentException() {
                @Override
                public String getMessage() {
                    return "Message object needs to have id to be updated.";
                }
            };
        }
        
        dbConnector.sendQuery(sqlReader.getQuery("update"), parameters);
    }

    @Override
    public void removeItem(int pKey) {
        ArrayList parameters = new ArrayList();
        parameters.add(pKey);
        dbConnector.sendQuery(sqlReader.getQuery("remove"), parameters);
    }

    @Override
    public Promotion getItemByID(int id) {
        throw new UnsupportedOperationException("We don't need, we don't do."); 
    }


    @Override
    public List<Promotion> getAll() {
        List<Promotion> promotions = new ArrayList<>();
        
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get_all")).get();
        try {
            while(rs.next()) {
                promotions.add(new Promotion(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PromotionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return promotions;
    }

    //================================================================================
    // Accessors
    //================================================================================
}
