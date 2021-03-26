package com.barseghyan_massa.nsi_prospect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class UpdateProspectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_prospect);

        Intent intent = getIntent();
        int id_prospect = intent.getIntExtra("idProspect",0);

        Toast.makeText(this, "id:" + id_prospect, Toast.LENGTH_SHORT).show();
    }
}