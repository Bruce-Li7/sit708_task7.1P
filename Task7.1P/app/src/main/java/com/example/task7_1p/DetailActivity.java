package com.example.task7_1p;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends Activity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.imgv_return)
    ImageView imgv_return;

    @BindView(R.id.tvCommit)
    TextView tvCommit;

    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.tv5)
    TextView tv5;
    @BindView(R.id.tv6)
    TextView tv6;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        tvTitle.setText("Detail");


        imgv_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, ListActivity.class);
                startActivity(intent);
                onBackPressed();
            }
        });
        Bean bean = (Bean) getIntent().getSerializableExtra("bean");
        tv1.setText(bean.type);
        tv2.setText(bean.value0);
        tv3.setText(bean.value1);
        tv4.setText(bean.value2);
        tv5.setText(bean.value3);
        tv6.setText(bean.value4);


        tvCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySqliteOpenHelper.delete(DetailActivity.this,bean._id);

                Intent intent = new Intent(DetailActivity.this, ListActivity.class);
                startActivity(intent);
                onBackPressed();
            }
        });


    }


}