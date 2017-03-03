package ubahn.joel.ubahnproject.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;
import java.util.concurrent.ExecutionException;

import ubahn.joel.ubahnproject.R;
import ubahn.joel.ubahnproject.control.Controlador;
import ubahn.joel.ubahnproject.control.RecycleEstaciones;
import ubahn.joel.ubahnproject.model.Estacion;
import ubahn.joel.ubahnproject.remote.AsyncTaskDescargaEstaciones;

public class Estaciones extends AppCompatActivity {






    public String nombreEstacion;
    RecyclerView rv;
    RecyclerView mRecycleView;
    List<Estacion> listaestaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estaciones);
        nombreEstacion="";
        try {
            inicializar();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        rv.setHasFixedSize(true);

        RecycleEstaciones adapter = new RecycleEstaciones(listaestaciones,this,mRecycleView);
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_estaciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void Cerrar(){
        Intent returnIntent = getIntent();
        returnIntent.putExtra("result",nombreEstacion);
        setResult(RESULT_OK,returnIntent);
        finish();
    }
    public void setNombreEstacion(String nombreEstacion) {
        this.nombreEstacion = nombreEstacion;
    }
    private void inicializar() throws ExecutionException, InterruptedException {
        Controlador controlador=new Controlador(this);
        listaestaciones = controlador.descargarEstaciones();
        rv = (RecyclerView) findViewById(R.id.rv_recycler_view);
        mRecycleView=(RecyclerView)findViewById(R.id.rv_recycler_view);
    }
}
