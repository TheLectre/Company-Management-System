package abstract_dao;

import business_logic.Message;

public interface MessageDAO extends BaseDAO<Message> { 
    public Message getItemByReceiver(int empl_id, int team_id);
}
