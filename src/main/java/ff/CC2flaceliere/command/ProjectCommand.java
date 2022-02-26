package ff.CC2flaceliere.command;

import ff.CC2flaceliere.Data.ProjectsData;
import ff.CC2flaceliere.Data.tradesmanData;
import ff.CC2flaceliere.model.Project;

import java.util.stream.Collectors;

public final class ProjectCommand {
    private static final ProjectCommand INSTANCE = new ProjectCommand();

    private ProjectCommand() {
    }

    public static void assignTradesmanToProject(int tradesmanID, int projectID){
        Project p = ProjectsData.setTradesmanToProject(tradesmanID,projectID);
        tradesmanData.setTradesmanNotAvailable(tradesmanID);
    }

    public static void endProject(int projectID){
        ProjectsData.endProject(projectID);
        tradesmanData.setTradesmanAvailable(ProjectsData.getListProjects().stream().filter(c -> c.getId() == projectID).collect(Collectors.toList()).get(0).getTradesmanID());
    }
}
