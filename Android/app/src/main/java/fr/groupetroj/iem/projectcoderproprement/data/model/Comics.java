package fr.groupetroj.iem.projectcoderproprement.data.model;

//import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Created by iem on 17/11/2017.
 */

public class Comics implements Serializable{
    private final int id, issueNumber, pageCount;
    private final String title, description, diamondCode, date;
    //@SerializedName("image")
    private final String imageUrl;
    private final double price;
    private final ArrayList<ComicsCreators> creators;

    public Comics() {
        id = 0;
        issueNumber = 0;
        pageCount = 0;
        title = "";
        description = "";
        diamondCode = "";
        date = "2017-10-25T00:00:00-0400";
        imageUrl = "";
        price = 0.00;
        creators= new ArrayList<ComicsCreators>();
        creators.add(new ComicsCreators("James Smith", "writer"));

    }

    public Comics(int id, int issueNumber, int pageCount, String title, String description, String diamondCode, String date, String imageUrl, double price, ArrayList<ComicsCreators> creators) {
        this.id = id;
        this.issueNumber = issueNumber;
        this.pageCount = pageCount;
        this.title = title;
        this.description = description;
        this.diamondCode = diamondCode;
        this.date = date;
        this.imageUrl = imageUrl;
        this.price = price;
        this.creators = creators;
    }

    public int getId() {
        return id;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public String getDate() {
        return date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public ArrayList<ComicsCreators> getCreators() {
        return creators;
    }
}