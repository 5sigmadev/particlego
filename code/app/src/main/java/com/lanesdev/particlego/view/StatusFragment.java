package com.lanesdev.particlego.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lanesdev.particlego.R;
import com.lanesdev.particlego.model.User;


/**
 * Created by ppanero on 31/07/16.
 */
public class StatusFragment extends Fragment {

    ImageView statusImg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_status, container, false);
        statusImg = (ImageView) rootView.findViewById(R.id.status_iv);
        User user = getArguments().getParcelable("USER");
        refresh(user.getLevel());
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getFragmentManager().beginTransaction().remove(this).commit();
    }

    public void refresh(int userLevel) {
        switch (userLevel){
            case 0:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_zero_img , null));
                break;
            case 1:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_one_img , null));
                break;
            case 2:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_two_img , null));
                break;
            case 3:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_three_img , null));
                break;
            case 4:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_four_img , null));
                break;
            case 5:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_five_img , null));
                break;
            case 6:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_six_img , null));
                break;
            case 7:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_seven_img , null));
                break;
            case 8:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_eight_img , null));
                break;
            case 9:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_nine_img , null));
                break;
            case 10:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_ten_img , null));
                break;
            case 11:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_eleven_img , null));
                break;
            case 12:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_twelve_img , null));
                break;
            case 13:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_thirteen_img , null));
                break;
            case 14:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_fourteen_img , null));
                break;
            default:
                statusImg.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(),
                        R.drawable.level_zero_img , null));
                break;
        }
    }
}
