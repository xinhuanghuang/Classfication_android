package com.yeyupiaoling.tfliteclassification;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileInputStream;

public class Animal {

    private String aniamlImagePath;
//    private Bitmap bitmap;
    public Animal(String AniamlImagePath){
        this.aniamlImagePath=AniamlImagePath;
    }
    public String getImagePath(){
        return aniamlImagePath;
    }
}
