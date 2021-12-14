package com.wyjson.circlefriendsdemo.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wyjson.circlefriendsdemo.R;
import com.wyjson.circlefriendsdemo.adapter.CircleFriendsAdapter;

import java.lang.ref.WeakReference;

/**
 * 实现微信朋友圈再次打开,恢复上次页面状态
 */
public class CircleFriendsFragment extends Fragment {

    private static WeakReference<CircleFriendsFragment> weakReference;

    public static CircleFriendsFragment getInstance() {
        if (weakReference == null || weakReference.get() == null)
            weakReference = new WeakReference<>(new CircleFriendsFragment());
        return weakReference.get();
    }

    public static void clearInstance() {
        if (weakReference != null)
            weakReference.clear();
        weakReference = null;
    }

    public static CircleFriendsFragment showFragment() {
        return getInstance();
    }

    protected View rootView;

    private Button btnTest;
    private TextView tvTest;
    private ImageView ivAvatar;
    private EditText etContent;
    private RecyclerView rvList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null != rootView) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
        } else {
            rootView = inflater.inflate(R.layout.fragment_circle_friends, null);
            initView();
        }
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUserAvatar();
    }

    private void setUserAvatar() {
        SharedPreferences sp = getContext().getSharedPreferences("user_info", Context.MODE_PRIVATE);
        if (sp.getInt("avatar", 1) == 1) {
            ivAvatar.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.avatar_1));
        } else {
            ivAvatar.setImageDrawable(ContextCompat.getDrawable(getContext(), R.mipmap.avatar_2));
        }
    }

    private void initView() {
        ivAvatar = rootView.findViewById(R.id.iv_avatar);
        btnTest = rootView.findViewById(R.id.btn_test);
        tvTest = rootView.findViewById(R.id.tv_test);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTest.setText("修改");
                etContent.setText("修改");
            }
        });
        etContent = rootView.findViewById(R.id.et_content);

        rvList = rootView.findViewById(R.id.rv_list);
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvList.setAdapter(new CircleFriendsAdapter());
    }
}
