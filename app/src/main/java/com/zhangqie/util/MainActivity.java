package com.zhangqie.util;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zhangqie.util.demo1.ImageActivity;


public class MainActivity extends AppCompatActivity {

    private String[] strings = new String[]{"图片压缩工具类","1","2","3","3"
            };


    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView(){
        listView = findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strings);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showIntent(position);
            }
        });
    }

    private void showIntent(int position){
        Intent intent = null;
        if (position == 0){
            intent = new Intent(MainActivity.this, ImageActivity.class);
        }
        else if (position == 1){
            intent = new Intent(MainActivity.this, ImageActivity.class);
        }else if (position == 2){
            intent = new Intent(MainActivity.this, ImageActivity.class);
        }else if (position ==3 ){
            intent = new Intent(MainActivity.this, ImageActivity.class);
        }else if (position ==4 ){
            intent = new Intent(MainActivity.this, ImageActivity.class);
        }else if (position == 5){
            intent = new Intent(MainActivity.this, ImageActivity.class);
        }else if (position == 6){
            intent = new Intent(MainActivity.this, ImageActivity.class);
        }else if (position == 7){
            intent = new Intent(MainActivity.this, ImageActivity.class);
        }else if (position == 8){
            intent = new Intent(MainActivity.this, ImageActivity.class);
        }else if (position == 9){
            intent = new Intent(MainActivity.this, ImageActivity.class);
        }else if (position == 10){
            intent = new Intent(MainActivity.this, ImageActivity.class);
        }
        else if (position == 11){
            intent = new Intent(MainActivity.this, ImageActivity.class);
        }else if (position == 12){
            intent = new Intent(MainActivity.this, ImageActivity.class);
        }
        else if (position == 13){
            intent = new Intent(MainActivity.this, ImageActivity.class);

        }else if(position == 14){
            intent = new Intent(MainActivity.this, ImageActivity.class);
        }else if (position == 15){
            intent = new Intent(MainActivity.this, ImageActivity.class);

        }else if (position == 16){
            intent = new Intent(MainActivity.this, ImageActivity.class);

        }
        startActivity(intent);
    }

}
