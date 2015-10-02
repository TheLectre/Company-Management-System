package abstract_dao;

import business_logic.Employee;
import java.util.List;

public interface EmployeeDAO extends BaseDAO<Employee>  {
    public Employee getItemByLogin(String login);
    public List<Employee> getAllOfTeamID(int ID);
    public List<Employee> getAllTeamed();
}
