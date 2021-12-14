package com.wyjson.circlefriendsdemo.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.wyjson.circlefriendsdemo.R;

public class MainActivity extends FragmentActivity {

    private ImageView ivAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivAvatar = findViewById(R.id.iv_avatar);
        setUserAvatar();
    }

    public void onClickOpen(View view) {
        CircleFriendsActivity.go(this);
    }

    private void setUserAvatar() {
        SharedPreferences sp = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        if (sp.getInt("avatar", 1) == 1) {
            ivAvatar.setImageDrawable(ContextCompat.getDrawable(this, R.mipmap.avatar_1));
        } else {
            ivAvatar.setImageDrawable(ContextCompat.getDrawable(this, R.mipmap.avatar_2));
        }
    }

    public void onClickUpdateAvatar(View view) {
        SharedPreferences sp = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        sp.edit().putInt("avatar", ~sp.getInt("avatar", 1) + 1).apply();
        setUserAvatar();
    }
}