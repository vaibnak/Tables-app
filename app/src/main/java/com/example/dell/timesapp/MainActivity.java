package com.example.dell.timesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    ListView listView;
    public  void  updatelist(int a){
    ArrayList<Integer> num = new ArrayList<Integer>();
        TextView tx = (TextView)findViewById(R.id.txt);
        tx.setText("table of :" + Integer.toString(a));
    for(int i = 1; i <= 10; i++){
        num.add(i*a);
    }
    listView = (ListView)findViewById(R.id.lst);
    ArrayAdapter<Integer>arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, num );
    listView.setAdapter(arrayAdapter);
}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seek = (SeekBar)findViewById(R.id.skb);
        seek.setMax(20);
        seek.setProgress(10);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("value of i :", Integer.toString(i));
                int min = 1;
                int curvalue;
                if(i < min){
                    curvalue = min;
                }else {
                    curvalue = i;
                }
                updatelist(curvalue);
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        updatelist(10);



    }



}
