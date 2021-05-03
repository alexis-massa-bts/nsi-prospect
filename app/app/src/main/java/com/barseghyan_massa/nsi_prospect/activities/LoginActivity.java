package com.barseghyan_massa.nsi_prospect.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.barseghyan_massa.nsi_prospect.R;
import com.barseghyan_massa.nsi_prospect.db.helper.UserHelper;

public class LoginActivity extends AppCompatActivity {

    //References
    Button btn_login;
    ImageView btn_settings;
    EditText et_login, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        //Declarations
        btn_login = findViewById(R.id.login_btn);
        btn_settings = findViewById(R.id.btn_settings);

        et_login = findViewById(R.id.text_name);
        et_password = findViewById(R.id.text_lastname);

        //Button listeners
        btn_login.setOnClickListener(v -> connection());

        btn_settings.setOnClickListener(v -> {
            Intent accountSettings = new Intent(LoginActivity.this, AccountSettingsActivity.class);
            startActivity(accountSettings);
        });

    }

    public void connection() {

        String login_str = et_login.getText().toString();
        String password_str = et_password.getText().toString();

        if (UserHelper.connection(login_str, password_str)) {
            goToHomepage();
        }
    }

    public void goToHomepage() {
        Intent homepage = new Intent(LoginActivity.this, HomepageActivity.class);
        startActivity(homepage);
    }
}