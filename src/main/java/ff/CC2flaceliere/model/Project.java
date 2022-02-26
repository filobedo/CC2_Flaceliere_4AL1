package ff.CC2flaceliere.model;

public class Project {

    private int id;
    private Skills skill;
    private String name;
    private int tradesmanID;
    private StatusProject status;

    public Project(int id, Skills skill, String name) {
        this.id = id;
        this.skill = skill;
        this.name = name;
        tradesmanID = 0;
        status = StatusProject.OPEN;
    }

    public int getId() {
        return id;
    }

    public Skills getSkill() {
        return skill;
    }

    public String getName() {
        return name;
    }

    public StatusProject getStatus() {
        return status;
    }

    public void setStatus(StatusProject status) {
        this.status = status;
    }


    public int getTradesmanID() {
        return tradesmanID;
    }

    public void setTradesmanID(int tradesmanID) {
        this.tradesmanID = tradesmanID;
    }
}
