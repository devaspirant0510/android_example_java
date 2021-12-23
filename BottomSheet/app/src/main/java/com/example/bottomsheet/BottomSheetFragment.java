package com.example.bottomsheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetFragment extends BottomSheetDialogFragment {
    Button button;
    EditText editText;
    MainActivity activity;
    private CallbackMessage message = null;

    public interface CallbackMessage{
        public void sendData(String str);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity)getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottomsheet,container,false);

        init(view);
        return view;
    }

    private void init(View view) {
        button = view.findViewById(R.id.submit);
        editText = view.findViewById(R.id.input);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getText = editText.getText().toString();
                activity.sendMessage(getText);
                dismiss();
            }
        });
    }

    public void CallbackMessage(CallbackMessage listener){
        this.message =  listener;
    }
    public void sendData(String msg){
        message.sendData(msg);
    }

}
