package abstract_dao;

import business_logic.Employee;
import business_logic.Experience;
import java.util.List;

public interface EmployeeDAO extends BaseDAO<Employee> {

    public void updateItemTeam(int empl_id, Integer team_id);
    
    public void updateAccepted(int empl_id);

    public Employee getItemByLogin(String login);
    
    public Employee getNotAccepted();

    public List<Employee> getAllOfTeamID(int ID);

    public List<Employee> getAllTeamFreeOfTechnologyID(int technology_id);

    public List<Employee> getAllTeamed();
    
    public List<Employee> getAllNotAccepted();
    
    public int getNumberOfApplies();
    
    public List<Integer> getSalariesOfAll(Experience exp);
    
    public List<Integer> getSalariesOfTechnology(int technology_id, Experience exp);
    
    public List<Integer> getSalariesOfTeam(int team_id, Experience exp);
}
