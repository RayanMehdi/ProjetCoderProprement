package fr.groupetroj.iem.projectcoderproprement.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.groupetroj.iem.projectcoderproprement.ComicsApplication;
import fr.groupetroj.iem.projectcoderproprement.R;
import fr.groupetroj.iem.projectcoderproprement.data.model.Comics;
import fr.groupetroj.iem.projectcoderproprement.ui.presenter.ComicsDetailsPresenter;
import fr.groupetroj.iem.projectcoderproprement.ui.view.ComicsDetailsView;

public class ComicsDetailsActivity extends AppCompatActivity implements ComicsDetailsView{

    TextView textView_title;
    TextView textView_synopsis;
    TextView textView_credits;
    TextView textView_information;
    ImageView imageView;

    ComicsDetailsPresenter comicsDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics_details);

        initViews();
        initializeInjection();
        comicsDetailsPresenter.updateView();

    }

    private void initViews(){
        textView_title = (TextView) findViewById(R.id.comicsDetails_title_textView);
        textView_synopsis = (TextView) findViewById(R.id.comicsDetails_description_textView);
        textView_credits = (TextView) findViewById(R.id.comicDetails_credits_textView);
        textView_information = (TextView) findViewById(R.id.comicsDetails_informations_textView);
        imageView = (ImageView) findViewById(R.id.comicsDetails_image);

    }

    @Override
    public void update(Comics currentComics) {
        textView_title.setText(getString(R.string.comics_detail_page_title) + " : " + currentComics.getTitle());
        Picasso.with(this.getApplicationContext()).load(currentComics.getImageUrl()).into(imageView);
        textView_synopsis.setText(getString(R.string.comics_detail_page_synopsis) + " " + currentComics.getDescription());
        textView_credits.setText(getString(R.string.comics_detail_page_creators) + "\n" + ComicsApplication.application().getComicsManager().getCurrentComicsCreators());
        textView_information.setText(getString(R.string.comics_detail_page_informations) + " : \n" + ComicsApplication.application().getComicsManager().getCurrentComicsInformations());
    }

    private void initializeInjection(){
        this.comicsDetailsPresenter = new ComicsDetailsPresenter(ComicsApplication.application().getComicsManager(), this, this);
    }
}
