package com.yeyupiaoling.tfliteclassification;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {
    private List<Animal> mAniamlList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView animalImage;

        public ViewHolder(View view) {
            super(view);
            animalImage = (ImageView) view.findViewById(R.id.animal_image);
        }
    }

    public AnimalAdapter(List<Animal> animallist) {
        mAniamlList = animallist;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Animal animal=mAniamlList.get(position);
        String Image_path=animal.getImagePath();
        try{
            System.out.println(new File(".").getAbsolutePath());
            FileInputStream fis = new FileInputStream(Image_path);
            holder.animalImage.setImageBitmap(BitmapFactory.decodeStream(fis));
        //holder.animalImage.setImageResource(animal.getImageID());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return mAniamlList.size();
    }
}

