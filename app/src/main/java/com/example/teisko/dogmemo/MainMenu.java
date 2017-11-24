package com.example.teisko.dogmemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    public Button button_uusi;
    public Button button_asetukset;
    public Button button_tilastot;

    public void init()
    {
        button_uusi = (Button)findViewById(R.id.button_uusi);
        button_uusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent avaus = new Intent(MainMenu.this, MainActivity.class);
                startActivity(avaus);
            }
        });

        button_asetukset = (Button)findViewById(R.id.button_asetukset);
        button_asetukset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent avaus = new Intent(MainMenu.this, SettingsActivity.class);
                avaus.putExtra(PreferenceActivity.EXTRA_SHOW_FRAGMENT, SettingsActivity.GeneralPreferenceFragment.class.getName());
                avaus.putExtra(PreferenceActivity.EXTRA_NO_HEADERS, true);
                startActivity(avaus);
            }
        });

        button_tilastot = (Button)findViewById(R.id.button_tilastot);
        button_tilastot.setEnabled(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        init();
    }
}