package fr.groupetroj.iem.projectcoderproprement.data.model;

/**
 * Created by iem on 17/11/2017.
 */

public class ComicsCreators {
    private final String name, role;

    public ComicsCreators(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public ComicsCreators() {
        name = "";
        role = "";
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
