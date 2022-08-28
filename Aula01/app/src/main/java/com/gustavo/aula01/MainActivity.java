package com.gustavo.aula01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText teste = findViewById(R.id.editTextNumber);
        teste.getText().toString();

        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}
