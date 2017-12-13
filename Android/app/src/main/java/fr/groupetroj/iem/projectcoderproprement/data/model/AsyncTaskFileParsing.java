package fr.groupetroj.iem.projectcoderproprement.data.model;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by iem on 17/11/2017.
 */

public class AsyncTaskFileParsing extends AsyncTask<Object, Void, String>{
    private ArrayList<Comics> listComics;
  //  private MyAdapter adapter;
    @Override
    protected String doInBackground(Object... params) {
        listComics = new ArrayList<Comics>();
        listComics = (ArrayList<Comics>) params[0];
        Log.d("POST", (String) params[2]);
        String jsonRaw = this.jsonExtract((String) params[2]);
        Log.d("POST", jsonRaw);
      //  adapter = (MyAdapter) params[1];
        try {
            listComics.addAll(this.Gonsreturn(jsonRaw));
        }catch (NullPointerException e){
            Log.d("POST","Le fichier n'existe pas ou n'est pas conforme");
        }



        return "OK";

    }


    public ArrayList<Comics> Gonsreturn(String json)
    {

        Type collectionType = new TypeToken<Collection<Comics>>(){}.getType();
        return  (ArrayList<Comics>) new Gson().fromJson(json, collectionType);

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
     //   adapter.notifyDataSetChanged();

    }

    public String jsonExtract(String filename){
        String textReturn = "";
        try {
            String temp;
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
                while ((temp = reader.readLine()) != null) {
                    textReturn += temp;
                }
                Log.d("POST",textReturn);



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e)

    {
        e.printStackTrace();
    }
        return textReturn;
    }
}
