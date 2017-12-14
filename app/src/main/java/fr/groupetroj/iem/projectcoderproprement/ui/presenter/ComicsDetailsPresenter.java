package fr.groupetroj.iem.projectcoderproprement.ui.presenter;

import android.content.Context;

import fr.groupetroj.iem.projectcoderproprement.data.manager.ComicsManager;
import fr.groupetroj.iem.projectcoderproprement.ui.activity.ComicsDetailsActivity;
import fr.groupetroj.iem.projectcoderproprement.ui.view.ComicsDetailsView;

/**
 * Created by iem on 14/12/2017.
 */

public class ComicsDetailsPresenter {
    private final ComicsManager comicsManager;
    private final Context context;
    private final ComicsDetailsView comicsDetailsView;

    public ComicsDetailsPresenter(ComicsManager comicsManager, Context context, ComicsDetailsView comicsDetailsView) {
        this.comicsManager = comicsManager;
        this.context = context;
        this.comicsDetailsView = comicsDetailsView;
    }

    public void updateView(){
        comicsDetailsView.update(comicsManager.getCurrentComics());
    }
}
