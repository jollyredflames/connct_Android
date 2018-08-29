package com.connct.connectandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class landingpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landingpage);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_dashboard);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer, new HomeFragment()).commit();
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFrag = null;

            switch (item.getItemId()) {
                case R.id.navigation_dashboard:
                    selectedFrag = new HomeFragment();
                    break;
                case R.id.navigation_contacts:
                    selectedFrag = new ContactFragment();
                    break;
                case R.id.navigation_personal:
                    setTitle("Personal");
                    selectedFrag = new PersonalFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer, selectedFrag).commit();
            return true;
        }
    };

}
