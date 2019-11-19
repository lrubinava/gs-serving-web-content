package hello;

import java.util.ArrayList;
import java.util.List;

public class BugCreation {

    private List<Bug> bugsList;

    public BugCreation() {
        this.bugsList = new ArrayList<>();
    }

    public BugCreation(List<Bug> bugsList) {
        this.bugsList = bugsList;
    }

    public List<Bug> getBugsList() {
        return bugsList;
    }

    public void setBugsList(List<Bug> bug) {
        this.bugsList = bugsList;
    }

    public void addBug(Bug bug) {
        this.bugsList.add(bug);
    }

}
