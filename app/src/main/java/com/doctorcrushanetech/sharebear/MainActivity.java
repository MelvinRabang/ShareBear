package com.doctorcrushanetech.sharebear;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameInput;
    EditText passwordInput;
    TextView melvinsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = (EditText) findViewById(R.id.usernameInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        melvinsText = (TextView) findViewById(R.id.melvinsText);
    }

    //Save the users login info
    public void saveInfo(View view) {
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", usernameInput.getText().toString());
        editor.putString("password", passwordInput.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
    }

    //Print out the saved data
    public void displayInfo(View view) {
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        String name = sharedPref.getString("username", "");
        String password = sharedPref.getString("password", "");
        melvinsText.setText(name + " " + password);
    }
}
