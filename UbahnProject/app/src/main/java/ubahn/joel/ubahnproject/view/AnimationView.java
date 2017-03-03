package ubahn.joel.ubahnproject.view;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import ubahn.joel.ubahnproject.R;
import ubahn.joel.ubahnproject.Utils.CustomProgressBar;
import ubahn.joel.ubahnproject.Utils.Utils;
import ubahn.joel.ubahnproject.remote.AsyncTaskInicializarDijsktra;


import android.content.Intent;

import android.graphics.PixelFormat;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class AnimationView extends AppCompatActivity {



    private Handler handler;
    private int time;
    private RelativeLayout splashContainer;
    private CustomProgressBar loading;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_animation_view);
        splashContainer = (RelativeLayout) findViewById(R.id.container_splash);
        loading = (CustomProgressBar) findViewById(R.id.loading);
        startHandler();

    }


    private void startHandler() {
        new AsyncTaskInicializarDijsktra(this).execute();
        time = 0;
        loading.setVisibility(View.VISIBLE);
        handler = new Handler();
        handler.postAtTime(new Runnable() {
            @Override
            public void run() {
                //check time
                if (time == Utils.SPLASH_TIME) {
                    //remove runnable
                    handler.removeCallbacks(this);
                    Intent intent=new Intent(AnimationView.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    //increment time
                    time = time + 1;
                    handler.postDelayed(this, 1);
                }
            }
        }, 1);
    }


}