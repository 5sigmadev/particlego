package com.lanesdev.particlego.view;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
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
        ExperimentItemHolder holder = null;

        if(row == null)
        {
            //LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ExperimentItemHolder();
            holder.name_tv = (TextView)row.findViewById(R.id.name_tv);
            holder.description_tv = (TextView)row.findViewById(R.id.item_description);
            holder.item_icon = (ImageView)row.findViewById(R.id.item_icon);

            row.setTag(holder);
        }
        else
        {
            holder = (ExperimentItemHolder)row.getTag();
        }

        Particle particleItem = data.get(position);
        holder.name_tv.setText(particleItem.getName());
        holder.description_tv.setText(particleItem.getDescription());
        holder.item_icon.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                particleItem.getItemIcon() , null));

        return row;
    }



    static class ExperimentItemHolder {
        TextView name_tv;
        TextView description_tv;
        ImageView item_icon;
    }
}
