package com.example.bottomnavi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bottomnavi.databinding.Frag2Binding;

public class Fr2 extends Fragment {
    private View root;
    private Frag2Binding mb;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mb = Frag2Binding.inflate(getLayoutInflater());
        root = mb.getRoot();
        return root;

    }
}
