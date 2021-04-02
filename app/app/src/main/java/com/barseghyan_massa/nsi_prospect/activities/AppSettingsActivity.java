package com.barseghyan_massa.nsi_prospect.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.barseghyan_massa.nsi_prospect.R;

public class AppSettingsActivity extends AppCompatActivity {

    //References
    ImageView btn_goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_settings);

        //Declarations
        btn_goBack = findViewById(R.id.go_back);

        //Buttons events
        btn_goBack.setOnClickListener(v -> {
            finish();
        });

    }
}