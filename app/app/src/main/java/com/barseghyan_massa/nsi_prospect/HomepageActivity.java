package com.barseghyan_massa.nsi_prospect;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class HomepageActivity extends AppCompatActivity {

    //References
    ImageView logout_btn;
    MaterialSpinner spinner_event;
    MaterialSpinner spinner_company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        //Declarations
        logout_btn = findViewById(R.id.logout);
        spinner_event = (MaterialSpinner) findViewById(R.id.event);
        spinner_company = (MaterialSpinner) findViewById(R.id.company);

        //Buttons listners
        logout_btn.setOnClickListener(new View.OnClickListener() {
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

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });

        spinner_company.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });

        //Table
        TableLayout tl = (TableLayout)findViewById(R.id.tableLayout);

        for (int i = 0; i < 10; i++) {
            TableRow row = new TableRow(this);
            TextView tv = new TextView(this);
            tv.setText("This is text" + i);

            tl.addView(row);
            row.addView(tv);
        }
    }

}