package com.example.a1.datefordinner;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddDateActivity extends AppCompatActivity implements View.OnClickListener {
    TextView cancel_txt;
    TextView publish_txt;
    ImageView male_icon,female_icon,person_icon,male_logo,female_logo;
    TextView male_txt,female_txt,person_txt,date_text,time_text;
    LinearLayout male_liner,female_liner,person_liner,date_linear,time_linear,timeDatePicker_id,nickname_linear;
    CheckBox cbx_2persons,cbx_5persons,cbx_10persons,cbx_myTreat,cbx_AA,cbx_maleAFemaleFree;
    Spinner spinner_nickname,spinner_location;
    SimpleDraweeView avatar_pic;
    DatePicker datePicker;
    TimePicker timePicker;
    private List<String> list_nickname = new ArrayList<>();//创建一个String类型的数组列表
    private ArrayAdapter <String> adapterNickname;//创建一个数组适配器
    private List<String> list_location = new ArrayList<>();//创建一个String类型的数组列表
    private SimpleArrayAdapter<String> adapterLocation;//创建一个数组适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_date_actvity);
        cancel_txt = (TextView) findViewById(R.id.cancel);
        publish_txt = (TextView) findViewById(R.id.publish);
        male_icon = (ImageView) findViewById(R.id.male_icon);
        male_txt = (TextView) findViewById(R.id.male_txt);
        female_txt = (TextView) findViewById(R.id.female_txt);
        person_txt = (TextView) findViewById(R.id.person_txt);
        female_icon = (ImageView) findViewById(R.id.female_icon);
        person_icon = (ImageView) findViewById(R.id.person_icon);
        male_liner = (LinearLayout) findViewById(R.id.male_liner);
        female_liner = (LinearLayout) findViewById(R.id.female_liner);
        person_liner = (LinearLayout) findViewById(R.id.person_liner);
        cbx_2persons = (CheckBox) findViewById(R.id.cbx_2persons);
        cbx_5persons = (CheckBox) findViewById(R.id.cbx_5persons);
        cbx_10persons = (CheckBox) findViewById(R.id.cbx_10persons);
        cbx_myTreat = (CheckBox) findViewById(R.id.cbx_myTreat);
        cbx_AA = (CheckBox) findViewById(R.id.cbx_AA);
        cbx_maleAFemaleFree = (CheckBox) findViewById(R.id.cbx_maleAFemaleFree);
        male_logo = (ImageView) findViewById(R.id.male_logo);
        female_logo = (ImageView) findViewById(R.id.female_logo);
        date_linear = (LinearLayout) findViewById(R.id.date_linear);
        time_linear = (LinearLayout) findViewById(R.id.time_linear);
        datePicker = (DatePicker) findViewById(R.id.dpPicker);
        timePicker = (TimePicker) findViewById(R.id.tpPicker);
        avatar_pic = (SimpleDraweeView) findViewById(R.id.avatar_pic);
        spinner_location = (Spinner) findViewById(R.id.spinner_location);
        spinner_nickname = (Spinner) findViewById(R.id.spinner_nickname);
        date_text = (TextView) findViewById(R.id.date_text);
        time_text = (TextView) findViewById(R.id.time_text);
        nickname_linear = (LinearLayout) findViewById(R.id.nickname_linear);
        timeDatePicker_id = (LinearLayout) findViewById(R.id.timeDatePicker_id);


        datePicker.init(2017, 9, 10, new DatePicker.OnDateChangedListener() {//日期选择器的监听器

            @Override
            public void onDateChanged(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                // 获取一个日历对象，并初始化为当前选中的时间
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat format = new SimpleDateFormat(
                        "yyyy-MM-dd");
                date_text.setText(""+ format.format(calendar.getTime()));
                Toast.makeText(AddDateActivity.this,
                        format.format(calendar.getTime()), Toast.LENGTH_SHORT)
                        .show();
            }
        });

        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {//时间选择器的监听器
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay,
                                      int minute) {
                time_text.setText(""+hourOfDay + "：" + minute);
//                Toast.makeText(AddDateActivity.this,
//                        hourOfDay + "点" + minute + "分",
//                        Toast.LENGTH_SHORT).show();
            }
        });


        avatar_pic.setOnClickListener(this);
        male_liner.setOnClickListener(this);
        female_liner.setOnClickListener(this);
        person_liner.setOnClickListener(this);
        cbx_2persons.setOnClickListener(this);
        cbx_5persons.setOnClickListener(this);
        cbx_10persons.setOnClickListener(this);
        cbx_myTreat.setOnClickListener(this);
        cbx_AA.setOnClickListener(this);
        cbx_maleAFemaleFree.setOnClickListener(this);
        male_logo.setOnClickListener(this);
        female_logo.setOnClickListener(this);
        date_linear.setOnClickListener(this);
        time_linear.setOnClickListener(this);
        nickname_linear.setOnClickListener(this);

        initNickernameList();//设置Nickname的spinner下拉菜单内容
        initLocationList();//设置Location的spinner下拉菜单内容


        male_txt.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG); //下划线
        male_txt.getPaint().setAntiAlias(true);//抗锯齿
        female_txt.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG); //下划线
        female_txt.getPaint().setAntiAlias(true);//抗锯齿
        person_txt.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG); //下划线
        person_txt.getPaint().setAntiAlias(true);//抗锯齿
        cancel_txt.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG); //下划线
        cancel_txt.getPaint().setAntiAlias(true);//抗锯齿
        publish_txt.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG); //下划线
        publish_txt.getPaint().setAntiAlias(true);//抗锯齿
        person_icon.setSelected(true);
        cbx_2persons.setChecked(true);
        cbx_AA.setChecked(true);
        male_logo.setSelected(true);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.avatar_pic://头像
                getInvisible_dateAndtime();
                break;
            case R.id.nickname_linear:
                getInvisible_dateAndtime();
                break;
            case R.id.spinner_location:
                getInvisible_dateAndtime();
                break;
            case R.id.edit_explain:
                getInvisible_dateAndtime();
                break;
            case R.id.male_liner: //约饭对象
                male_icon.setSelected(true);
                female_icon.setSelected(false);
                person_icon.setSelected(false);
                getInvisible_dateAndtime();
                break;
            case R.id.female_liner:
                female_icon.setSelected(true);
                male_icon.setSelected(false);
                person_icon.setSelected(false);
                getInvisible_dateAndtime();
                break;
            case R.id.person_liner:
                person_icon.setSelected(true);
                male_icon.setSelected(false);
                female_icon.setSelected(false);
                getInvisible_dateAndtime();
                break;

            case R.id.cbx_2persons:
                cbx_2persons.setChecked(true);//约饭人数
                cbx_5persons.setChecked(false);
                cbx_10persons.setChecked(false);
                getInvisible_dateAndtime();
                break;
            case R.id.cbx_5persons:
                cbx_5persons.setChecked(true);
                cbx_2persons.setChecked(false);
                cbx_10persons.setChecked(false);
                getInvisible_dateAndtime();
                break;
            case R.id.cbx_10persons:
                cbx_10persons.setChecked(true);
                cbx_2persons.setChecked(false);
                cbx_5persons.setChecked(false);
                getInvisible_dateAndtime();
                break;
            case R.id.cbx_myTreat:
                cbx_myTreat.setChecked(true);//约饭费用
                cbx_AA.setChecked(false);
                cbx_maleAFemaleFree.setChecked(false);
                getInvisible_dateAndtime();
                break;
            case R.id.cbx_AA:
                cbx_AA.setChecked(true);
                cbx_myTreat.setChecked(false);
                cbx_maleAFemaleFree.setChecked(false);
                getInvisible_dateAndtime();
                break;
            case R.id.cbx_maleAFemaleFree:
                cbx_maleAFemaleFree.setChecked(true);
                cbx_myTreat.setChecked(false);
                cbx_AA.setChecked(false);
                getInvisible_dateAndtime();
                break;
            case R.id.male_logo:
                male_logo.setSelected(true);
                female_logo.setSelected(false);
                getInvisible_dateAndtime();
                break;
            case R.id.female_logo:
                female_logo.setSelected(true);
                male_logo.setSelected(false);
                getInvisible_dateAndtime();
                break;
            case R.id.date_linear://日期选择跳转datePicker
                timeDatePicker_id.setVisibility(View.VISIBLE);
                datePicker.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                break;
            case R.id.time_linear://时间选择跳转timePicker
                timeDatePicker_id.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.VISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
                break;

        }
    }

    private void getInvisible_dateAndtime(){
        timeDatePicker_id.setVisibility(View.INVISIBLE);
    }

    private void initNickernameList(){
        // 添加一个下拉列表项的list，这里添加的项就是下拉列表的菜单项，即数据源
        list_nickname.add("垦丁的风情无法定义");
        list_nickname.add("流殇@");
        list_nickname.add("silent 黑白年代");
        list_nickname.add("不疯狂不青春");
        list_nickname.add("不服来战lol");
        list_nickname.add("灾星s");
        list_nickname.add("你的未来我预定了 つ");
        list_nickname.add("骑着蚂蚁去逛街");
        list_nickname.add("巴黎有你═不孤单");
        list_nickname.add("不触碰 AlooF");
        list_nickname.add("不懂,涐别瞎说");
        list_nickname.add("繁星丶春水");
        list_nickname.add("花季、莫浅忆");
        list_nickname.add("一抹浅笑");
        list_nickname.add("浮生若梦");
        list_nickname.add("燃情逝梦");
        list_nickname.add("流泪的微笑");
        list_nickname.add("伸手碰触阳光");
        list_nickname.add("夕阳飘雪");
        list_nickname.add("凌晨つ''唯爱");
        list_nickname.add("罂粟花散漫巴黎の街道");
        list_nickname.add("为你心跳300％");
        list_nickname.add("陌上花开");
        list_nickname.add("凌月");
        list_nickname.add("颜汐梧");
        list_nickname.add("汐黛");
        list_nickname.add("沁雪蓝馨");
        list_nickname.add("月清落花");
        list_nickname.add("弥云裳");
        list_nickname.add("柠檬苏格");

        list_nickname.add("薄荷味的初夏");
        list_nickname.add("左瞳左耳左心房");
        list_nickname.add("心脏太小放你刚好");
        list_nickname.add("光暖如初");
        list_nickname.add("暖阳衬韬");
        list_nickname.add("如阳光伴我");
        list_nickname.add("初衷的味道");
        list_nickname.add("时光柚子");
        list_nickname.add("时光未逝柚子香");
        list_nickname.add("柚子不萌");
        list_nickname.add("知足 Content");
        list_nickname.add("Sadness″逝言");
        list_nickname.add("Half°半路青春");
        list_nickname.add("vagabond 流浪者");
        list_nickname.add("Forever末初");
        list_nickname.add("失忆 amnesia");
        list_nickname.add("盛夏光年");
        list_nickname.add("浅夏柚子");
        list_nickname.add("时光未逝柚子香");
        list_nickname.add("柚子纪年");
        list_nickname.add("fireworks°湮灭");
        list_nickname.add("Dying [逝去]");
        list_nickname.add("柚子经年");
        list_nickname.add("森屿柚子");
        list_nickname.add("欲戴王冠，必承其重");
        list_nickname.add("烟疤德、烙印");
        list_nickname.add("疏烟淡日");
        list_nickname.add("半夏如烟-");
        list_nickname.add("酒青梅奈");
        list_nickname.add("夏秋风");

        adapterNickname = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, list_nickname);
        adapterNickname.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_nickname.setAdapter(adapterNickname);
        getInvisible_dateAndtime();
