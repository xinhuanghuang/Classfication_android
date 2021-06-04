package com.yeyupiaoling.tfliteclassification;

public class Plant {
    private String plantImagePath;

    public Plant(String PlantImagePath){
        this.plantImagePath=PlantImagePath;
    }
    public String getImagePath(){
        return plantImagePath;
    }
}
