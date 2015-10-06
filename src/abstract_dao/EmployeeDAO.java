package abstract_dao;

import business_logic.Employee;
import java.util.List;

public interface EmployeeDAO extends BaseDAO<Employee> {

    public void updateItemTeam(int empl_id, Integer team_id);

    public Employee getItemByLogin(String login);

    public List<Employee> getAllOfTeamID(int ID);

    public List<Employee> getAllTeamFreeOfTechnologyID(int technology_id);

    public List<Employee> getAllTeamed();
    
    public List<Integer> getSalariesOfAll();
    
    public List<Integer> getSalariesOfTechnology(int technology_id);
    
    public List<Integer> getSalariesOfTeam(int team_id);
}
