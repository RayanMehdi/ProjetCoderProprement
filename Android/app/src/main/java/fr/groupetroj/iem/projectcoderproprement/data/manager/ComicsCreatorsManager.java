package fr.groupetroj.iem.projectcoderproprement.data.manager;

import fr.groupetroj.iem.projectcoderproprement.data.model.ComicsCreator;

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
