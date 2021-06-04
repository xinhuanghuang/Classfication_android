package com.yeyupiaoling.tfliteclassification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Button animal_button=(Button) findViewById(R.id.animals);
        Button plant_button=(Button) findViewById(R.id.zhiwu);
        Button tool_button=(Button) findViewById(R.id.tool);
        animal_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(list.this, animalPage.class);
                startActivity(intent);
            }
        });
        plant_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(list.this, plantPage.class);
                startActivity(intent);
            }
        });
        tool_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(list.this, toolPage.class);
                startActivity(intent);
            }
        });
    }
}