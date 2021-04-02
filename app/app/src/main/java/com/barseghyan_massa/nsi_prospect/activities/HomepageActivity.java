package com.barseghyan_massa.nsi_prospect.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.barseghyan_massa.nsi_prospect.R;
import com.barseghyan_massa.nsi_prospect.db.helper.CompanyHelper;
import com.barseghyan_massa.nsi_prospect.db.helper.ProspectHelper;
import com.barseghyan_massa.nsi_prospect.db.model.Company;
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
    ArrayAdapter<Prospect> prospectAdapter;
    View entire_view;
    List<String> allCompanies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        //Declarations
        btn_logout = findViewById(R.id.logout);
        btn_addProspect = findViewById(R.id.add_prospect);
        btn_option = findViewById(R.id.app_option);
        btn_search = findViewById(R.id.search);
        btn_sync = findViewById(R.id.sync);
        btn_settings = findViewById(R.id.settings);
        listview = findViewById(R.id.listview);
        spinner_event = (MaterialSpinner) findViewById(R.id.event);
        spinner_company = (MaterialSpinner) findViewById(R.id.theme);
        searchView = findViewById(R.id.searchview);
        nav_bar = findViewById(R.id.bg_navbar);
        entire_view = findViewById(R.id.entire_view);

        //Fill spinners
        allCompanies = getCompanies();

        spinner_company.setItems(allCompanies);
        spinner_event.setItems("All");

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
                //Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
                if (item == "All") {
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(getIntent());
                    overridePendingTransition(0, 0);
                }
                prospectAdapter.getFilter().filter(item);
            }
        });

        //ListView
        List<Prospect> allProspects = getProspects();
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

        btn_option.setOnClickListener(v -> {
            Intent AppSettings = new Intent(HomepageActivity.this, AppSettingsActivity.class);
            startActivity(AppSettings);
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

    public List<Prospect> getProspects() {
        List<Prospect> listProspects = ProspectHelper.find();
        List<Prospect> allProspects = new ArrayList<>();

        listProspects.forEach(p -> {
            allProspects.add(p);
        });

        return allProspects;
    }

    public List<String> getCompanies() {
        List<Company> listCompanies = CompanyHelper.find();
        List<String> CompanyNames = new ArrayList<String>();

        CompanyNames.add("All");

        listCompanies.forEach(c -> {
            CompanyNames.add(c.getName());
        });
        return CompanyNames;
    }

    public void updateList(List<Prospect> allProspects) {
        prospectAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, allProspects);
        listview.setAdapter(prospectAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        long prospect = parent.getItemIdAtPosition(position);
        int id_prospect = (int) prospect + 1;

        Prospect p = (Prospect) parent.getItemAtPosition(position);

        //start activity with id
        Intent intent = new Intent(this, UpdateProspectActivity.class);
        intent.putExtra("Prospect", p);
        startActivity(intent);
    }

}