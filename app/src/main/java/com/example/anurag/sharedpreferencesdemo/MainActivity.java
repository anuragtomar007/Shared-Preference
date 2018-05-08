package com.example.anurag.sharedpreferencesdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private final String MYPREF = "myPref";
    private EditText eusername;
    private Button submit;
    private Button retrieve;
    private EditText epassword;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        epassword = findViewById(R.id.et_password);
        eusername = findViewById(R.id.et_username);
        submit = findViewById(R.id.btn_submit);
        retrieve = findViewById(R.id.btn_retrieve);
        sharedPreferences = getApplicationContext().getSharedPreferences(MYPREF, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String u = eusername.getText().toString();
                String p = epassword.getText().toString();
                editor.putString("Username", u);
                editor.putString("Password", p);
//                editor.apply();
                editor.commit();
                epassword.setText("");
                eusername.setText("");
                Toast.makeText(MainActivity.this, "Data Saved in Shared Preferences", Toast.LENGTH_SHORT).show();
            }
        });

        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                eusername.setText(sharedPreferences.getString("Username", "default"));
                epassword.setText(sharedPreferences.getString("Password", "default"));
            }
        });
    }
}
