package com.lanesdev.particlego.model;

import com.lanesdev.particlego.R;

/**
 * Created by ppanero on 31/07/16.
 */
public class Level {

    private int image;
    private String text;

    public Level(int image, String text) {
        this.image = image;
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public String getText() {
        return text;
    }

    public static Level getLevelContent(int level) {
        switch (level){
            case 0:
            default:
                return new Level(R.drawable.level_eight_img, "you leveled up bastard!!!!");
            /*case 1:
                return ;
            case 2:
                return ;
            case 3:
                return ;
            case 4:
                return ;
            case 5:
                return ;
            case 6:
                return ;
            case 7:
                return ;
            case 8:
                return ;
            case 9:
                return ;
            case 10:
                return ;
            case 11:
                return ;
            case 12:
                return ;
            case 13:
                return ;
            case 14:
                return ;
            default:
                return ;*/

        }
    }
}
