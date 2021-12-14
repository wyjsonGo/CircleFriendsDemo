package com.wyjson.circlefriendsdemo.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

import androidx.fragment.app.FragmentActivity;

import com.wyjson.circlefriendsdemo.R;


public class SplashActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();
        handler.sendEmptyMessageDelayed(1, 1000);
    }

    @SuppressLint("HandlerLeak")
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }
    };
}
