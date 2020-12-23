package com.tenny.networkdemo;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tenny.networkdemo.network.NetWorkDemo;

/**
 * Created by TennyQ on 12/23/20
 */
public class MainActivity2 extends AppCompatActivity {

    private NetWorkDemo netWorkDemo = new NetWorkDemo();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.request).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                netWorkDemo.request();
            }
        });
    }
}
