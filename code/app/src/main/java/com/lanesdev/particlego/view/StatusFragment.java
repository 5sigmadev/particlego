package com.lanesdev.particlego.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lanesdev.particlego.R;
/**
 * Created by ppanero on 31/07/16.
 */
public class StatusFragment extends Fragment {

    ImageView statusImg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_status, container, false);
        statusImg = (ImageView) rootView.findViewById(R.id.status_iv);

        statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                R.drawable.level_zero_img , null));
        return rootView;
    }

    public void refresh(int userLevel) {
        switch (userLevel){
            case 0:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_zero_img , null));
                break;
            case 1:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_zero_img , null));
                break;
            case 2:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_zero_img , null));
                break;
            case 3:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_zero_img , null));
                break;
            case 4:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_zero_img , null));
                break;
            case 5:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_zero_img , null));
                break;
            case 6:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_zero_img , null));
                break;
            case 7:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_zero_img , null));
                break;
            case 8:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_zero_img , null));
                break;
            case 9:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_zero_img , null));
                break;
            case 10:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_zero_img , null));
                break;
            case 11:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_zero_img , null));
                break;
            case 12:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_zero_img , null));
                break;
            case 13:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_zero_img , null));
                break;
            case 14:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_zero_img , null));
                break;
            default:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_zero_img , null));
                break;
        }
    }
}
