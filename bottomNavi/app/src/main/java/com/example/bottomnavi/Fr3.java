package com.example.bottomnavi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bottomnavi.databinding.Frag3Binding;

public class Fr3 extends Fragment {
    private View root;
    private Frag3Binding mb;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mb = Frag3Binding.inflate(getLayoutInflater());
        root = mb.getRoot();
        return root;

    }
}
