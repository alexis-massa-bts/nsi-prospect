package com.barseghyan_massa.nsi_prospect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.barseghyan_massa.nsi_prospect.db.helper.ProspectHelper;
import com.barseghyan_massa.nsi_prospect.db.model.Prospect;

public class AddProspectActivity extends AppCompatActivity {

    //references
    ImageView btn_logout, btn_globeSearch, btn_add_newProspect, btn_settings, btn_option, btn_sync;
    Button btn_addProspect;
    EditText number_siret, text_name, text_lastname, text_phone, text_mail, text_notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_prospect);

        //Declarations
        btn_logout = findViewById(R.id.logout);
        btn_addProspect = findViewById(R.id.btn_add);
        btn_option = findViewById(R.id.app_option);
        btn_settings = findViewById(R.id.settings);
        btn_globeSearch = findViewById(R.id.search);
        btn_sync = findViewById(R.id.sync);

        number_siret = findViewById(R.id.number_siret);
        text_name = findViewById(R.id.text_name);
        text_lastname = findViewById(R.id.text_lastname);
        text_phone = findViewById(R.id.phone_phone);
        text_mail = findViewById(R.id.mail_mail);
        text_notes = findViewById(R.id.mlText_notes);


        btn_addProspect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prospect newProspect = new Prospect(text_name.getText().toString(), text_lastname.getText().toString(), text_phone.getText().toString(), text_mail.getText().toString(), text_notes.getText().toString());
                boolean inserted = ProspectHelper.addOne(newProspect);
                if (inserted) {
                    Toast.makeText(AddProspectActivity.this, "Ajouté avec succès", Toast.LENGTH_SHORT).show();
                    goToAddProspect();
                } else {
                    Toast.makeText(AddProspectActivity.this, "Erreur saisie", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void goToAddProspect(){
        Intent addProspect = new Intent(AddProspectActivity.this, AddProspectActivity.class);
        startActivity(addProspect);
    }
}