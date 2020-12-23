package com.tenny.networkdemo;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tenny.networkdemo.entiy.GPSEntity;
import com.tenny.networkdemo.network.CallBack;
import com.tenny.networkdemo.network.NetWorkDemo;
import com.tenny.networkdemo.utils.SystemUtils;

/**
 * Created by TennyQ on 12/23/20
 */
public class MainActivity2 extends AppCompatActivity {

    private NetWorkDemo netWorkDemo = new NetWorkDemo(new CallBack<GPSEntity>() {
        @Override
        public void success(GPSEntity result) {
            if (SystemUtils.isHostValidate(MainActivity2.this)) {
                return;
            }
            showToast(result.toString());
        }

        @Override
        public void failed(String errorMsg) {
            if (SystemUtils.isHostValidate(MainActivity2.this)) {
                return;
            }
            showToast(errorMsg);
        }
    });

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        netWorkDemo.release();
    }

    public void showToast(String content) {
        if (!TextUtils.isEmpty(content)){
            Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
        }
    }

}
