package com.barseghyan_massa.nsi_prospect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inputLogin;
    private EditText inputPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputLogin = (EditText) findViewById(R.id.text_login);
        inputPassword = (EditText) findViewById(R.id.text_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
    }

    public void validate(String username, String password) {
        if((username == "Admin") && (password == "1234")){
            Intent intent = new Intent(MainActivity.this, HomepageActivity.class);
        }
    }

    /*
    Display toast
     */
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_connected, Toast.LENGTH_SHORT);
        toast.show();
    }
}