package com.example.Toast_SnackBar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout relLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relLayout = (RelativeLayout)findViewById(R.id.relLayout);
    }

    public void onClickToast(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),"Toast",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.FILL_HORIZONTAL,0,50);

        toast.show();
    }

    public void onClickSnack(View view) {
        final Snackbar snackbar = Snackbar.make(relLayout, "확인버튼을 눌러야 종료됩니다.", BaseTransientBottomBar.LENGTH_INDEFINITE);
        snackbar.setAction("확인", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }
}