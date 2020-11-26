package com.example.ratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import javax.crypto.Cipher;

public class SubActivity extends AppCompatActivity {
    private RatingBar ratingBar;
    private EditText starLength,stepSize;
    private Button starLengthAccept,isIndicatorF,isIndicatorT,stepSizeAccept,starCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        // ratingBar id 랑 연결
        ratingBar = (RatingBar)findViewById(R.id.rating_bar);
        // EditText
        starLength = (EditText)findViewById(R.id.starLength);
        stepSize = (EditText)findViewById(R.id.stepSize);

        // Button
        starLengthAccept = (Button)findViewById(R.id.startLengthAccept);
        isIndicatorF =(Button)findViewById(R.id.isIndicatorF);
        isIndicatorT = (Button)findViewById(R.id.isIndicatorT);
        stepSizeAccept = (Button)findViewById(R.id.stepSizeAccept);
        starCount = (Button)findViewById(R.id.starCount);


        // isIndicator 권한 차단 기능을 눌렀을때
        isIndicatorF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ratingBar.setIsIndicator(true);
                Toast.makeText(getApplicationContext(),"별점 주기 권한을 빼앗겼습니다.",Toast.LENGTH_SHORT).show();

            }
        });
        //  isIndicator 권한 허용 기능을 눌렀을때
        isIndicatorT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingBar.setIsIndicator(false);
                Toast.makeText(getApplicationContext(),"별점주기 권한을 가져왔습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        // 화면에 표시할 별의 개수
        starLengthAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int startLen = Integer.parseInt(String.valueOf(starLength.getText()));

                if (startLen > 10) {
                    Toast.makeText(getApplicationContext(), "화면이 꽉 차버리니까 10 이하로 부탁합니다.", Toast.LENGTH_SHORT).show();
                } else {
                    ratingBar.setNumStars(startLen);
                }

            }
        });
        // 한칸마다 움직일 별의수
        stepSizeAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float stepSizeNum = Float.parseFloat(String.valueOf(stepSize.getText()));

                ratingBar.setStepSize(stepSizeNum);


            }
        });
        // 별의 개수 구함
        starCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float startCountFl = ratingBar.getRating();

                String msg = "현재 별의 개수는 "+String.valueOf(startCountFl);
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();


            }
        });




    }

}