//        spinner_nickname.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //To do sth
//                // 将所选mySpinner 的值带入myTextView 中
//                //  myTextView.setText("您选择的是：" + adapterNickname.getItem(position));//记录选择的昵称名
//                getInvisible_dateAndtime();
//            }
//        });
    }

    private void initLocationList(){
        // 添加一个下拉列表项的list，这里添加的项就是下拉列表的菜单项，即数据源
        list_location.add("茶餐厅");
        list_location.add("咖啡厅");
        list_location.add("中餐馆");
        list_location.add("西餐厅");
        list_location.add("日本餐厅");
        list_location.add("汉堡店");
        list_location.add("西班牙餐厅");
        list_location.add("墨西哥餐馆");
        list_location.add("火锅店");
        list_location.add("茶室");
        list_location.add("饺子店");
        list_location.add("鸡粥店");
        list_location.add("KFC");
        list_location.add("烧烤店");
        list_location.add("披萨店");
        list_location.add("饮品店");
        list_location.add("面馆");
        list_location.add("酒吧");
        list_location.add("甜品店");
        list_location.add("轻沙拉店");
        list_location.add("请选择想约饭地点");

        adapterLocation = new SimpleArrayAdapter<>(this, R.layout.simple_spinner_item,list_location);
        adapterLocation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_location.setAdapter(adapterLocation);
        spinner_location.setSelection(list_location.size() - 1, true);
//        spinner_location.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //To do sth
//                // 将所选mySpinner 的值带入myTextView 中
//                //  myTextView.setText("您选择的是：" + adapterNickname.getItem(position));//记录选择的昵称名
//                getInvisible_dateAndtime();
//            }
//        });
    }
}
