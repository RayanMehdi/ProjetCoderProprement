package fr.groupetroj.iem.projectcoderproprement.data.manager;

import android.content.res.Resources;

import java.util.ArrayList;

import fr.groupetroj.iem.projectcoderproprement.R;
import fr.groupetroj.iem.projectcoderproprement.data.model.Comics;
import fr.groupetroj.iem.projectcoderproprement.data.model.ComicsCreators;

/**
 * Created by iem on 08/12/2017.
 */

public class ComicsManager {
    // variable de classe privée
    private Comics currentComics;
    private ArrayList<Comics> listComics;

    // constructeur public
    public ComicsManager() {
    }

    public void setCurrentComics(Comics currentComics) {
        this.currentComics = currentComics;
    }

    public void setListComics(ArrayList<Comics> listComics) {
        this.listComics = listComics;
    }

    public String getCurrentComicsCreators(){
        String textToReturn = "";
        for(int position =0; position<currentComics.getCreators().size(); position++) {
            if (position > 0) {
                textToReturn += "\n";
            }
            textToReturn += currentComics.getCreators().get(position).getName() + " - " + currentComics.getCreators().get(position).getRole();
        }
        return textToReturn;
    }

    public String getCurrentComicsInformations(){
        String textToReturn = "";
        textToReturn += currentComics.getDate() + "\n";
        textToReturn += currentComics.getPrice() + " , " + currentComics.getPageCount() + " - " + currentComics.getDiamondCode();

        return textToReturn;
    }

    public ArrayList<Comics> getListComics() {
        return listComics;
    }

    public Comics getCurrentComics() {
        return currentComics;
    }

    public int getCurrentComicsIssueNumber() {
        return currentComics.getIssueNumber();
    }

    public int getCurrentComicsPageCount() {
        return currentComics.getPageCount();
    }

    public String getCurrentComicsTitle() {
        return currentComics.getTitle();
    }

    public String getCurrentComicsDescription() {
        return currentComics.getDescription();
    }

    public String getCurrentComicsDiamondCode() {
        return currentComics.getDiamondCode();
    }

    public String getCurrentComicsDate() {
        return currentComics.getDate();
    }

    public String getCurrentComicsImageUrl() {
        return currentComics.getImageUrl();
    }

    public double getComicsPrice() {
        return currentComics.getPrice();
    }

    public ArrayList<ComicsCreators> getComicsCreators() {
        return currentComics.getCreators();
    }
}
