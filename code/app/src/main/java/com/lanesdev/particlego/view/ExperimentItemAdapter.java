package com.lanesdev.particlego.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanesdev.particlego.R;
import com.lanesdev.particlego.model.Particle;

import java.util.List;


/**
 * Created by Light on 14/03/16.
 */
public class ExperimentItemAdapter extends ArrayAdapter<Particle> {

    Context context;
    int layoutResourceId;
    List<Particle> data = null;


    public ExperimentItemAdapter(Context context, int layoutResourceId, List<Particle> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        DiseaseItemHolder holder = null;

        if(row == null)
        {
            //LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new DiseaseItemHolder();
            holder.name_tv = (TextView)row.findViewById(R.id.disease_tv);
            holder.level_tv = (TextView)row.findViewById(R.id.level_tv);
            holder.location_date_tv = (TextView)row.findViewById(R.id.location_date_tv);
            holder.twitter_tv = (TextView)row.findViewById(R.id.twitter_tv);
            holder.news_tv = (TextView)row.findViewById(R.id.news_tv);
            holder.cdc_tv = (TextView)row.findViewById(R.id.cdc_tv);
            holder.twitter_icon = (ImageView)row.findViewById(R.id.twitter_iv);

            row.setTag(holder);
        }
        else
        {
            holder = (DiseaseItemHolder)row.getTag();
        }

        Particle diseaseItem = data.get(position);
        //holder.name_tv.setText(diseaseItem.getName());

        return row;
    }



    static class DiseaseItemHolder {
        TextView name_tv;
        TextView level_tv;
        TextView location_date_tv;
        TextView twitter_tv;
        TextView news_tv;
        TextView cdc_tv;
        ImageView twitter_icon;
    }
}
