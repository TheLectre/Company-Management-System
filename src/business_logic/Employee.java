package business_logic;

public class Employee {
    //================================================================================
    // Fields
    //================================================================================
    private int id;
    private String firstName;
    private String lastName;
    private Experience experience;
    private int salary;
    private Technology technology;
    private Team team;
    private String login;
    private String password;
    private boolean accepted;

    //================================================================================
    // Constructors
    //================================================================================
    public Employee(int id, String firstName, String lastName, String experience, int salary, Technology technology, Team team, String login, String password, boolean accepted) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.technology = technology;
        this.team = team;
        this.login = login;
        this.password = password;
        this.accepted = accepted;
        
        convertExperience(experience);
    }

    public Employee(String firstName, String lastName, Experience experience, int salary, Technology technology, String login, String password,  boolean accepted) {
        this.login = login;
        this.lastName = lastName;
        this.experience = experience;
        this.salary = salary;
        this.technology = technology;
        this.password = password;
        this.firstName = firstName;
        this.accepted = accepted;     
    }

    public Employee(String firstName, String lastName, String experience, int salary, Technology technology, Team team, String login, String password, boolean accepted) {
        this.firstName = firstName;
        this.lastName = lastName; 
        this.salary = salary;
        this.technology = technology;
        this.team = team;
        this.login = login;
        this.password = password;
        this.accepted = accepted;
        
        convertExperience(experience);
    }

    //================================================================================
    // Methods
    //================================================================================
    private void convertExperience(String experience) {
         switch(experience) {
            case "Junior": this.experience = Experience.JUNIOR; break;
            case "Regular": this.experience = Experience.REGULAR; break;
            case "Senior": this.experience = Experience.SENIOR; break;
            case "Manager": this.experience = Experience.MANAGER; break;
            case "Administrator": this.experience = Experience.ADMINISTRATOR; break;
        }
    }
    
    public void addToTeam(Team team) throws Exception {
        if (this.team == null) {
            this.team = team;
        } 
        else {
            throw new Exception() {
                @Override
                public String getMessage() {
                    return "Employee already in team";
                }
            };
        }
    }

    @Override
    public String toString() {
        return "Employee{" + "ID: " + id + ", firstName=" + firstName + ", lastName=" + lastName + ", experience=" + experience + ", salary=" + salary + ", technology=" + technology + ", team=" + team + ", login=" + login + ", password=" + password + ", accepted=" + accepted + '}';
    }
    
    //================================================================================
    // Accessors
    //================================================================================
    public int getID() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Experience getExperience() {
        return experience;
    }

    public int getSalary() {
        return salary;
    }

    public Technology getTechnology() {
        return technology;
    }

    public Team getTeam() {
        return team;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
    
        
}
