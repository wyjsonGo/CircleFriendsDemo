package com.wyjson.circlefriendsdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.wyjson.circlefriendsdemo.R;
import com.wyjson.circlefriendsdemo.fragment.CircleFriendsFragment;

/**
 * 实现微信朋友圈再次打开,恢复上次页面状态
 */
public class CircleFriendsActivity extends FragmentActivity {

    private static CircleFriendsActivity mInstance;
    private static boolean isQuickAgainOpen;

    private CircleFriendsFragment mFragment;

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
        findFragment(savedInstanceState);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (mFragment == null) {
            mFragment = CircleFriendsFragment.showFragment();
            fragmentTransaction.add(R.id.fl_content, mFragment, "fragment");
        } else {
            fragmentTransaction.show(mFragment);
        }
        fragmentTransaction.commit();
    }

    private void findFragment(Bundle savedInstanceState) {
        if (savedInstanceState != null)
            mFragment = (CircleFriendsFragment) getSupportFragmentManager().getFragment(savedInstanceState, "fragment");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mFragment != null && mFragment.isAdded())
            getSupportFragmentManager().putFragment(outState, "fragment", mFragment);
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