package abstract_dao;

import business_logic.Message;
import java.util.ArrayList;

public interface MessageDAO extends BaseDAO<Message> { 
    public ArrayList<Message> getItemsByReceiver(Integer empl_id, Integer team_id);
}
