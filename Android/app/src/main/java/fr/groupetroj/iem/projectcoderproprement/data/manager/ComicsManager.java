package fr.groupetroj.iem.sharebutton.data.manager;

import fr.groupetroj.iem.sharebutton.data.model;

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

    public ArrayList<ComicsCreator> getComicsCreators() {
        return comics.getCreators();
    }
}
