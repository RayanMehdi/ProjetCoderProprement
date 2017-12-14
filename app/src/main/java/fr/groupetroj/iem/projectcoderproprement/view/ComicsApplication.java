package fr.groupetroj.iem.projectcoderproprement.view;

import android.app.Application;

import fr.groupetroj.iem.projectcoderproprement.data.manager.ComicsManager;

/**
 * Created by iem on 08/12/2017.
 */

public class ComicsApplication extends Application{

    // Variable privée qui retiendra l'instance de l'objet application
    private static ComicsApplication application;

    // getter public pour récupérer l'instance statique de l'objet application
    public static ComicsApplication application() {
        return application;
    }

    // Variable privée qui retiendra la seule instance du manager
    private ComicsManager comicsManager;

    // getter public pour récupérer l'instance unique de l'objet manager
    public ComicsManager getComicsManager() {
        return comicsManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

        this.comicsManager = new ComicsManager();
    }

}
