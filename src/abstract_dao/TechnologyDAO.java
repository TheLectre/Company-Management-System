package abstract_dao;

import business_logic.Technology;


public interface TechnologyDAO extends BaseDAO<Technology> {
    public int getID(String name);
}
