package database_handling;

import abstract_dao.EmployeeDAO;
import business_logic.Employee;
import business_logic.Experience;
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

        parameters.add(item.getTeam() == null ? null : item.getTeam().getID());

        parameters.add(item.getLogin());
        parameters.add(item.getPassword());
        parameters.add(item.isAccepted());
        dbConnector.sendQuery(sqlReader.getQuery("add"), parameters);
    }

    @Override
    public void updateItem(Employee item) {
        if (item.getID() == 0) {
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

        parameters.add(item.getTeam() == null ? null : item.getTeam().getID());

        parameters.add(item.getPassword());
        parameters.add(item.isAccepted());
        parameters.add(item.getID());

        dbConnector.sendQuery(sqlReader.getQuery("update"), parameters);
    }

    @Override
    public void updateItemTeam(int empl_id, Integer team_id) {
        ArrayList parameters = new ArrayList();
        //remember, inverted order
        parameters.add(team_id == null ? null : team_id);
        parameters.add(empl_id);

        dbConnector.sendQuery(sqlReader.getQuery("update_team"), parameters);
    }

    @Override
    public void updateAccepted(int empl_id) {
        ArrayList parameters = new ArrayList();
        parameters.add(empl_id);
        
        dbConnector.sendQuery(sqlReader.getQuery("update_accepted"), parameters);
    }
    
    @Override
    public int getNumberOfApplies() {
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get_number_of_applies")).get();
        try {
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
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
            if (rs.getString("team_id") == null) {
                return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), new Technology(rs.getInt(6), rs.getString(10)), null, login, rs.getString(8), rs.getBoolean(9));
            } else {
                Technology technology = new Technology(rs.getInt(6), rs.getString(10));
                return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), technology, new Team(rs.getInt(7), rs.getString(11), technology), login, rs.getString(8), rs.getBoolean(9));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Employee getNotAccepted() {
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get_one_not_accepted")).get();
        try {
            rs.next();
            return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), new Technology(rs.getInt(6), rs.getString(7)));
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSQL.class.getName()).log(Level.SEVERE, null, ex);
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
            if (rs.getString("team_id") == null) {
                return new Employee(id, rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), new Technology(rs.getInt(5), rs.getString(10)), null, rs.getString(7), rs.getString(8), rs.getBoolean(9));
            } else {
                Technology technology = new Technology(rs.getInt(5), rs.getString(10));
                return new Employee(id, rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), technology, new Team(rs.getInt(6), rs.getString(11), technology), rs.getString(7), rs.getString(8), rs.getBoolean(9));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Employee> getAllOfTeamID(int teamID) {
        List<Employee> employees = new ArrayList<>();
        ArrayList parameters = new ArrayList();
        parameters.add(teamID);
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get_all_of_team_id"), parameters).get();
        try {
            while (rs.next()) {
                employees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }

    @Override
    public List<Employee> getAllTeamed() {
        List<Employee> employees = new ArrayList<>();
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get_all_teamed")).get();
        try {
            while (rs.next()) {
                employees.add(new Employee(rs.getString(1), rs.getInt(2), new Team(rs.getInt(3))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employees;
    }

    @Override
    public List<Employee> getAllTeamFreeOfTechnologyID(int technology_id) {
        ArrayList parameters = new ArrayList();
        parameters.add(technology_id);

        List<Employee> employees = new ArrayList<>();
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get_team_free_of_technology"), parameters).get();
        try {
            while (rs.next()) {
                employees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }

    //accepted employees only
    @Override
    public List<Employee> getAll() {
        ArrayList parameters = new ArrayList();
        parameters.add(true);
        List<Employee> employees = new ArrayList<>();
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get_all"), parameters).get();
        try {
            while (rs.next()) {
                //team may be null, TODO
                Technology technology = new Technology(rs.getInt(6), rs.getString(11));
                Team team = new Team(rs.getInt(7), rs.getString(12), technology);
                employees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), technology, team, rs.getString(8), rs.getString(9), rs.getBoolean(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employees;
    }

    @Override
    public List<Employee> getAllNotAccepted() {
        ArrayList parameters = new ArrayList();
        parameters.add(false);
        List<Employee> employees = new ArrayList<>();
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get_all"), parameters).get();
        try {
            while (rs.next()) {
                Technology technology = new Technology(rs.getInt(6), rs.getString(11));
                employees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), technology, null, rs.getString(8), rs.getString(9), rs.getBoolean(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employees;
    }

    @Override
    public List<Integer> getSalariesOfAll(Experience exp) {
        ArrayList parameters = new ArrayList();
        parameters.add(exp != null ? exp.toString() : null);
        List<Integer> salaries = new ArrayList<>();
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get_salaries_of_all"), parameters).get();
        try {
            while (rs.next()) {
                salaries.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salaries;
    }

    @Override
    public List<Integer> getSalariesOfTechnology(int technology_id, Experience exp) {
        ArrayList parameters = new ArrayList();
        parameters.add(technology_id);
        parameters.add(exp != null ? exp.toString() : null);
        List<Integer> salaries = new ArrayList<>();
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get_salaries_of_technology"), parameters).get();
        try {
            while (rs.next()) {
                salaries.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salaries;
    }

    @Override
    public List<Integer> getSalariesOfTeam(int team_id, Experience exp) {
        ArrayList parameters = new ArrayList();
        parameters.add(team_id);
        parameters.add(exp != null ? exp.toString() : null);
        List<Integer> salaries = new ArrayList<>();
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get_salaries_of_team"), parameters).get();
        try {
            while (rs.next()) {
                salaries.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salaries;
    }
    //================================================================================
    // Accessors
    //================================================================================
}
