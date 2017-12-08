package fr.groupetroj.iem.projectcoderproprement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import fr.groupetroj.iem.projectcoderproprement.data.model.AsyncTaskFileParsing;
import fr.groupetroj.iem.projectcoderproprement.data.model.Comics;

public class HomePageActivity extends AppCompatActivity {
    ArrayList<Comics> listItem;
   // MyAdapter mSchedule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        /*listItem = new ArrayList<Comics>();

        mSchedule = new MyAdapter (listItem,this.getBaseContext());
        //On attribut à notre listView l'adapter que l'on vient de créer
        //maListViewPerso.setAdapter(mSchedule);

        new AsyncTaskFileParsing().execute(listItem, mSchedule, "sample-ok.json");*/


    }
}
