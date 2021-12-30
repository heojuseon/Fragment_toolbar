package com.example.fragment_toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    Tab_1 tab_1;
    Tab_2 tab_2;
    Tab_3 tab_3;
    Tab_4 tab_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab_1 = new Tab_1();
        tab_2 = new Tab_2();
        tab_3 = new Tab_3();
        tab_4 = new Tab_4();

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, tab_1).commit();
        //앞 연습(Fragment_practice)에서 다룬
        //transaction = fragmentManager.beginTransaction();
        //transaction.replace(R.id.frameLayout, fragmentA).commitAllowingStateLoss();
        //와 같은 의미

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavi);
//        bottomNavigationView.setOnNavigationItemSelectedListener(); --> deprecated 되었다.
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.tab1:
                        getSupportFragmentManager().beginTransaction().
                                replace(R.id.frameLayout, tab_1).commit();
                        return true;

                    case R.id.tab2:

                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frameLayout, tab_2).commit();
                        return true;

                    case R.id.tab3:

                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frameLayout, tab_3).commit();
                        return true;

                    case R.id.tab4:

                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frameLayout, tab_4).commit();
                        return true;

                }
                return false;
            }
        });


    }
}