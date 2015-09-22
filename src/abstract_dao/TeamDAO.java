package abstract_dao;

import business_logic.Team;

public interface TeamDAO extends BaseDAO<Team> {
    public int getID(String name);
}
