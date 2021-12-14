package com.wyjson.circlefriendsdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.wyjson.circlefriendsdemo.R;
import com.wyjson.circlefriendsdemo.fragment.CircleFriendsFragment;

public class CircleFriendsActivity extends FragmentActivity {

    private static CircleFriendsActivity mInstance;
    private static boolean isQuickAgainOpen;

    public static void go(Context context) {
        if (mInstance != null) {
            isQuickAgainOpen = true;
        } else {
            context.startActivity(new Intent(context, CircleFriendsActivity.class));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInstance = this;
        setContentView(R.layout.activity_circle_friends);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        CircleFriendsFragment circleFriendsFragment = CircleFriendsFragment.showFragment();
        transaction.add(R.id.fl_content, circleFriendsFragment, circleFriendsFragment.getClass().getSimpleName());
        transaction.commit();
    }

    @Override
    protected void onDestroy() {
        mInstance = null;
        super.onDestroy();
        if (isQuickAgainOpen) {
            isQuickAgainOpen = false;
            go(this);
        }
    }
}