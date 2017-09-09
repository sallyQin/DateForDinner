package com.example.a1.datefordinner;

import android.content.Intent;
import android.graphics.Paint;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    FloatingActionButton faBtn;
    LinearLayout pull_down_linear;
    TextView location_txt;
    TextView confirmed_btn;
    ImageView no_sex_pic,sex_male_pic,sex_female_pic,delete_icon,myTreat_pic,AA_pic,femaleFree_pic;
    SimpleDraweeView filter_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        location_txt = (TextView) findViewById(R.id.location_txt);
        pull_down_linear = (LinearLayout) findViewById(R.id.pull_down_linear);
        confirmed_btn = (TextView) findViewById(R.id.confirmed_btn);
        delete_icon = (ImageView) findViewById(R.id.delete_pic);
        no_sex_pic = (ImageView) findViewById(R.id.no_sex_pic);
        sex_male_pic = (ImageView) findViewById(R.id.sex_male_pic);
        sex_female_pic = (ImageView) findViewById(R.id.sex_female_pic);
        myTreat_pic = (ImageView) findViewById(R.id.myTreat_pic);
        AA_pic = (ImageView) findViewById(R.id.AA_pic);
        femaleFree_pic = (ImageView) findViewById(R.id.femaleFree_pic);
        filter_btn = (SimpleDraweeView) findViewById(R.id.filter_btn);
        faBtn = (FloatingActionButton) findViewById(R.id.fab);


        faBtn.setOnClickListener(this);//浮动按钮
        pull_down_linear.setOnClickListener(this);//下拉的筛选的linearlayout
        filter_btn.setOnClickListener(this);//筛选按钮
        confirmed_btn.setOnClickListener(this);
        delete_icon.setOnClickListener(this);
        no_sex_pic.setOnClickListener(this);
        sex_male_pic.setOnClickListener(this);
        sex_female_pic.setOnClickListener(this);
        myTreat_pic.setOnClickListener(this);
        AA_pic.setOnClickListener(this);
        femaleFree_pic.setOnClickListener(this);

        no_sex_pic.setSelected(true);
        AA_pic.setSelected(true);
        pull_down_linear.setVisibility(View.GONE);
        location_txt.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG); //下划线
        location_txt.getPaint().setAntiAlias(true);//抗锯齿
        confirmed_btn.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG); //下划线
        confirmed_btn.getPaint().setAntiAlias(true);//抗锯齿


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                Intent intent = new Intent(MainActivity.this,AddDateActivity.class);
                startActivity(intent);
                break;
            case R.id.delete_pic:
                pull_down_linear.setVisibility(View.GONE);
                break;
            case R.id.filter_btn:
                pull_down_linear.setVisibility(View.VISIBLE);
                break;
            case R.id.no_sex_pic:
                no_sex_pic.setSelected(true);
                sex_male_pic.setSelected(false);
                sex_female_pic.setSelected(false);
                break;
            case R.id.sex_male_pic:
                sex_male_pic.setSelected(true);
                no_sex_pic.setSelected(false);
                sex_female_pic.setSelected(false);
                break;
            case R.id.sex_female_pic:
                sex_female_pic.setSelected(true);
                no_sex_pic.setSelected(false);
                sex_male_pic.setSelected(false);
                break;
            case R.id.myTreat_pic:
                myTreat_pic.setSelected(true);
                AA_pic.setSelected(false);
                femaleFree_pic.setSelected(false);
                break;
            case R.id.AA_pic:
                AA_pic.setSelected(true);
                myTreat_pic.setSelected(false);
                femaleFree_pic.setSelected(false);
                break;
            case R.id.femaleFree_pic:
                femaleFree_pic.setSelected(true);
                myTreat_pic.setSelected(false);
                AA_pic.setSelected(false);
                break;
        }
    }
}
