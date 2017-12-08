package fr.groupetroj.iem.projectcoderproprement.data.model;

/**
 * Created by iem on 17/11/2017.
 */

public class ComicsCreator {
    private final String name, role;

    public ComicsCreator(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public ComicsCreator() {
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
