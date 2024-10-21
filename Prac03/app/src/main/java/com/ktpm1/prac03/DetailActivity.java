package com.ktpm1.prac03;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Country country = (Country) getIntent().getSerializableExtra("country");

        TextView name = findViewById(R.id.name);
        TextView capital = findViewById(R.id.capital);
        TextView population = findViewById(R.id.population);
        TextView area = findViewById(R.id.area);
        TextView density = findViewById(R.id.density);
        TextView worldShare = findViewById(R.id.worldShare);

        // Set the country information to TextViews
        name.setText(country.getName());
        capital.setText(country.getCapital());
        population.setText(String.valueOf(country.getPopulation()));
        area.setText(String.valueOf(country.getArea()));
        density.setText(String.valueOf(country.getDensity()));
        worldShare.setText(String.valueOf(country.getWorldShare()));
    }
}