package ubahn.joel.ubahnproject.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.ByteArrayOutputStream;

/**
 * Created by Usuario on 05/01/2017.
 */
public class Utils {
    public static final int ORIGEN=1;
    public static final int DESTINO=2;
    public static final String CONDITION_INCICIAL="Dijkstra";
    public static final int SPLASH_TIME=500;

    public static final String URL_SERVER = "http://192.168.1.204:8085/UbahnServer/Servidor";

    public static boolean isNetworkAvailable(Context context) {
        boolean br = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        br = (activeNetworkInfo != null && activeNetworkInfo.isConnected());
        return br;
    }

}
