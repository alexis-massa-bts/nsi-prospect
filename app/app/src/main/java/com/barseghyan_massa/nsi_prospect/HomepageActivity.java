package com.barseghyan_massa.nsi_prospect;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.barseghyan_massa.nsi_prospect.db.helper.ProspectHelper;
import com.barseghyan_massa.nsi_prospect.db.model.Prospect;
import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;
import java.util.List;

public class HomepageActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //References
    ImageView btn_logout, btn_search, btn_addProspect, btn_settings, btn_option, btn_sync, nav_bar;
    MaterialSpinner spinner_event, spinner_company;
    ListView listview;
    SearchView searchView;
    ArrayAdapter<String> prospectAdapter;
    View entire_view;

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
        listview = findViewById(R.id.listview);
        spinner_event = (MaterialSpinner) findViewById(R.id.event);
        spinner_company = (MaterialSpinner) findViewById(R.id.company);
        searchView = findViewById(R.id.searchview);
        nav_bar = findViewById(R.id.bg_navbar);
        entire_view = findViewById(R.id.entire_view);

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

        //ListView
        List<String> allProspects = getProspects();
        updateList(allProspects);

        //ListEvents
        listview.setOnItemClickListener(this);

        //Buttons
        btn_logout.setOnClickListener(v -> {
            Intent login = new Intent(HomepageActivity.this, LoginActivity.class);
            login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(login);
        });

        btn_addProspect.setOnClickListener(v -> {
            Intent addProspect = new Intent(HomepageActivity.this, AddProspectActivity.class);
            startActivity(addProspect);
        });

        btn_sync.setOnClickListener(v -> {
            finish();
            overridePendingTransition(0, 0);
            startActivity(getIntent());
            overridePendingTransition(0, 0);
        });

        btn_search.setOnClickListener(v -> {
            btn_search.setVisibility(View.INVISIBLE);
            btn_addProspect.setVisibility(View.INVISIBLE);
            btn_settings.setVisibility(View.INVISIBLE);
            nav_bar.setVisibility(View.INVISIBLE);
            searchView.setVisibility(View.VISIBLE);
        });

        //searchview events
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.setVisibility(View.INVISIBLE);
                btn_search.setVisibility(View.VISIBLE);
                btn_addProspect.setVisibility(View.VISIBLE);
                btn_settings.setVisibility(View.VISIBLE);
                nav_bar.setVisibility(View.VISIBLE);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                prospectAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }

    public List<String> getProspects() {
        List<Prospect> listProspects = ProspectHelper.find();
        List<String> allProspects = new ArrayList<>();

        listProspects.forEach(p -> {
//            allProspects.add(String.format("%s %s %s", p.getName(), p.getLastname(), p.getCompany().getName()));
            allProspects.add(String.format("%s", p.toString()));
        });

        return allProspects;
    }

    public void updateList(List<String> allProspects) {
        prospectAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, allProspects);

        listview.setAdapter(prospectAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        long prospect = parent.getItemIdAtPosition(position);
        int id_prospect = (int) prospect + 1;

        //start activity with id
        Intent intent = new Intent(this, UpdateProspectActivity.class);
        intent.putExtra("idProspect", id_prospect);
        startActivity(intent);

    }

}