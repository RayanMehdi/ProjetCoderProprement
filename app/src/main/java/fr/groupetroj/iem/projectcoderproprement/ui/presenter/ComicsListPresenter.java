package fr.groupetroj.iem.projectcoderproprement.ui.presenter;

import android.content.Context;
import android.content.Intent;
import android.widget.ListView;

import java.util.ArrayList;

import fr.groupetroj.iem.projectcoderproprement.ComicsApplication;
import fr.groupetroj.iem.projectcoderproprement.data.manager.ComicsManager;
import fr.groupetroj.iem.projectcoderproprement.data.model.Comics;
import fr.groupetroj.iem.projectcoderproprement.ui.activity.ComicsDetailsActivity;
import fr.groupetroj.iem.projectcoderproprement.ui.activity.ComicsListActivity;
import fr.groupetroj.iem.projectcoderproprement.ui.activity.ComicsListAdapter;
import fr.groupetroj.iem.projectcoderproprement.ui.view.ComicsListView;

/**
 * Created by iem on 14/12/2017.
 */

public class ComicsListPresenter {
    private final ComicsManager comicsManager;
    private final Context context;
    private final ComicsListView comicsListView;
    private final ArrayList<Comics> listComics;
    private final ComicsListAdapter comicsListAdapter;

    public ComicsListPresenter(ComicsManager comicsManager, Context context, ComicsListView comicsListView) {
        this.comicsManager = comicsManager;
        this.context = context;
        this.comicsListView = comicsListView;
        listComics = new ArrayList<>();
        comicsListAdapter = new ComicsListAdapter(listComics, this.context);
    }

    public void updateView(){
        comicsListView.update(comicsListAdapter);
        ComicsApplication.application().getComicsManager().callAsyncTask(listComics,comicsListAdapter,context);
    }

    public void goToDetailActivity(ListView listView_comics, int position){
        Comics currentComics = (Comics) listView_comics.getItemAtPosition(position);
        Intent intent = new Intent(context, ComicsDetailsActivity.class);
        ComicsApplication.application().getComicsManager().setCurrentComics(currentComics);
        context.startActivity(intent);
    }
}
