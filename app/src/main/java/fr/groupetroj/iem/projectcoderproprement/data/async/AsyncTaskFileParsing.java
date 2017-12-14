package fr.groupetroj.iem.projectcoderproprement.data.async;

import fr.groupetroj.iem.projectcoderproprement.R;
import fr.groupetroj.iem.projectcoderproprement.data.model.Comics;
import fr.groupetroj.iem.projectcoderproprement.ui.activity.ComicsListAdapter;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 * Created by iem on 17/11/2017.
 */

public class AsyncTaskFileParsing extends AsyncTask<Object, Void, String>{
    private ArrayList<Comics> listComics;
    private ComicsListAdapter comicsListAdapter;
    private Context context;
    @Override
    protected String doInBackground(Object... params) {
        listComics = new ArrayList<Comics>();
        listComics = (ArrayList<Comics>) params[0];
        context = (Context) params[3];

        String jsonRaw = this.jsonExtract((int) params[2]);

        comicsListAdapter = (ComicsListAdapter) params[1];
        try {
            listComics.addAll(this.Gonsreturn(jsonRaw));
        }catch (NullPointerException e){
            Log.d("POST","Le fichier n'existe pas ou n'est pas conforme");
            return "KO";
        }
        return "OK";

    }


    public ArrayList<Comics> Gonsreturn(String json)
    {
        try {
            Gson gson = new GsonBuilder().create();
            Code_HTTP code_HTTP = gson.fromJson(json, Code_HTTP.class);

            Type listType = new TypeToken<ArrayList<Comics>>() {}.getType();
            JsonParser p = new JsonParser();
            JsonElement jsonContainer = p.parse(json);
            JsonElement jsonQuery = ((JsonObject) jsonContainer).get("results");
            listComics = gson.fromJson(jsonQuery, listType);
            return listComics;

        }catch (Exception e){
            return null;
        }

    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        comicsListAdapter.notifyDataSetChanged();

        if (response.equals("KO")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(R.string.error_dialog_json_content)
                    .setTitle(R.string.error_dialog_json_title);
            builder.setPositiveButton(R.string.error_dialog_json_exit, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    System.exit(0);
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }

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