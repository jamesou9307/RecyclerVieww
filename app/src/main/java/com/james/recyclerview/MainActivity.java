package com.james.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Country> countries=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initCountries();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);

        /*StaggeredGridLayoutManager 瀑布流布局
        * 构造函数第一个为创建多少列，传入3就会创建3列*/
       /* StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);*/

        recyclerView.setLayoutManager(layoutManager);

        /*layoutManager.setOrientation(int i) 可以修改布局的排列方向，现在RecyclerView可以横向滚动*/

        /*layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);*/
        CountryAdapter countryAdapter=new CountryAdapter(countries);
        recyclerView.setAdapter(countryAdapter);
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
    public String getRandomLengthName(String name){
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<length;i++){
            builder.append(name);
        }
        return builder.toString();
    }
}
