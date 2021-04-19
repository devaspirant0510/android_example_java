package com.example.chipgroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.chip.ChipGroup;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private ChipGroup chipGroup1, chipGroup2, chipGroup3;
    private EditText editText1, editText2;
    private Button button, checkChipGroup3;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        chipGroup1Event();
        chipGroup2Event();
        chipGroup3Event();
    }
    public void init() {
        chipGroup1 = findViewById(R.id.chipGroup);
        chipGroup2 = findViewById(R.id.chipGroup2);
        chipGroup3 = findViewById(R.id.chipGroup3);
        editText1 = findViewById(R.id.et_content);
        editText2 = findViewById(R.id.et_content2);
        button = findViewById(R.id.btn_submit);
        checkChipGroup3 = findViewById(R.id.btn_check_chip_group3);
    }
    private void chipGroup1Event(){
        // 상단에 있는 버튼 누를시 EditText 값 PickGroup 에 추가
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getName = editText1.getText().toString();
                Chip chip = new Chip(MainActivity.this);
                // EditText 에 특정 입력값을 넣으면 Pick 에 아이콘 추가
                // 정규식
                String patternLoc = "\\[loc\\].+"; //[loc]문자열 일때
                String patternMail = "\\[mail\\].+"; //[mail]문자열 일때
                String patternPhone = "\\[phone\\].+"; //[phone]문자열 일때
                String val = editText1.getText().toString();
                boolean isLoc = Pattern.matches(patternLoc, val);
                boolean isMail = Pattern.matches(patternMail, val);
                boolean isPhone = Pattern.matches(patternPhone, val);
                if (isLoc) {
                    String[] getArray = val.split("]");
                    chip.setText(getArray[1]);
                    // 선택기능 막음
                    chip.setCheckable(false);
                    // 아이콘 리소스 설정
                    chip.setChipIconResource(R.drawable.location);
                    // 삭제버튼 활성화 (단, 콜백리스너에서 구현해야 삭제됨)
                    chip.setCloseIconVisible(true);
                    chipGroup1.addView(chip);

                } else if (isMail) {
                    String[] getArray = val.split("]");

                    chip.setText(getArray[1]);
                    chip.setCheckable(false);
                    chip.setChipIconResource(R.drawable.mail);
                    chip.setCloseIconVisible(true);
                    chipGroup1.addView(chip);

                } else if (isPhone) {
                    String[] getArray = val.split("]");

                    chip.setText(getArray[1]);
                    chip.setCheckable(false);
                    chip.setChipIconResource(R.drawable.phone);
                    chip.setCloseIconVisible(true);
                    chipGroup1.addView(chip);

                } else {
                    chip.setText(getName);
                    chip.setCheckable(false);
                    chip.setCloseIconVisible(true);
                    chipGroup1.addView(chip);

                }
                // 입력하면 editText 값 초기화
                editText1.setText("");
                // 삭제  기능 구현
                chip.setOnCloseIconClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        chipGroup1.removeView(chip);
                    }
                });
            }
        });
    }

    private void chipGroup2Event(){
        // EditText 에서 띄어쓰기 할때마다 자동으로 Pick 추가
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                // 마지막 문자열이 공백이면서 입력한 문자열의 길이가 1보다 클때
                if (s.charAt(s.length() - 1) == ' ' && s.length() > 1) {
                    // Chip 생성
                    Chip chip = new Chip(MainActivity.this);
                    // 삭제버튼 활성화
                    chip.setCloseIconVisible(true);
                    chip.setText(s);
                    // 삭제 기능 구현
                    chip.setOnCloseIconClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            chipGroup2.removeView(chip);
                        }
                    });
                    // 추가할시 ChipGroup 에서 EditText 앞에다 추가
                    chipGroup2.addView(chip, chipGroup2.getChildCount()-1);
                    try {
                        // 추가하면
                        editText2.setText("");

                    } catch (Exception e) {

                    }
                }
            }
        });

    }

    private void chipGroup3Event(){
        checkChipGroup3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String checkChip = "";
                for (int i : chipGroup3.getCheckedChipIds()) {
                    Chip chip = (Chip) chipGroup3.getChildAt(i - 1);

                    checkChip = String.format("%s %s ", checkChip, chip.getText());
                }
                Toast.makeText(MainActivity.this, checkChip, Toast.LENGTH_SHORT).show();
            }
        });
        for (int i = 0; i < chipGroup3.getChildCount(); i++) {
            Chip chip = (Chip) chipGroup3.getChildAt(i);
            chip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        chip.setChipIconVisible(false);
                    } else {
                        chip.setChipIconVisible(true);
                    }
                }
            });
        }
    }
}