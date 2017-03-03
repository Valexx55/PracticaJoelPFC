package ubahn.joel.ubahnproject.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import ubahn.joel.ubahnproject.R;
import ubahn.joel.ubahnproject.control.Controlador;

public class AttCliente extends AppCompatActivity {

    RadioButton info,queja;
    ImageView imagen;
    Button enviar;
    Controlador control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_att_cliente);
        inicializar();

        View.OnClickListener control = new Controlador(this);
        info.setOnClickListener(control);
        queja.setOnClickListener(control);
        enviar.setOnClickListener(control);

    }
    private void inicializar(){
        info = (RadioButton) findViewById(R.id.radio0);
        queja= (RadioButton) findViewById(R.id.radio1);
        enviar=(Button)findViewById(R.id.enviarcorreo);

    }public  void acabar(){
        finish();
    }
}
