package fr.groupetroj.iem.projectcoderproprement.data.model;

import fr.groupetroj.iem.projectcoderproprement.R;
import fr.groupetroj.iem.projectcoderproprement.ui.activity.ListComicsAdapter;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by iem on 17/11/2017.
 */

public class AsyncTaskFileParsing extends AsyncTask<Object, Void, String>{
    private ArrayList<Comics> listComics;
    private ListComicsAdapter listComicsAdapter;
    private Context context;
    @Override
    protected String doInBackground(Object... params) {
        listComics = new ArrayList<Comics>();
        listComics = (ArrayList<Comics>) params[0];
        context = (Context) params[3];

        String jsonRaw = this.jsonExtract((int) params[2]);

        listComicsAdapter = (ListComicsAdapter) params[1];
        try {
            listComics.addAll(this.Gonsreturn(jsonRaw));
        }catch (NullPointerException e){
            Log.d("POST","Le fichier n'existe pas ou n'est pas conforme");
        }



        return "OK";

    }


    public ArrayList<Comics> Gonsreturn(String json)
    {
        Gson gson = new GsonBuilder().create();
        Code_HTTP code_HTTP = gson.fromJson(json, Code_HTTP.class);

        if (code_HTTP.isSuccess()) {
            Type listType = new TypeToken<ArrayList<Comics>>(){}.getType();
            JsonParser p = new JsonParser();
            JsonElement jsonContainer  = p.parse(json);
            JsonElement jsonQuery = ((JsonObject) jsonContainer).get("results");
            listComics = gson.fromJson(jsonQuery, listType);
            return listComics;
        }
        else {
            Log.d("Error", "Code invalide");
            return new ArrayList<Comics>();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        listComicsAdapter.notifyDataSetChanged();

    }

    public String jsonExtract(int filename){
        String textReturn = "";
        try {
            String temp;
            InputStream is = context.getResources().openRawResource(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
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

class Code_HTTP{
    public int code;
    public Code_HTTP(int code) {
        this.code = code;
    }

    public boolean isSuccess(){
        return code == 200;
    }
}