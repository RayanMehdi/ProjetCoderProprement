package fr.groupetroj.iem.sharebutton.data.manager;

/**
 * Created by iem on 08/12/2017.
 */

public class ComicsCreatorsManager {
    private ComicsCreator comicsCreator;


    public ComicsCreatorsManager() {
    }

    public String getComicsCreatorName() {
        return comicsCreator.getName();
    }

    public String getComicsCreatorRole() {
        return comicsCreator.getRole();
    }
}
