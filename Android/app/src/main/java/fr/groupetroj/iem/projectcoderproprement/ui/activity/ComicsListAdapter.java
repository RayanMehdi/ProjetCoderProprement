package fr.groupetroj.iem.projectcoderproprement.ui.activity;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import fr.groupetroj.iem.projectcoderproprement.data.model.Comics;
import fr.groupetroj.iem.projectcoderproprement.R;

/**
 * Created by iem on 08/12/2017.
 */

public class ComicsListAdapter extends BaseAdapter {

    ArrayList<Comics> listItem= new ArrayList<Comics>();
    Context context;
    ConstraintLayout constraintLayout;

    public ComicsListAdapter(ArrayList<Comics> listItem, Context context) {
        this.listItem = listItem;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        //(1) : Réutilisation des layouts
        LayoutInflater mInflater = LayoutInflater.from(context);
        if (convertView == null) {
            //Initialisation de notre item à partir du  layout XML "activity_list_comics_item.xml"
            constraintLayout = (ConstraintLayout) mInflater.inflate(R.layout.activity_list_comics_item, parent, false);
        } else {
            constraintLayout = (ConstraintLayout) convertView;
        }

        //(2) : Récupération des TextView de notre layout
        TextView textView_title = (TextView) constraintLayout.findViewById(R.id.activity_list_comics_item_title_textView);
        TextView textView_date = (TextView) constraintLayout.findViewById(R.id.activity_list_comics_item_date_textView);
        TextView textView_pageCount = (TextView) constraintLayout.findViewById(R.id.activity_list_comics_item_page_count_textView);
        ImageView imageView = (ImageView) constraintLayout.findViewById(R.id.activity_list_comics_item_image);


        //(3) : mise à jour des widgets des elements de l'item

        textView_title.setText(listItem.get(position).getTitle());
        textView_date.setText(listItem.get(position).getDate());
        textView_pageCount.setText(Integer.toString(listItem.get(position).getPageCount()));

        Picasso.with(context).load(listItem.get(position).getImageUrl()).into(imageView);

        //On retourne l'item créé.
        return constraintLayout;
    }

    public ImageView getImg(){
        return (ImageView) constraintLayout.findViewById(R.id.activity_list_comics_item_image);
    }


}
