package abstract_dao;

import business_logic.Employee;

public interface EmployeeDAO extends BaseDAO<Employee>  {
    public Employee getItemByLogin(String login);
}
