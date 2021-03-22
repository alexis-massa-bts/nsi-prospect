package com.barseghyan_massa.nsi_prospect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.barseghyan_massa.nsi_prospect.db.helper.UserHelper;

public class MainActivity extends AppCompatActivity {

    //References
    Button login_btn;
    EditText et_name, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Declarations
        login_btn = findViewById(R.id.login_btn);
        et_name = findViewById(R.id.text_name);
        et_password = findViewById(R.id.text_lastname);

        //Button listeners
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
////                Test création d'un Prospect pour test connexion BDD
//                Prospect prospect;
//                try {
//                    prospect = new Prospect("john", "doe");
//                    Toast.makeText(MainActivity.this, prospect.toString(), Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//                    prospect = new Prospect();
//                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
//                }
//
//                ProspectHelper prospectHelper = new ProspectHelper();
//                boolean success = prospectHelper.addOne(prospect);
//                Toast.makeText(MainActivity.this, "Success" + success, Toast.LENGTH_SHORT).show();
////                Toast.makeText(MainActivity.this, dbHelper.findProspect(null).get(0).getName(), Toast.LENGTH_SHORT).show();
//                prospectHelper.find();
               connection();
//                Toast.makeText(MyApplication.getAppContext(), MyApplication.getAppContext().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void connection() {
        UserHelper userH = new UserHelper();

        EditText login = findViewById(R.id.text_name);
        EditText password = findViewById(R.id.text_lastname);
        String login_str = login.getText().toString();
        String password_str = password.getText().toString();

        if (userH.connection(login_str, password_str)) {
            goToHomepage();
        }
    }

    public void goToHomepage() {
        Intent homepage = new Intent(MainActivity.this, HomepageActivity.class);
        startActivity(homepage);
    }
}