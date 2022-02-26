package ff.CC2flaceliere.Data;

import ff.CC2flaceliere.model.Project;
import ff.CC2flaceliere.model.StatusProject;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ProjectsData {

    private static ArrayList<Project> listProjects = new ArrayList<>();

    public static Project setTradesmanToProject(int tradesmanID, int projectID){
        Project p = listProjects.stream().filter(c -> c.getId() == projectID).collect(Collectors.toList()).get(0);
        p.setStatus(StatusProject.WORKING);
        p.setTradesmanID(tradesmanID);
        return p;
    }
    public static void addProject(Project p){
        listProjects.add(p);
    }

    public static void endProject(int projectID){
        listProjects.stream().filter(c -> c.getId() == projectID && c.getStatus() == StatusProject.WORKING).collect(Collectors.toList()).get(0).setStatus(StatusProject.CLOSE);

    }

    public static ArrayList<Project> getListProjects() {
        return listProjects;
    }
}
