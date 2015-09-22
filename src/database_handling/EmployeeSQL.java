package database_handling;

import abstract_dao.EmployeeDAO;
import business_logic.Employee;
import business_logic.Team;
import business_logic.Technology;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeSQL extends BaseSQL implements EmployeeDAO {

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
    public void addItem(Employee item) {
        ArrayList parameters = new ArrayList();
        parameters.add(item.getFirstName());
        parameters.add(item.getLastName());
        parameters.add(item.getExperience().toString());
        parameters.add(item.getSalary());
        parameters.add(item.getTechnology().getID());

        if (item.getTeam() == null) {
            parameters.add(null);
        } else {
            parameters.add(item.getTeam().getID());
        }

        parameters.add(item.getLogin());
        parameters.add(item.getPassword());
        parameters.add(item.isAccepted());
        dbConnector.sendQuery(sqlReader.getQuery("add"), parameters);
    }

    @Override
    public void updateItem(Employee item) {
         if(item.getID() == 0) {
            throw new IllegalArgumentException() {
                @Override
                public String getMessage() {
                    return "Employee object needs to have id to be updated.";
                }
            };
        }
        
        ArrayList parameters = new ArrayList();
        parameters.add(item.getExperience().toString());
        parameters.add(item.getSalary());
        parameters.add(item.getTechnology().getID());

        if (item.getTeam() == null) {
            parameters.add(null);
        } else {
            parameters.add(item.getTeam().getID());
        }

        parameters.add(item.getPassword());
        parameters.add(item.isAccepted());
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
    public Employee getItemByLogin(String login) {
        ArrayList parameters = new ArrayList();
        parameters.add(login);
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get_by_login"), parameters).get();
        try {
            rs.next();
            if(rs.getString("team_id") == null) {
                return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), new Technology(rs.getInt(6), rs.getString(10)), null, login, rs.getString(8), rs.getBoolean(9));
            }
            else {
                Technology technology = new Technology(rs.getInt(6), rs.getString(10));
                return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), technology, new Team(rs.getInt(7), rs.getString(11), technology), login, rs.getString(8), rs.getBoolean(9));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(EmployeeSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Employee getItemByID(int id) {
        ArrayList parameters = new ArrayList();
        parameters.add(id);
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get"), parameters).get();
        try {
            rs.next();
            if(rs.getString("team_id") == null) {
                return new Employee(id, rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), new Technology(rs.getInt(5), rs.getString(10)), null, rs.getString(7), rs.getString(8), rs.getBoolean(9));
            }
            else {
                Technology technology = new Technology(rs.getInt(5), rs.getString(10));
                return new Employee(id, rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), technology, new Team(rs.getInt(6), rs.getString(11), technology), rs.getString(7), rs.getString(8), rs.getBoolean(9));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get_all")).get();
        try {
            while(rs.next()){
                if(rs.getInt("team_id") == 0) {
                    employees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), new Technology(rs.getInt(6), rs.getString(10)), null, rs.getString(8), rs.getString(9), rs.getBoolean(10)));
                }
                else {
                    Technology technology = new Technology(rs.getInt(6), rs.getString(11));
                    employees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), technology, new Team(rs.getInt(7), rs.getString(12), technology), rs.getString(8), rs.getString(9), rs.getBoolean(10)));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return employees;
    }
    //================================================================================
    // Accessors
    //================================================================================
}
