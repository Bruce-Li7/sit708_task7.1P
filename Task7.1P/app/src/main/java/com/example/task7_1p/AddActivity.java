package com.example.task7_1p;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddActivity extends Activity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.imgv_return)
    ImageView imgv_return;

    @BindView(R.id.tvCommit)
    TextView tvCommit;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.edt_1)
    EditText edt_1;
    @BindView(R.id.edt_2)
    EditText edt_2;
    @BindView(R.id.edt_3)
    EditText edt_3;
    @BindView(R.id.edt_4)
    EditText edt_4;
    @BindView(R.id.edt_5)
    EditText edt_5;
    String type = "Lost";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);

        tvTitle.setText("CREATE A NEW ADVERT");

        imgv_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_1) {
                    type = "Lost";

                } else {
                    type = "Found";

                }
            }
        });


        tvCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp1 = edt_1.getText().toString();
                String temp2 = edt_2.getText().toString();
                String temp3 = edt_3.getText().toString();
                String temp4 = edt_4.getText().toString();
                String temp5 = edt_5.getText().toString();
                if (isEmpty(temp1) || isEmpty(temp2) || isEmpty(temp3) || isEmpty(temp4) || isEmpty(temp5)) {
                    Toast.makeText(AddActivity.this, " Incomplete information ", Toast.LENGTH_SHORT).show();
                    return;
                }

                MySqliteOpenHelper.insert(AddActivity.this,
                        temp1, temp2, temp3, temp4, temp5,
                        type);
                Toast.makeText(AddActivity.this, " Set successfully ", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }


    public static String getTodayData_3() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = df.format(new Date());
        return str;
    }

    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input) || "null".equalsIgnoreCase(input)) {
            return true;
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }
}