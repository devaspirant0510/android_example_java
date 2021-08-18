package com.example.fragmentwithnavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author : seungHo
 * @since : 2021-08-18
 * class : Fragment2.java
 * github : devaspirant0510
 * email : seungho020510@gmail.com
 * description :
 */
public class Fragment2 extends Fragment {
    private static final String TAG = Fragment2.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2,container,false);
        return view;
    }
}
