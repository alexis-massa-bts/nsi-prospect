package com.barseghyan_massa.nsi_prospect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.barseghyan_massa.nsi_prospect.db.helper.ProspectHelper;
import com.barseghyan_massa.nsi_prospect.db.model.Prospect;
import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.List;

public class HomepageActivity extends AppCompatActivity {

    //References
    ImageView btn_logout, btn_search, btn_addProspect, btn_settings, btn_option, btn_sync;
    MaterialSpinner spinner_event, spinner_company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        //Declarations
        btn_logout = findViewById(R.id.logout);
        btn_addProspect = findViewById(R.id.add_prospect);
        btn_option = findViewById(R.id.app_option);
        btn_settings = findViewById(R.id.settings);
        btn_search = findViewById(R.id.search);
        btn_sync = findViewById(R.id.sync);

        spinner_event = (MaterialSpinner) findViewById(R.id.event);
        spinner_company = (MaterialSpinner) findViewById(R.id.company);

        //Buttons listners
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Successfull logout", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        //Fill spinners
        spinner_company.setItems("item 1", "item 2", "item 3", "item 4", "item 5");
        spinner_event.setItems("item 1", "item 2", "item 3", "item 4", "item 5");

        //Spinners events
        spinner_event.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });

        spinner_company.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });

        //Table
        TableLayout tl = (TableLayout) findViewById(R.id.tableLayout);

        List<Prospect> allProspects = ProspectHelper.find();

        allProspects.forEach(p -> {
            TableRow row = new TableRow(this);
            TextView tv = new TextView(this);
            tv.setText(String.format("%s %s", p.getName(), p.getLastname()));

            tl.addView(row);
            row.addView(tv);
        });


        btn_addProspect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addProspect = new Intent(HomepageActivity.this, AddProspectActivity.class);
                startActivity(addProspect);
            }
        });

    }
}