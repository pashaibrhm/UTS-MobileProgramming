package com.aquarian.utsmobpro2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText username, password;
    TextView forgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        prosesLogin();
    }

    public void prosesLogin() {
        username = (EditText) findViewById(R.id.EtUsername);
        password = (EditText) findViewById(R.id.EtPassword);
        login = (Button) findViewById(R.id.BtLogin);
        forgot = (TextView) findViewById(R.id.TvForgot);

        login.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                            Intent intent = new Intent(getApplicationContext(), PilihKue.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "Maaf", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        forgot.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(LoginActivity.this, "Username: admin, Password: admin", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
