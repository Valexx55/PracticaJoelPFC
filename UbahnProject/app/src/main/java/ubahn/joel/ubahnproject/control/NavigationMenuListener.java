package ubahn.joel.ubahnproject.control;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import ubahn.joel.ubahnproject.view.AttCliente;
import ubahn.joel.ubahnproject.view.Info;
import ubahn.joel.ubahnproject.view.LineasyPlanos;
import ubahn.joel.ubahnproject.view.MainActivity;

/**
 * Created by Usuario on 09/01/2017.
 */
public class NavigationMenuListener implements NavigationView.OnNavigationItemSelectedListener {

    private Context context;

    public NavigationMenuListener (Context context)
    {
        this.context = context;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        String menu = item.getTitle().toString();

        switch(menu){
            case "Rutas y Horarios":
                cerrarMenu();
                break;
            case "Planos y Lineas":
                cerrarMenu();
                abrirActivityLineas();
                break;
            case "Informacion":
                cerrarMenu();
                abrirActivityInfo();
                break;
            case "Att. Cliente":
                cerrarMenu();
                abrirAcitvityAttcliente();
                break;
        }

        return true;
    }

    private void abrirAcitvityAttcliente() {
        Activity a = null;
        a = (Activity) context;
        Intent i = new Intent(context, AttCliente.class);
        a.startActivity(i);
    }

    private void abrirActivityInfo() {
        Activity a = null;
        a = (Activity) context;
        Intent i = new Intent(context, Info.class);
        a.startActivity(i);
    }



    private void abrirActivityLineas() {
        Activity a = null;
        a = (Activity) context;
        Intent i = new Intent(context, LineasyPlanos.class);
        a.startActivity(i);
    }

    private void cerrarMenu(){
        MainActivity activity = (MainActivity)context;
        activity.cierramenu();
    }
}
