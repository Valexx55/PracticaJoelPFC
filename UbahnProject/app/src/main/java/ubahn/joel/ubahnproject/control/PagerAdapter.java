package ubahn.joel.ubahnproject.control;

import android.content.Context;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Locale;

import ubahn.joel.ubahnproject.R;

import ubahn.joel.ubahnproject.view.Lineas;
import ubahn.joel.ubahnproject.view.Plano;

/**
 * Created by Joel Fernandez on 30/01/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter {

Context context;
    public PagerAdapter(FragmentManager fm,Context c) {
        super(fm);
        this.context=c;
    }




    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                Lineas linea = new Lineas();
                return linea;
            case 1:
                Plano plano =  new Plano();
                return plano;


        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }//set the number of tabs

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return context.getString(R.string.title_activity_lineas);
            case 1:
                return  context.getString(R.string.plano);
        }
        return null;
    }



}