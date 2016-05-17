package com.templates.sanchellios.countries.views;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.templates.sanchellios.countries.R;
import com.templates.sanchellios.countries.data.database.DbDataManager;
import com.templates.sanchellios.countries.data.database.DbHelper;
import com.templates.sanchellios.countries.data.preferences.RecyclerPositionManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbDataManager dataManager = new DbDataManager(getApplicationContext());
        if(dataManager.isDbEmpty()){
            dataManager.fillWithDefaultData();
        }
        startCountryListFrag();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.refresh, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh_button:
                RecyclerPositionManager positionManager =
                        new RecyclerPositionManager(getBaseContext());
                positionManager.resetPosition();
                refreshDb(getApplicationContext());
                startCountryListFrag();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void startCountryListFrag(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.country_container, CountryFragment.newInstance())
                .commit();
    }

    private void refreshDb(Context context){
        DbHelper helper = DbHelper.getInstance(context);
        helper.flushTheDb();

        DbDataManager dataManager = new DbDataManager(context);
        dataManager.fillWithDefaultData();
    }


}
