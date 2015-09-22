package database_handling;

import abstract_dao.MessageDAO;
import business_logic.Message;
import business_logic.MessageType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MessageSQL extends BaseSQL implements MessageDAO{

    
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
    public void addItem(Message item) {
        System.out.println(item);
        ArrayList parameters = new ArrayList();
        parameters.add(item.getTopic());
        parameters.add(item.getText());
        parameters.add(item.getSenderID());
        parameters.add(item.getMessageType().toString());
        parameters.add(item.getEmployeeReceiverID());
        parameters.add(item.getTeamReceiverID());
        parameters.add(item.getTime_stamp());
        
        dbConnector.sendQuery(sqlReader.getQuery("add"), parameters);
    }

    @Override
    public void updateItem(Message item) {
        ArrayList parameters = new ArrayList();
        parameters.add(item.getEmployeeReceiverID());
        parameters.add(item.getTeamReceiverID());
        
        if(item.getID() == 0) {
            throw new IllegalArgumentException() {
                @Override
                public String getMessage() {
                    return "Message object needs to have id to be updated.";
                }
            };
        }
        
        dbConnector.sendQuery(sqlReader.getQuery("update"), parameters);
    }
    
    @Override
    public void removeItem(int pKey) {
       ArrayList parameters = new ArrayList();
       parameters.add(pKey);
       dbConnector.sendQuery(sqlReader.getQuery("remove"), parameters);
    }

    @Override
    public Message getItemByID(int id) {
        ArrayList parameters = new ArrayList();
        parameters.add(id);
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get"), parameters).get();
        try {
            rs.next();
            return new Message(id, rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getTimestamp(7));
        } catch (SQLException ex) {
            Logger.getLogger(MessageSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public Message getItemByReceiver(int empl_id, int team_id) {
        ArrayList parameters = new ArrayList();
        parameters.add(empl_id);
        parameters.add(team_id);
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get_by_receiver"), parameters).get();
        try {
            rs.next();
            return new Message(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getTimestamp(5));
        } catch (SQLException ex) {
            Logger.getLogger(MessageSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public List<Message> getAll() {
        List<Message> messages = new ArrayList<>();
        ResultSet rs = dbConnector.sendQuery(sqlReader.getQuery("get_all")).get();
        try {
            while(rs.next()) {
                messages.add(new Message(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getTimestamp(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messages;
    }

    //================================================================================
    // Accessors
    //================================================================================
}
