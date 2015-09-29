package business_logic;

import java.sql.Timestamp;


public class Message {
    //================================================================================
    // Fields
    //================================================================================
    private int id;
    private String topic;
    private String text;
    private int senderID;
    private MessageType messageType;
    private Integer employeeReceiverID;
    private Integer teamReceiverID;
    private Timestamp timeStamp;
    
    //================================================================================
    // Constructors
    //================================================================================
   
    //receiving, this is not in use at the moment
    public Message(int id, String topic, String text, int senderID, String messageType, Integer employeeReceiverID, Integer teamReceiverID, Timestamp timeStamp) {
        this.id = id;
        this.topic = topic;
        this.text = text;
        this.senderID = senderID;
        this.employeeReceiverID = employeeReceiverID;
        this.teamReceiverID = teamReceiverID;
        this.timeStamp = timeStamp;
        
        convertMessageType(messageType);
    }
    
    //receiving easy way

    public Message(int id, String topic, String text, int senderID, String messageType, Timestamp time_stamp) {
        this.id = id;
        this.topic = topic;
        this.text = text;
        this.senderID = senderID;
        this.timeStamp = time_stamp;
        
        convertMessageType(messageType);
    }
    
    
    //creating
    public Message(String topic, String text, int senderID, String messageType, Integer employeeReceiverID, Integer teamReceiverID, Timestamp time_stamp) {
        this.topic = topic;
        this.text = text;
        this.senderID = senderID;
        this.employeeReceiverID = employeeReceiverID;
        this.teamReceiverID = teamReceiverID;
        this.timeStamp = time_stamp;
        
        convertMessageType(messageType);
    }
    
    
    
    
    //================================================================================
    // Methods
    //================================================================================
    private void convertMessageType(String messageType) {
        switch(messageType) {
            case "Company member" : this.messageType = MessageType.EMPLOYEE; break;
            case "Team": this.messageType = MessageType.TEAM; break;
            case "All": this.messageType = MessageType.ALL; break;
            default: System.err.println("Wrong message type. You fkd up somewhere.");
        }
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", topic=" + topic + ", text=" + text + ", senderID=" + senderID + ", messageType=" + messageType + ", employeeReceiverID=" + employeeReceiverID + ", teamReceiverID=" + teamReceiverID + ", time_stamp=" + timeStamp + '}';
    }
    
    //================================================================================
    // Accessors
    //================================================================================

    public int getID() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getSenderID() {
        return senderID;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public Integer getEmployeeReceiverID() {
        return employeeReceiverID != null ? employeeReceiverID : null; 
    }

    public Integer getTeamReceiverID() {
        return teamReceiverID != null ? teamReceiverID : null;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public String getTopic() {
        return topic;
    }

    
}
