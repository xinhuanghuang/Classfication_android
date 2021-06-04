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

public class toolPage extends AppCompatActivity {

    private List<Tool> toolList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_page);

        try {
            initTools();
        } catch (IOException e) {
            e.printStackTrace();
        }
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.tool_show);
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        ToolAdapter toolAdapter=new ToolAdapter(toolList);
        recyclerView.setAdapter(toolAdapter);
    }
    public void initTools() throws IOException {
        //Intent intent_4=getIntent();
        //String getdetectImagePath=intent_4.getStringExtra("detect_image_path");
        //Tool tool_1=new Tool(getdetectImagePath);
        //toolList.add(tool_1);
        File sdCardDir= Environment.getExternalStorageDirectory();
        String filepath=sdCardDir.getCanonicalPath()+"/"+"toollll.txt";

        //String filePath_content="";
        File file=new File(filepath);
        if(file.isDirectory()){
            Log.d("toolPage","the File doesn't exist");
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
                        Tool toolImage=new Tool(line);
                        toolList.add(toolImage);
                    }
                    inputStream.close();
                }
            }catch (FileNotFoundException e){
                Log.d("toolPage","the File doesn't exist");
            }catch (IOException e){
                Log.d("toolPage",e.getMessage());
            }
        }
    }
}