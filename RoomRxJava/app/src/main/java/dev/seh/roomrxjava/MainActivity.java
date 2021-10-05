package dev.seh.roomrxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import dev.seh.roomrxjava.databinding.ActivityMainBinding;
import dev.seh.roomrxjava.room.database.AppDatabase;
import dev.seh.roomrxjava.room.entitiy.MainEntity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private AppDatabase database;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        database = AppDatabase.getInstance(this);

        event();

    }

    private boolean getRadioGroupGender() {

        return mBinding.rbMale.isChecked();
    }

    private void event() {
        mBinding.btnInsertTable.setOnClickListener(view -> {
            MainEntity entity = new MainEntity();
            entity.setAge(Integer.parseInt(mBinding.etAge.getText().toString()));
            entity.setIntroduce(mBinding.etIntroduce.getText().toString());
            entity.setName(mBinding.etName.getText().toString());
            entity.setGender(getRadioGroupGender());
            database.mainDao().createData(entity)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe();
        });
    }
}