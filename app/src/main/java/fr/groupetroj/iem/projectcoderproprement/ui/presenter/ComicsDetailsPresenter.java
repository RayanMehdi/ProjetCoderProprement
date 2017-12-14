package fr.groupetroj.iem.projectcoderproprement.ui.presenter;

import android.content.Context;

import fr.groupetroj.iem.projectcoderproprement.data.manager.ComicsManager;
import fr.groupetroj.iem.projectcoderproprement.ui.activity.ComicsDetailsActivity;

/**
 * Created by iem on 14/12/2017.
 */

public class ComicsDetailsPresenter {
    private ComicsManager comicsManager;
    private Context context;
    private ComicsDetailsActivity comicsDetailsActivity;

    public ComicsDetailsPresenter(ComicsManager comicsManager, Context context, ComicsDetailsActivity comicsDetailsActivity) {
        this.comicsManager = comicsManager;
        this.context = context;
        this.comicsDetailsActivity = comicsDetailsActivity;
    }



}
