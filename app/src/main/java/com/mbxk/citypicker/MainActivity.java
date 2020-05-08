package com.mbxk.citypicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.mbxk.citypickerlibrary.CityPicker;
import com.mbxk.citypickerlibrary.adapter.OnPickListener;
import com.mbxk.citypickerlibrary.model.City;
import com.mbxk.citypickerlibrary.model.LocateState;
import com.mbxk.citypickerlibrary.model.LocatedCity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.DefaultCityPickerTheme);
        setContentView(R.layout.activity_main);


    }

    public void btntet(View view) {
        CityPicker.from(MainActivity.this)
                .enableAnimation(true)
                .setLocatedCity(null)
                .setOnPickListener(new OnPickListener() {
                    @Override
                    public void onPick(int position, City data) {

                        Toast.makeText(
                                getApplicationContext(),
                                String.format("点击的数据：%s，%s", data.getName(), data.getCode()),
                                Toast.LENGTH_SHORT)
                                .show();
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getApplicationContext(), "取消选择", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLocate() {
                        //开始定位，这里模拟一下定位
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                CityPicker.from(MainActivity.this).locateComplete(new LocatedCity("深圳", "广东", "101280601"), LocateState.SUCCESS);
                            }
                        }, 3000);
                    }
                })
                .show();
    }
}
