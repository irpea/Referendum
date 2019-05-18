package com.irpea.referendum;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_FRAGMENT = "fragment";
    private static final String TAG = "MainActivity";
    private int fragmentNum;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment mFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_info:
                    mFragment = new InfoFragment();
                    fragmentNum = 0;
                    break;
                case R.id.navigation_map:
                    mFragment = new MapFragment();
                    fragmentNum = 1;
                    break;
                case R.id.navigation_list:
                    mFragment = new LocationListFragment();
                    fragmentNum = 2;
                    break;
            }
            return loadFragment(mFragment);
        }
    };

    public boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.action_bar_title);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if(savedInstanceState != null){
            fragmentNum = savedInstanceState.getInt(KEY_FRAGMENT, 0);
            if(fragmentNum == 0){
                loadFragment(new InfoFragment());
            } else if(fragmentNum == 1){
                loadFragment(new MapFragment());
            } else if(fragmentNum == 2){
                loadFragment(new ListFragment());
            }
        } else {
            loadFragment(new InfoFragment());
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
        outState.putInt(KEY_FRAGMENT, fragmentNum);
    }
}
