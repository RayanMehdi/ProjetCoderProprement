package fr.groupetroj.iem.projectcoderproprement.ui.presenter;

import android.content.Context;

import fr.groupetroj.iem.projectcoderproprement.data.manager.ComicsManager;
import fr.groupetroj.iem.projectcoderproprement.ui.view.ComicsListView;

/**
 * Created by iem on 14/12/2017.
 */

public class ComicsListPresenter {
    private final ComicsManager comicsManager;
    private final Context context;
    private final ComicsListView comicsListView;

    public ComicsListPresenter(ComicsManager comicsManager, Context context, ComicsListView comicsListView) {
        this.comicsManager = comicsManager;
        this.context = context;
        this.comicsListView = comicsListView;
    }
}
