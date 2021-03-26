package com.barseghyan_massa.nsi_prospect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.barseghyan_massa.nsi_prospect.db.helper.CompanyHelper;
import com.barseghyan_massa.nsi_prospect.db.model.Company;
import com.barseghyan_massa.nsi_prospect.db.model.Prospect;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class UpdateProspectActivity extends AppCompatActivity {

    //References
    EditText siret, lastname, name, phone, mail, notes;
    MaterialSpinner spinner_company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_prospect);

        //Declarations
        siret = findViewById(R.id.number_siret);
        lastname = findViewById(R.id.text_lastname);
        name = findViewById(R.id.text_name);
        phone = findViewById(R.id.phone_phone);
        mail = findViewById(R.id.mail_mail);
        notes = findViewById(R.id.mlText_notes);
        spinner_company = findViewById(R.id.spinner_company);

        ArrayAdapter<Company> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CompanyHelper.find());
        spinner_company.setAdapter(arrayAdapter);

        Intent intent = getIntent();
        Prospect old_prospect = (Prospect) intent.getSerializableExtra("Prospect");

        //Fill inputs
//        siret.setText(old_prospect.getCompany().getSiret());
        lastname.setText(old_prospect.getLastname());
        name.setText(old_prospect.getName());
        phone.setText(old_prospect.getPhone());
        mail.setText(old_prospect.getMail());
        notes.setText(old_prospect.getNotes());
    }

}