package database_handling;

import abstract_dao.TeamDAO;
import business_logic.Team;
import business_logic.Technology;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TeamSQL extends BaseSQL implements TeamDAO{

    
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
    public void addItem(Team item) {
        ArrayList parameters = new ArrayList();
        parameters.add(item.getName());
        parameters.add(item.getTechnology().getID());
        dbConnector.sendQuery(sqlReader.getQuery("add"), parameters);
    }

    @Override
    public void updateItem(Team item) {
        if(item.getID() == 0) {
            throw new IllegalArgumentException() {
                @Override
                public String getMessage() {
                    return "Team object needs to have id to be updated.";
                }
            };
        }
        
        ArrayList parameters = new ArrayList();
        parameters.add(item.getName());
        parameters.add(item.getTechnology().getID());
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
            Logger.getLogger(TeamSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Team getItemByID(int id) {
        ArrayList parameters = new ArrayList();
        parameters.add(id);
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get"), parameters).get();
        try {
            rs.next();
            return new Team(id, rs.getString("team.name"), new Technology(rs.getInt("technology.technology_id"), rs.getString("technology.name")));
        } catch (SQLException ex) {
            Logger.getLogger(TeamSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Team> getAll() {
        List<Team> teams = new ArrayList<>();
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get_all")).get();
        try {
            while(rs.next()) {
                teams.add(new Team(rs.getInt(1), rs.getString(2), new Technology(rs.getInt(3), rs.getString(4))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeamSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teams;
    }

    //================================================================================
    // Accessors
    //================================================================================
}
