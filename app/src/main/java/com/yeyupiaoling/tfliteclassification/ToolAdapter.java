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

public class ToolAdapter extends RecyclerView.Adapter<ToolAdapter.ViewHolder> {
    private List<Tool> mToolList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView toolImage;

        public ViewHolder(View view) {
            super(view);
           toolImage = (ImageView) view.findViewById(R.id.tool_image);
        }
    }

    public ToolAdapter(List<Tool> toollist) {

        mToolList = toollist;
    }


    @Override
    public ToolAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tool_item,parent,false);
        ToolAdapter.ViewHolder holder=new ToolAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ToolAdapter.ViewHolder holder, int position) {
        Tool tool=mToolList.get(position);
        String Image_path=tool.getImagePath();
        try{
            System.out.println(new File(".").getAbsolutePath());
            FileInputStream fis = new FileInputStream(Image_path);
            holder.toolImage.setImageBitmap(BitmapFactory.decodeStream(fis));
            //holder.animalImage.setImageResource(animal.getImageID());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return mToolList.size();
    }

}
