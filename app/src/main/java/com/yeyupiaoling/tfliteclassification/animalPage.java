package com.yeyupiaoling.tfliteclassification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


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

public class animalPage extends AppCompatActivity {

    private List<Animal> animalList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_page);

        try {
            initAnimals();
        } catch (IOException e) {
            e.printStackTrace();
        }
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.animal_show);
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        AnimalAdapter animalAdapter=new AnimalAdapter(animalList);
        recyclerView.setAdapter(animalAdapter);
    }
    private void initAnimals() throws IOException {

        File sdCardDir= Environment.getExternalStorageDirectory();
        String filepath=sdCardDir.getCanonicalPath()+"/"+"Animallll.txt";

        //String filePath_content="";
        File file=new File(filepath);
        if(file.isDirectory()){
            Log.d("animalPage","the File doesn't exist");
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
                        Animal animalImage=new Animal(line);
                        animalList.add(animalImage);
                    }
                    inputStream.close();
                }
            }catch (FileNotFoundException e){
                Log.d("aniamlPage","the File doesn't exist");
            }catch (IOException e){
                Log.d("animalPage",e.getMessage());
            }
        }

    }
}