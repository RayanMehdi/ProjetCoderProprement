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
    }

    public void initviews(){
        listView_comics = (ListView) findViewById(R.id.listView);

        //Création de la ArrayList qui nous permettra de remplir la listView
        listComics = new ArrayList<Comics>();

        comicsListAdapter = new ComicsListAdapter(listComics, this.getBaseContext());

        //Enfin on met un écouteur d'évènement sur notre listView
        listView_comics.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Comics currentComics = (Comics) listView_comics.getItemAtPosition(position);
                Intent intent = new Intent(ComicsListActivity.this, ComicsDetailsActivity.class);
                ComicsApplication.application().getComicsManager().setCurrentComics(currentComics);
                startActivity(intent);
            }
        });

        listView_comics.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return true;
            }
        });
    }

    private void initializeInjection(){
        this.comicsListPresenter = new ComicsListPresenter(ComicsApplication.application().getComicsManager(), this, this);
    }
}
