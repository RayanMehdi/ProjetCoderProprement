package fr.groupetroj.iem.projectcoderproprement.data.manager;

import java.util.ArrayList;

import fr.groupetroj.iem.projectcoderproprement.data.model.Comics;
import fr.groupetroj.iem.projectcoderproprement.data.model.ComicsCreators;

/**
 * Created by iem on 08/12/2017.
 */

public class ComicsManager {
    // variable de classe privée
    private Comics comics;

    // constructeur public
    public ComicsManager() {
    }

    public int getComicsId() {
        return comics.getId();
    }

    public int getComicsIssueNumber() {
        return comics.getIssueNumber();
    }

    public int getComicsPageCount() {
        return comics.getPageCount();
    }

    public String getComicsTitle() {
        return comics.getTitle();
    }

    public String getComicsDescription() {
        return comics.getDescription();
    }

    public String getComicsDiamondCode() {
        return comics.getDiamondCode();
    }

    public String getComicsDate() {
        return comics.getDate();
    }

    public String getComicsImageUrl() {
        return comics.getImageUrl();
    }

    public double getComicsPrice() {
        return comics.getPrice();
    }

    public ArrayList<ComicsCreators> getComicsCreators() {
        return comics.getCreators();
    }
}
