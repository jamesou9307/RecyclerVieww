package com.james.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by fsuser on 2017-09-11.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder>{

    private List<Country> countryList;

    /*
    * 静态内部类ViewHolder继承自RecyclerView.ViewHolder,构造时传入一个view实例，
    * 这样就可以通过findById()方法获取到布局中的ImageView和TextView实例
    *
    * */
    static class ViewHolder extends RecyclerView.ViewHolder{

        View countryView;
        ImageView countryImage;
        TextView countryName;

        public ViewHolder(View view) {
            super(view);
            countryView=view;
            countryImage=(ImageView)view.findViewById(R.id.country_image);
            countryName=(TextView)view.findViewById(R.id.country_name);
        }

    }

    public CountryAdapter(List<Country> countryList) {
        this.countryList = countryList;
    }

    /*
    *用于创建ViewHolder实例,在这里加载country_item布局,然后创建一个ViewHolder实例，并把加载出来的布局传入
    * ViewHolder构造函数中，并返回出来
    * */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item,parent,false);
        final  ViewHolder holder=new ViewHolder(view);
        /*为ViewHolder的每个子项添加点击事件,在RecyclerView中,需要为每个子项的view单独添加控件*/
        holder.countryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Country country=countryList.get(position);
                Toast.makeText(view.getContext(),"you clicked view "+country.getCountryName(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.countryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Country country=countryList.get(position);
                Toast.makeText(view.getContext(),"you clicked image "+country.getCountryName(),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    /*用于对RecyclerView子项的数据进行赋值，会在每个子项被滚动到屏幕内时执行，
    这里我们通过position参数得到当前项的COuntry实例,然后再将数据设置到ViewHolder的ImageView和TextView即可
    */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Country country=countryList.get(position);
        holder.countryImage.setImageResource(country.getCountryId());
        holder.countryName.setText(country.getCountryName());
    }

    /*返回RecyclerView有多少子项*/
    @Override
    public int getItemCount() {
        return countryList.size();
    }
}
