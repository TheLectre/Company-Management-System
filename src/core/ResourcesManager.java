package core;

import abstract_dao.EmployeeDAO;
import abstract_dao.MessageDAO;
import abstract_dao.PromotionDAO;
import abstract_dao.TeamDAO;
import abstract_dao.TechnologyDAO;
import business_logic.Employee;
import business_logic.Message;
import business_logic.Promotion;
import business_logic.Team;
import business_logic.Technology;
import database_handling.EmployeeSQL;
import database_handling.MessageSQL;
import database_handling.PromotionSQL;
import database_handling.TeamSQL;
import database_handling.TechnologySQL;
import java.util.ArrayList;
import java.util.List;



public class ResourcesManager {
    //================================================================================
    // Fields
    //================================================================================
    private EmployeeDAO empl;
    private MessageDAO msg;
    private TeamDAO tm;
    private TechnologyDAO tech;
    private PromotionDAO prom;
    

    //================================================================================
    // Constructors
    //================================================================================
    
    public ResourcesManager() {
        this.empl = new EmployeeSQL();
        this.msg = new MessageSQL();
        this.tm = new TeamSQL();
        this.tech = new TechnologySQL();
        this.prom = new PromotionSQL();
    }
    
    //================================================================================
    // Methods
    //================================================================================
    
        //================================================================================
        // Technology
        //================================================================================
    
            public void addNewTechnology(Technology technology) {
                tech.addItem(technology);
            }
            
            public void updateTechnology(Technology technology) {
                tech.updateItem(technology);
            }
            
            public void removeTechnology(int id) {
                tech.removeItem(id);
            }
            
            public int getTechnologyID(String name) {
                return tech.getID(name);
            }
            
            public Technology getTechnologyByID(int id) {
                return tech.getItemByID(id);
            }
            
            public List<Technology> getAllTechnologies() {
                return tech.getAll();
            }
    
        //================================================================================
        // Team
        //================================================================================
            
            public void addNewTeam(Team team) {
                tm.addItem(team);
            }
            
            public void updateTeam(Team team) {
                tm.addItem(team);
            }
            
            public void removeTeam(int id) {
                tm.removeItem(id);
            }
            
            public int getTeamID(String name) {
                return tm.getID(name);
            }
            
            public Team getTeamByID(int id) {
                return tm.getItemByID(id);
            }
            
            public List<Team> getAllTeams() {
                return tm.getAll();
            }
            
        //================================================================================
        // Employee
        //================================================================================
    
            public void addNewEmployee(Employee employee) {
                empl.addItem(employee);
            }
            
            public void updateEmployee(Employee employee) {
                empl.updateItem(employee);
            }
            
            public void removeEmployee(int id) {
                empl.removeItem(id);
            }
            
            public Employee getEmployeeByLogin(String login) {
                return empl.getItemByLogin(login);
            }
            
            public Employee getEmployeeByID(int id) {
                return empl.getItemByID(id);
            }
            
            public List<Employee> getAllEmployees() {
                return empl.getAll();
            }
            
        //================================================================================
        // Message
        //================================================================================
            
            public void addNewMessage(Message message) {
                msg.addItem(message);
            }
            
            public void updateMessage(Message message) {
                msg.addItem(message);
            }
            
            public void removeMessage(int id) {
                msg.removeItem(id);
            }
            
            public Message getMessageByID(int id) {
                return msg.getItemByID(id);
            }
            
            public ArrayList<Message> getMessagesByReceiver(Integer employee_id, Integer team_id) {
                return msg.getItemsByReceiver(employee_id, team_id);
            }
            
            public List<Message> getAllMessages() {
                return msg.getAll();
            }
            
        //================================================================================
        // Promotion
        //================================================================================
            
            public void addNewPromotion(Promotion promotion) {
                prom.addItem(promotion);
            }
            
            public void updatePromotion(Promotion promotion) {
                prom.updateItem(promotion);
            }
            
            public void removePromotion(int id) {
                prom.removeItem(id);
            }
            
            public List<Promotion> getAllPromotions() {
                return prom.getAll();
            }
            
    //================================================================================
    // Accessors
    //================================================================================
}
