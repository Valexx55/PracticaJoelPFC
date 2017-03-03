package ubahn.joel.ubahnproject.remote;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import ubahn.joel.ubahnproject.Utils.Utils;

/**
 * Created by Joel Fernandez on 30/01/2017.
 */

public class AsyncTaskInicializarDijsktra extends AsyncTask<Void, Void, Void> {
    private Context c;

    public AsyncTaskInicializarDijsktra(Context c) {
        this.c = c;
    }


    @Override
    protected Void doInBackground(Void... params) {

        InputStreamReader isr = null;
        BufferedReader br = null;
        int respuesta = -1;
        URL url = null;
        HttpURLConnection httpConn = null;

        try {
            url = new URL(Utils.URL_SERVER+Utils.CONDITION_INCICIAL);

            httpConn = (HttpURLConnection) url.openConnection();

            respuesta = httpConn.getResponseCode();
            if (respuesta == HttpURLConnection.HTTP_OK) {

            }
            httpConn.disconnect();
        } catch (Throwable t) {
            Log.e(getClass().getCanonicalName(), "Ha ido mal la com con el server", t);
        } finally {
            httpConn.disconnect();
        }
        return null;
    }
}
