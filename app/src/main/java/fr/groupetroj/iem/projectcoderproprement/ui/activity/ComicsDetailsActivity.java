package fr.groupetroj.iem.projectcoderproprement.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.groupetroj.iem.projectcoderproprement.ComicsApplication;
import fr.groupetroj.iem.projectcoderproprement.R;
import fr.groupetroj.iem.projectcoderproprement.data.model.Comics;

public class ComicsDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics_details);

        TextView textView_title = (TextView) findViewById(R.id.comicsDetails_title_textView);
        TextView textView_synopsis = (TextView) findViewById(R.id.comicsDetails_description_textView);
        TextView textView_credits = (TextView) findViewById(R.id.comicDetails_credits_textView);
        TextView textView_information = (TextView) findViewById(R.id.comicsDetails_informations_textView);
        ImageView imageView = (ImageView) findViewById(R.id.comicsDetails_image);

        Comics currentComics = ComicsApplication.application().getComicsManager().getCurrentComics();

        textView_title.setText(getString(R.string.comics_detail_page_title) + " : " + currentComics.getTitle());
        Picasso.with(this.getApplicationContext()).load(currentComics.getImageUrl()).into(imageView);
        textView_synopsis.setText(getString(R.string.comics_detail_page_synopsis) + " " + currentComics.getDescription());
        textView_credits.setText(getString(R.string.comics_detail_page_creators) + "\n" + ComicsApplication.application().getComicsManager().getCurrentComicsCreators());
        textView_information.setText(getString(R.string.comics_detail_page_informations) + " : \n" + ComicsApplication.application().getComicsManager().getCurrentComicsInformations());
    }
}
