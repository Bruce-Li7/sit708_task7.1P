package com.example.task7_1p;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelActivity extends Activity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.imgv_return)
    ImageView imgv_return;
    @BindView(R.id.bt0)
    Button bt0;
    @BindView(R.id.bt1)
    Button bt1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sel);
        ButterKnife.bind(this);

        SQLiteOpenHelper helper = MySqliteOpenHelper.getInstance(this);

        SQLiteDatabase readableDatabase = helper.getReadableDatabase();

        //0
        tvTitle.setText("HOME");
        imgv_return.setVisibility(View.INVISIBLE);

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelActivity.this, AddActivity.class));
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelActivity.this, ListActivity.class));
            }
        });
    }


}