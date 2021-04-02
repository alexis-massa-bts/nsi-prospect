package com.barseghyan_massa.nsi_prospect.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.barseghyan_massa.nsi_prospect.R;
import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class AppSettingsActivity extends AppCompatActivity {

    //References
    ImageView btn_goBack;
    MaterialSpinner theme_dropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_settings);

        //Declarations
        btn_goBack = findViewById(R.id.go_back);
        theme_dropdown = findViewById(R.id.theme);

        //Buttons events
        btn_goBack.setOnClickListener(v -> {
            finish();
        });

        //Spinner
        theme_dropdown.setItems("Dark", "Light");

        theme_dropdown.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "You choosed the " + item + " theme !", Snackbar.LENGTH_LONG).show();

                if (position == 0) setTheme(R.style.Theme_Design_Light);
                if (position == 1) setTheme(R.style.Theme_Design);
            }
        });

    }
}