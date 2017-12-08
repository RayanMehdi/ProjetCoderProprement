package fr.groupetroj.iem.projectcoderproprement.ui.activity;
import fr.groupetroj.iem.projectcoderproprement.data.model.Comics;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import fr.groupetroj.iem.projectcoderproprement.R;

// TODO SUPPR CETTE LIGNE (POUR TEST)
import fr.groupetroj.iem.projectcoderproprement.data.model.ComicsCreators;

public class ListComicsActivity extends AppCompatActivity {
    ArrayList<Comics> comics;
    ListComicsAdapter listComicsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_comics);
        
        final ListView listView_comics = (ListView) findViewById(R.id.listView);
        final Context context = this;
        
        //Création de la ArrayList qui nous permettra de remplir la listView
        comics = new ArrayList<Comics>();

        listComicsAdapter = new ListComicsAdapter(comics, this.getBaseContext());

        //On attribut à notre listView l'adapter que l'on vient de créer
        listView_comics.setAdapter(listComicsAdapter);


        // TODO voir avec le manager
        //new Async().execute(comics, listComicsAdapter, "http://pokecards.local/index.php/Comics/list");

        //TODO ENLEVER CETTE PARTIE JUSTE POUR TEST
        ArrayList<ComicsCreators> creators = new ArrayList<ComicsCreators>();
        creators.add(new ComicsCreators());
        Comics comicsTest = new Comics(1, 1, 666, "Ceci est un titre", "Ceci est une description", "diamondCode", "2017-10-25T00:00:00-0400", "http://i.annihil.us/u/prod/marvel/i/mg/f/03/59e7b08528560.jpg", 9.99, creators);
        comics.add(comicsTest);

        //Enfin on met un écouteur d'évènement sur notre listView
        listView_comics.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //on récupère la HashMap contenant les infos de notre item (titre, description, img)
                Comics map = (Comics) listView_comics.getItemAtPosition(position);

                Context context = getApplicationContext();

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
