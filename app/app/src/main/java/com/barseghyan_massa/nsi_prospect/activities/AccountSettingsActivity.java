package com.barseghyan_massa.nsi_prospect.activities;

import android.os.Bundle;

import com.barseghyan_massa.nsi_prospect.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.barseghyan_massa.nsi_prospect.activities.ui.main.SectionsPagerAdapter;

public class AccountSettingsActivity extends AppCompatActivity {

    //References
    ViewPager viewPager;
    TabLayout tabs;
    FloatingActionButton fab;
    ImageView btn_goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Declarations
        btn_goBack = findViewById(R.id.go_back);

        //Buttons events
        btn_goBack.setOnClickListener(v -> {
            finish();
        });
    }


}