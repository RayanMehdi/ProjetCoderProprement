package fr.groupetroj.iem.projectcoderproprement.data.model;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
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
    private MyAdapter adapter;
    @Override
    protected String doInBackground(Object... params) {
        listComics = (ArrayList<Comics>) params[0];
        String jsonRaw = this.jsonExtract((String) params[2]);

        array.addAll(this.Gonsreturn(jsonRaw));


        return "OK";

    }


    public ArrayList<Comics> Gonsreturn(String json)
    {

        Type collectionType = new TypeToken<Collection<Pokemon>>(){}.getType();
        return  (ArrayList<Pokemon>) new Gson().fromJson(json, collectionType);

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        adapter.notifyDataSetChanged();

    }

    public String jsonExtract(String URL){
        java.net.URL url = null;
        HttpURLConnection urlConnection = null;
        BufferedReader in = null;
        String textReturn = "";
        try {
            url = new URL(URL.toString());
            urlConnection = (HttpURLConnection) url.openConnection();
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                in = new BufferedReader(
                        new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
                String temp = "";
                while ((temp = in.readLine()) != null) {
                    textReturn += temp;
                }
                Log.d("POST",textReturn);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return textReturn;
    }
}
