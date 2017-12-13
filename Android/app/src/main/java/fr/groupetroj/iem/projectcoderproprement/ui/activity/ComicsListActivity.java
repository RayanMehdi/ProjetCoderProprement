package fr.groupetroj.iem.projectcoderproprement.ui.activity;
import fr.groupetroj.iem.projectcoderproprement.ComicsApplication;
import fr.groupetroj.iem.projectcoderproprement.data.model.Comics;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import fr.groupetroj.iem.projectcoderproprement.R;
import fr.groupetroj.iem.projectcoderproprement.data.model.AsyncTaskFileParsing;

public class ComicsListActivity extends AppCompatActivity {
    ArrayList<Comics> listComics;
    ComicsListAdapter comicsListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_comics);
        
        final ListView listView_comics = (ListView) findViewById(R.id.listView);
        final Context context = this;
        
        //Création de la ArrayList qui nous permettra de remplir la listView
        listComics = new ArrayList<Comics>();

        comicsListAdapter = new ComicsListAdapter(listComics, this.getBaseContext());

        //On attribut à notre listView l'adapter que l'on vient de créer
        listView_comics.setAdapter(comicsListAdapter);

        // TODO

            new AsyncTaskFileParsing().execute(listComics, comicsListAdapter, R.raw.sample_ok, this);


        //Enfin on met un écouteur d'évènement sur notre listView
        listView_comics.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Comics currentComics = (Comics) listView_comics.getItemAtPosition(position);
                Context context = getApplicationContext();
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
}
