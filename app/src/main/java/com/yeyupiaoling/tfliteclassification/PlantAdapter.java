package com.yeyupiaoling.tfliteclassification;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.ViewHolder> {
    private List<Plant> mPlantList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView plantImage;

        public ViewHolder(View view) {
            super(view);
            plantImage = (ImageView) view.findViewById(R.id.plant_image);
        }
    }

    public PlantAdapter(List<Plant> plantlist) {

        mPlantList = plantlist;
    }


    @Override
    public PlantAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.plant_item,parent,false);
        PlantAdapter.ViewHolder holder=new PlantAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PlantAdapter.ViewHolder holder, int position) {
        Plant plant=mPlantList.get(position);
        String Image_path=plant.getImagePath();
        try{
            System.out.println(new File(".").getAbsolutePath());
            FileInputStream fis = new FileInputStream(Image_path);
            holder.plantImage.setImageBitmap(BitmapFactory.decodeStream(fis));
            //holder.animalImage.setImageResource(animal.getImageID());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return mPlantList.size();
    }
}
