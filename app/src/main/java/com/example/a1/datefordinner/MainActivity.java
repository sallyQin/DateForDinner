package com.example.a1.datefordinner;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    MyAdapter myAdapter;
    FloatingActionButton faBtn;
    LinearLayout pull_down_linear,whole_layout,position_id;
    TextView location_txt,age18;
    TextView confirmed_btn;
    ImageView no_sex_pic,sex_male_pic,sex_female_pic,delete_icon,myTreat_pic,AA_pic,femaleFree_pic;
    SimpleDraweeView filter_btn,position_pic;
    RecyclerView myRecycler;
    ImageView moving_pic;
    ScrollView scrollView;
    SeekBar id_seekBar;
    int whole_height,startTop;
    int divisor = 1;//除数
    String  sex_show_pic = "男女不限";
    String cost_show_txt = "AA";
    int gender = 0;
    final static int REQUESTCODE_POSITION = 2;

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
        myRecycler = (RecyclerView) findViewById(R.id.myRecycler);
        moving_pic = (ImageView) findViewById(R.id.moving_pic);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        whole_layout = (LinearLayout) findViewById(R.id.whole_layout);
        id_seekBar = (SeekBar) findViewById(R.id.id_seekBar);
        age18 = (TextView) findViewById(R.id.age18);
        position_id = (LinearLayout) findViewById(R.id.position_id);
        position_pic = (SimpleDraweeView) findViewById(R.id.position_pic);


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
        moving_pic.setOnClickListener(this);
        position_id.setOnClickListener(this);//定位
        whole_height = whole_layout.getHeight();


        id_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { //设置筛选的年龄
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int seekProgress = id_seekBar.getProgress();
                if(seekProgress<= 2){
                    age18.setText("18");
                }else if(seekProgress<= 4){
                    age18.setText("19");
                }else if(seekProgress<= 6){
                    age18.setText("20");
                }else if(seekProgress<= 8){
                    age18.setText("21");
                }else if(seekProgress<= 10){
                    age18.setText("22");
                }else if(seekProgress<= 12){
                    age18.setText("23");
                }else if(seekProgress<= 14){
                    age18.setText("24");
                }else if(seekProgress<= 16){
                    age18.setText("25");
                }else if(seekProgress<= 18){
                    age18.setText("26");
                }else if(seekProgress<= 20){
                    age18.setText("27");
                }else if(seekProgress<= 22){
                    age18.setText("28");
                }else if(seekProgress<= 24){
                    age18.setText("29");
                }else if(seekProgress<= 26){
                    age18.setText("30");
                }else if(seekProgress<= 28){
                    age18.setText("31");
                }else if(seekProgress<= 30){
                    age18.setText("32");
                }else if(seekProgress<= 32){
                    age18.setText("33");
                }else if(seekProgress<= 34){
                    age18.setText("34");
                }else if(seekProgress> 49){
                    age18.setText("49");
                }else {
                    age18.setText(""+progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        //       LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(50/divisor, LinearLayout.LayoutParams.WRAP_CONTENT +startTop);
//        layoutParams.setMargins(0,200,4,0);
//         LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)moving_pic.getLayoutParams();
//         moving_pic.setLayoutParams(layoutParams);
        //  moving_pic.setY(startTop);
//         float width = whole_layout.getWidth();
//         moving_pic.setX(width - 26/divisor);

//        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                startTop = whole_height - scrollY;
//
//                }
//
//        });


//        /********************监听ScrollView滑动停止*****************************/
//             scrollView.setOnTouchListener(new OnTouchListener() {
//            private int lastY = 0;
//            private int touchEventId = -9983761;
//            Handler handler = new Handler() {
//                @Override
//                public void handleMessage(Message msg) {
//                    super.handleMessage(msg);
//                    View scroller = (View) msg.obj;
//
//                    if (msg.what == touchEventId) {
//                        if (lastY == scroller.getScrollY()) {
//                            //停止了，此处你的操作业务
//                            divisor = 1;
//                            moving_pic.postInvalidate();
//
//                        } else {
//                            handler.sendMessageDelayed(handler.obtainMessage(touchEventId, scroller), 1);
//                            lastY = scroller.getScrollY();
//                            divisor = 2;
//                            moving_pic.postInvalidate();
//                        }
//                    }
//                }
//            };
//
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//               // isScoll = false;
//                int eventAction = event.getAction();
//                int y = (int) event.getRawY();
//                switch (eventAction) {
//                    case MotionEvent.ACTION_UP:
//
//                        handler.sendMessageDelayed(handler.obtainMessage(touchEventId, v), 5);
//
//                        break;
//                    default:
//                        break;
//                }
//                return false;
//            }
//
//
//        });
///***********************************************************/


        no_sex_pic.setSelected(true);
        AA_pic.setSelected(true);
        pull_down_linear.setVisibility(View.GONE);
        location_txt.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG); //下划线
        location_txt.getPaint().setAntiAlias(true);//抗锯齿
        confirmed_btn.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG); //下划线
        confirmed_btn.getPaint().setAntiAlias(true);//抗锯齿
        myAdapter = new MyAdapter(this);
        myAdapter.mMainActivity = this;
        myRecycler.setAdapter(myAdapter);

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
                gender = 0;
                no_sex_pic.setSelected(true);
                sex_male_pic.setSelected(false);
                sex_female_pic.setSelected(false);
                break;
            case R.id.sex_male_pic:
                gender = 1;
                sex_show_pic = "male_sex_logo";
                sex_male_pic.setSelected(true);
                no_sex_pic.setSelected(false);
                sex_female_pic.setSelected(false);
                break;
            case R.id.sex_female_pic:
                gender = 1;
                sex_show_pic = "female_sex_logo";
                sex_female_pic.setSelected(true);
                no_sex_pic.setSelected(false);
                sex_male_pic.setSelected(false);
                break;
            case R.id.myTreat_pic:
                cost_show_txt = "我请客";
                myTreat_pic.setSelected(true);
                AA_pic.setSelected(false);
                femaleFree_pic.setSelected(false);
                break;
            case R.id.AA_pic:
                cost_show_txt = "AA";
                AA_pic.setSelected(true);
                myTreat_pic.setSelected(false);
                femaleFree_pic.setSelected(false);
                break;
            case R.id.femaleFree_pic:
                cost_show_txt = "男A女免";
                femaleFree_pic.setSelected(true);
                myTreat_pic.setSelected(false);
                AA_pic.setSelected(false);
                break;
            case R.id.moving_pic://跳转到“约会须知”
                Intent intent1 = new Intent(this,NotesActivity.class);
                startActivity(intent1);
                break;
            case R.id.position_id://跳转到“定位界面”
//                position_pic.setAspectRatio(0.73f);
//                position_pic.setImageURI(Uri.parse("res:///" + getResources().getIdentifier("map_icon","drawable",getPackageName())));
                Intent intent2 = new Intent(MainActivity.this,LocationActivity.class);
                startActivityForResult(intent2,REQUESTCODE_POSITION);
                break;
            case R.id.confirmed_btn://确定 按钮
                if(gender == 0){
                    myAdapter.loader.setSelection("cost_show_txt = ? AND age_show_txt >= ?");
                    myAdapter.loader.setSelectionArgs(new String[]{cost_show_txt,age18.getText().toString(),});
                }else{
                    myAdapter.loader.setSelection("cost_show_txt = ? AND sex_show_pic = ? AND age_show_txt >= ?");
                    myAdapter.loader.setSelectionArgs(new String[]{cost_show_txt,sex_show_pic,age18.getText().toString(),});
                }
                pull_down_linear.setVisibility(View.GONE);
                getSupportLoaderManager().restartLoader(0, null, myAdapter);
                break;
        }
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            switch (requestCode){
                case REQUESTCODE_POSITION:
                    String realLocationStr = data.getStringExtra("realLocation");
                    location_txt.setText(realLocationStr);
                    position_pic.setAspectRatio(0.73f);
                    position_pic.setImageURI(Uri.parse("res:///" + getResources().getIdentifier("map_icon","drawable",getPackageName())));
                    break;
            }
        }

    }
}
