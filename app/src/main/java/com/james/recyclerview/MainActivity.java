package com.james.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Country> countries=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initCountries();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        CountryAdapter countryAdapter=new CountryAdapter(countries);
        /*recyclerView.setAdapter(countryAdapter);*/
    }
    private void  initCountries() {

        for (int i = 0; i < 2; i++) {
            Country germany = new Country(R.drawable.germany, "Germany");
            countries.add(germany);
            Country france = new Country(R.drawable.france, "France");
            countries.add(france);
            Country england = new Country(R.drawable.england, "England");
            countries.add(england);
            Country usa = new Country(R.drawable.usa, "USA");
            countries.add(usa);
            Country australia = new Country(R.drawable.australia, "Australia");
            countries.add(australia);
            Country argentina = new Country(R.drawable.argentina, "Argentina");
            countries.add(argentina);
            Country japan = new Country(R.drawable.japan, "Japan");
            countries.add(japan);
            Country italy = new Country(R.drawable.italy, "Italy");
            countries.add(italy);
            Country brazil = new Country(R.drawable.brazil, "Brazil");
            countries.add(brazil);

        }
    }
}
