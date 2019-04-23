package com.pcp.persistence;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvName;
    EditText etName;
    Button btnSave;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = (TextView) findViewById(R.id.tvName);
        etName = (EditText) findViewById(R.id.etName);
        btnSave = (Button) findViewById(R.id.btnSave);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        tvName.setText(sharedPreferences.getString("name", "nothing"));

        btnSave.setOnClickListener(myHandler);
    }

    View.OnClickListener myHandler = new View.OnClickListener(){
        public void onClick(View view){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            String name = etName.getText().toString();
            editor.putString("name", name);
            editor.apply();

            // access sharedPreferences
            tvName.setText(sharedPreferences.getString("name", "nothing"));
        }

    };
}
