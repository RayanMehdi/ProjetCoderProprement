package fr.groupetroj.iem.projectcoderproprement.ui.activity;
import fr.groupetroj.iem.projectcoderproprement.ComicsApplication;
import fr.groupetroj.iem.projectcoderproprement.data.model.Comics;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import fr.groupetroj.iem.projectcoderproprement.R;
import fr.groupetroj.iem.projectcoderproprement.ui.presenter.ComicsListPresenter;
import fr.groupetroj.iem.projectcoderproprement.ui.view.ComicsListView;

public class ComicsListActivity extends AppCompatActivity implements ComicsListView{
    private ArrayList<Comics> listComics;
    private ComicsListAdapter comicsListAdapter;
    private ListView listView_comics;
    private ComicsListPresenter comicsListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_comics);
        initviews();
        initializeInjection();
        comicsListPresenter.updateView();
    }

    public void initviews(){
        listView_comics = (ListView) findViewById(R.id.listView);
    }

    private void initializeInjection(){
        this.comicsListPresenter = new ComicsListPresenter(ComicsApplication.application().getComicsManager(), this, this);
    }

    @Override
    public void update(ComicsListAdapter comicsListAdapter) {

        listView_comics.setAdapter(comicsListAdapter);

        //Enfin on met un écouteur d'évènement sur notre listView
        listView_comics.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                comicsListPresenter.goToDetailActivity(listView_comics, position);
            }
        });
    }
}
