package com.gustavo.aula03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

public class IdiomaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioma);
    }

    public void fechar(View v)
    {
        finish();
    }

    public void idiomaPT(View v)
    {
        Locale idioma = new Locale("pt");
        Locale.setDefault(idioma);

        Context context = this;
        Resources res = context.getResources();

        Configuration config = new Configuration(res.getConfiguration());
        config.setLocale(idioma);
        res.updateConfiguration(config, res.getDisplayMetrics());

        SharedPreferences.Editor dados = getSharedPreferences("fatec", MODE_PRIVATE).edit();
        dados.putString("idioma","pt");
        dados.apply();

        recreate();
    }

    public void idiomaEN(View v)
    {
        Locale idioma = new Locale("en");
        Locale.setDefault(idioma);

        Context context = this;
        Resources res = context.getResources();

        Configuration config = new Configuration(res.getConfiguration());
        config.setLocale(idioma);
        res.updateConfiguration(config, res.getDisplayMetrics());

        SharedPreferences.Editor dados = getSharedPreferences("fatec", MODE_PRIVATE).edit();
        dados.putString("idioma","en");
        dados.apply();

        recreate();
    }

    public void idiomaFR(View v)
    {
        Locale idioma = new Locale("fr");
        Locale.setDefault(idioma);

        Context context = this;
        Resources res = context.getResources();

        Configuration config = new Configuration(res.getConfiguration());
        config.setLocale(idioma);
        res.updateConfiguration(config, res.getDisplayMetrics());

        SharedPreferences.Editor dados = getSharedPreferences("fatec", MODE_PRIVATE).edit();
        dados.putString("idioma","fr");
        dados.apply();

        recreate();
    }
}