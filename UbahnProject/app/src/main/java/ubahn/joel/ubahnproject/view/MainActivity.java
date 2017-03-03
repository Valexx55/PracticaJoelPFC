package ubahn.joel.ubahnproject.view;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import ubahn.joel.ubahnproject.R;
import ubahn.joel.ubahnproject.control.Controlador;
import ubahn.joel.ubahnproject.control.NavigationMenuListener;
import ubahn.joel.ubahnproject.model.Estacion;
import ubahn.joel.ubahnproject.remote.AsyncTaskDescargaEstaciones;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private boolean menu_visible;
    private static TextView tvdate,tvtime;
    private EditText origen,destino;
    public Controlador control;
    NavigationView navigationView;
    Button datebutton;

    Calendar c=Calendar.getInstance();

    int cdate,cmonth,cyear;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu_visible = true;
        inicializar();
        View.OnClickListener control = new Controlador(this);
        origen.setOnClickListener(control);
        destino.setOnClickListener(control);
        navigationView.setNavigationItemSelectedListener(new NavigationMenuListener(this));

        drawerLayout.openDrawer(Gravity.LEFT);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.iconmenu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Button displayTimeButton = (Button)findViewById(R.id.button2);
        assert displayTimeButton != null;
        displayTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePicker mTimePicker = new TimePicker();
                mTimePicker.show(getFragmentManager(), "Select time");
            }
        });




        datebutton=(Button)findViewById(R.id.button3);



        datebutton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                new DatePickerDialog(MainActivity.this,d1,c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show();

            }

        });




    }
    DatePickerDialog.OnDateSetListener d1=new DatePickerDialog.OnDateSetListener() {

        @Override

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            cdate=dayOfMonth;

            cmonth=monthOfYear+1;

            cyear=year;

            tvdate.setText(cdate+"-"+cmonth+"-"+cyear);



        }

    };
    private void inicializar(){
        navigationView = (NavigationView) findViewById(R.id.navview);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        tvdate = (TextView)findViewById(R.id.textView5);
        origen=(EditText)findViewById(R.id.editTextorigen);
        destino=(EditText)findViewById(R.id.editTextdestino);
    }
    public static class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
        }

        @Override
        public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
            tvdate.setText("Selected Time: " + String.valueOf(hourOfDay) + " : " + String.valueOf(minute));
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case android.R.id.home:
                if (menu_visible)
                {
                    drawerLayout.closeDrawers();
                    menu_visible = false;
                } else
                {
                    drawerLayout.openDrawer(GravityCompat.START);
                    menu_visible = true;
                }
        }

        return super.onOptionsItemSelected(item);
    }

    public void cierramenu() {
        drawerLayout.closeDrawers();
        menu_visible = false;
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == this.RESULT_OK){
                String result=data.getStringExtra("result");
                origen.setText(result);
            }
            if (resultCode == this.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}
