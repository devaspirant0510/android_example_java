package com.example.bottomnavi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bottomnavi.databinding.Frag5Binding;

public class Fr5 extends Fragment {
    private View root;
    private Frag5Binding mb;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mb = Frag5Binding.inflate(getLayoutInflater());
        root = mb.getRoot();
        return root;

    }
}
