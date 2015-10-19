package com.countrytable.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.countrytable.R;
import com.countrytable.model.Country;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CountriesAdapter extends AbstractAdapter<Country> {

    public CountriesAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.tvName.setText(getItem(position).getCityName());
        holder.tvApi.setText(getItem(position).getCityApiUrl());
        holder.tvLat.setText(String.valueOf(getItem(position).getCityLatitude()));
        holder.tvLon.setText(String.valueOf(getItem(position).getCityLongitude()));
        holder.tvPlusTime.setText(String.valueOf(getItem(position).getExperimentalEconomPlusTime()));
        return convertView;
    }

    static class Holder {

        @Bind(R.id.tv_name)
        TextView tvName;

        @Bind(R.id.tv_api)
        TextView tvApi;

        @Bind(R.id.tv_lat)
        TextView tvLat;

        @Bind(R.id.tv_lon)
        TextView tvLon;

        @Bind(R.id.tv_plus_time)
        TextView tvPlusTime;

        public Holder(View convertView) {
            ButterKnife.bind(this, convertView);
        }
    }
}
