package com.yeyupiaoling.tfliteclassification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class plantPage extends AppCompatActivity {

    private List<Plant> plantList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_page);

        try {
            initPlants();
        } catch (IOException e) {
            e.printStackTrace();
        }
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.plant_show);
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        PlantAdapter plantAdapter=new PlantAdapter(plantList);
        recyclerView.setAdapter(plantAdapter);
    }
    public void initPlants() throws IOException {
        //Intent intent_3=getIntent();
        //String getdetectImagePath=intent_3.getStringExtra("detect_image_path");
        //Plant plant_1=new Plant(getdetectImagePath);
        //plantList.add(plant_1);
        File sdCardDir= Environment.getExternalStorageDirectory();
        String filepath=sdCardDir.getCanonicalPath()+"/"+"Plantlll.txt";

        //String filePath_content="";
        File file=new File(filepath);
        if(file.isDirectory()){
            Log.d("plantPage","the File doesn't exist");
        }else{
            try{
                InputStream inputStream=new FileInputStream(file);
                if(inputStream!=null){
                    InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
                    BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                    String line;
                    while ((line=bufferedReader.readLine())!=null){
                        //filePath_content+=line+"\n";
                        //line=line.toString();
                        Plant plantImage=new Plant(line);
                        plantList.add(plantImage);
                    }
                    inputStream.close();
                }
            }catch (FileNotFoundException e){
                Log.d("plantPage","the File doesn't exist");
            }catch (IOException e){
                Log.d("plantPage",e.getMessage());
            }
        }

    }
}