package com.lanesdev.particlego.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.res.ResourcesCompat;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.android.gms.vision.text.Text;
import com.lanesdev.particlego.R;
import com.lanesdev.particlego.model.Level;

/**
 * Created by ppanero on 31/07/16.
 */
public class PopUp {

    // The method that displays the popup.
    public void showPopup(final Activity activity, final Level levelContent, final int level) {

        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;

        // Inflate the popup_layout.xml
        LinearLayout viewGroup = (LinearLayout) activity.findViewById(R.id.popup);
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.popup, viewGroup);


        TextView content_tv = (TextView) layout.findViewById(R.id.level_up_tv);
        ImageView contetn_iv = (ImageView) layout.findViewById(R.id.level_up_iv);

        content_tv.setText(levelContent.getText());
        contetn_iv.setImageDrawable(ResourcesCompat.getDrawable(activity.getResources(),
                levelContent.getImage(), null));
        // Creating the PopupWindow
        final PopupWindow popup = new PopupWindow(activity);
        popup.setContentView(layout);
        popup.setWidth(width);
        popup.setHeight(height);
        popup.setFocusable(true);

        // Clear the default translucent background
        popup.setBackgroundDrawable(new BitmapDrawable());

        // Displaying the popup at the specified location, + offsets.
        popup.showAtLocation(layout, Gravity.NO_GRAVITY, 0, 0);

        // Getting a reference to Close button, and close the popup when clicked.
        Button close = (Button) layout.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                popup.dismiss();
                if(level == 14){
                    showPopup(activity, Level.getLevelContent(level), -1);
                }
            }
        });
    }
}
