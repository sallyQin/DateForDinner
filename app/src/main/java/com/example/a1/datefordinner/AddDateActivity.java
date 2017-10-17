package com.example.a1.datefordinner;

import android.content.ContentValues;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class AddDateActivity extends AppCompatActivity implements View.OnClickListener {
    TextView cancel_txt;
    TextView publish_txt;
    ImageView male_icon,female_icon,person_icon,male_logo,female_logo;
    TextView male_txt,female_txt,person_txt,date_text,time_text,age_txt;
    LinearLayout male_liner,female_liner,person_liner,date_linear,time_linear,timeDatePicker_id,nickname_linear,whole_date_liner,sex_bg_linear;
    CheckBox cbx_2persons,cbx_5persons,cbx_10persons,cbx_myTreat,cbx_AA,cbx_maleAFemaleFree;
    Spinner spinner_nickname,spinner_location,spinner_explain,spinner_age;
    SimpleDraweeView avatar_pic;
    DatePicker datePicker;
    TimePicker timePicker;


    private List<String> list_nickname = new ArrayList<>();//创建一个String类型的数组列表
    private ArrayAdapter <String> adapterNickname;//创建一个数组适配器
    private List<String> list_age = new ArrayList<>();
    private ArrayAdapter <String> adapterAge;
    private List<String> list_location = new ArrayList<>();
    private SimpleArrayAdapter<String> adapterLocation;
    private List<String> list_explain = new ArrayList<>();
    private SimpleArrayAdapter<String> adapterExplain;
    private String avatar_picStr = "boy_avatar";
    List<DetailInfos> list_infos = new ArrayList<>();
    String avatar_show_pic;
    String nickname_show_txt;
    String sex_show_pic;
    String age_show_txt;
    String explain_show_pic;
    String date_show_txt;
    String time_show_txt;
    String personNum_show_txt;
    String cost_show_txt;
    String location_show_txt;
    String myDate_show_txt;
    String sex_bg;
    String location_logo_pic;
    int id,age_text_color;
    static String  likes_show_pic;
    DetailInfos detailInfos = new DetailInfos(id,avatar_show_pic,nickname_show_txt,sex_show_pic,age_show_txt,explain_show_pic,
            date_show_txt,time_show_txt,personNum_show_txt,cost_show_txt,location_show_txt,myDate_show_txt,sex_bg,location_logo_pic,likes_show_pic,age_text_color);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_date_actvity);
        whole_date_liner = (LinearLayout) findViewById(R.id.whole_date_liner);
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
        spinner_explain = (Spinner) findViewById(R.id.spinner_explain);
        spinner_age = (Spinner) findViewById(R.id.spinner_age);

        date_text = (TextView) findViewById(R.id.date_text);
        time_text = (TextView) findViewById(R.id.time_text);
        nickname_linear = (LinearLayout) findViewById(R.id.nickname_linear);
        timeDatePicker_id = (LinearLayout) findViewById(R.id.timeDatePicker_id);
        age_txt = (TextView) findViewById(R.id.age_txt);
        sex_bg_linear = (LinearLayout) findViewById(R.id.sex_bg_linear);

        whole_date_liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInvisible_dateAndtime();
            }
        });
        spinner_age.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                getInvisible_dateAndtime();
                return false;
            }
        });

        spinner_nickname.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                getInvisible_dateAndtime();
                return false;
            }
        });
        spinner_location.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                getInvisible_dateAndtime();
                return false;
            }
        });
        spinner_explain.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                getInvisible_dateAndtime();
                return false;
            }
        });
        datePicker.init(2017, 10, 15, new DatePicker.OnDateChangedListener() {//日期选择器的监听器

            @Override
            public void onDateChanged(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                // 获取一个日历对象，并初始化为当前选中的时间
                Calendar calendar = Calendar.getInstance();//获取现在时间
                calendar.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat format = new SimpleDateFormat(
                        "yyyy-MM-dd");
                date_show_txt = ""+ format.format(calendar.getTime());
                date_text.setText(""+ format.format(calendar.getTime()));
//                Toast.makeText(AddDateActivity.this,
//                        format.format(calendar.getTime()), Toast.LENGTH_SHORT)
//                        .show();
            }
        });

        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {//时间选择器的监听器
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay,
                                      int minute) {
                time_text.setText(""+hourOfDay + "：" + minute);
                time_show_txt = ""+hourOfDay + "：" + minute;
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
        publish_txt.setOnClickListener(this);
        cancel_txt.setOnClickListener(this);

        initNickernameList();//设置Nickname的spinner下拉内容
        initAgeList();//设置age的spinner下拉内容
        initLocationList();//设置Location的spinner下拉内容
        initExplainList(); //设置说明的spinner下拉内容
        initView();//初始化recy的界面


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
            case R.id.male_liner: //约饭对象
                male_icon.setSelected(true);
                female_icon.setSelected(false);
                person_icon.setSelected(false);
                getInvisible_dateAndtime();
                myDate_show_txt = "男士";
                break;
            case R.id.female_liner:
                female_icon.setSelected(true);
                male_icon.setSelected(false);
                person_icon.setSelected(false);
                getInvisible_dateAndtime();
                myDate_show_txt = "女士";
                break;
            case R.id.person_liner:
                person_icon.setSelected(true);
                male_icon.setSelected(false);
                female_icon.setSelected(false);
                getInvisible_dateAndtime();
                myDate_show_txt = "男女不限";
                break;

            case R.id.cbx_2persons:
                cbx_2persons.setChecked(true);//约饭人数
                cbx_5persons.setChecked(false);
                cbx_10persons.setChecked(false);
                getInvisible_dateAndtime();
                personNum_show_txt = "2人";
                break;
            case R.id.cbx_5persons:
                cbx_5persons.setChecked(true);
                cbx_2persons.setChecked(false);
                cbx_10persons.setChecked(false);
                personNum_show_txt = "3-5人";
                getInvisible_dateAndtime();
                break;
            case R.id.cbx_10persons:
                cbx_10persons.setChecked(true);
                cbx_2persons.setChecked(false);
                cbx_5persons.setChecked(false);
                getInvisible_dateAndtime();
                personNum_show_txt = "6-10人";
                break;
            case R.id.cbx_myTreat:
                cbx_myTreat.setChecked(true);//约饭费用
                cbx_AA.setChecked(false);
                cbx_maleAFemaleFree.setChecked(false);
                getInvisible_dateAndtime();
                cost_show_txt = "我请客";
                break;
            case R.id.cbx_AA:
                cbx_AA.setChecked(true);
                cbx_myTreat.setChecked(false);
                cbx_maleAFemaleFree.setChecked(false);
                getInvisible_dateAndtime();
                cost_show_txt = "AA";
                break;
            case R.id.cbx_maleAFemaleFree:
                cbx_maleAFemaleFree.setChecked(true);
                cbx_myTreat.setChecked(false);
                cbx_AA.setChecked(false);
                getInvisible_dateAndtime();
                cost_show_txt = "男A女免";
                break;
            case R.id.male_logo:
                male_logo.setSelected(true);
                avatar_picStr = "boy_avatar";
                initRoundCornerPic();
                female_logo.setSelected(false);
                getInvisible_dateAndtime();
                avatar_show_pic = "boy_avatar";
                sex_show_pic = "male_sex_logo";
                sex_bg = "shape_boy_bg";
                age_text_color = 0xFF1E90FF;
                break;
            case R.id.female_logo:
                female_logo.setSelected(true);
                avatar_picStr = "girl_avatar";
                initRoundCornerPic();
                male_logo.setSelected(false);
                getInvisible_dateAndtime();
                avatar_show_pic = "girl_avatar";
                sex_show_pic = "female_sex_logo";
                age_text_color = 0xFFEE30A7;
                sex_bg = "shape_girl_bg";
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
            case R.id.cancel:
                finish();
                break;
            case R.id.publish://发布消息
                list_infos.clear();
                list_infos.add(detailInfos);
                ContentValues cv = new ContentValues(); //把数据插入表格
                cv.put("avatar_show_pic",avatar_show_pic);
                cv.put("nickname_show_txt",nickname_show_txt);
                cv.put("sex_show_pic",sex_show_pic);
                cv.put("age_show_txt",age_show_txt);
                cv.put("explain_show_txt",explain_show_pic);
                cv.put("date_show_txt",date_show_txt);
                cv.put("time_show_txt",time_show_txt);
                cv.put("personNum_show_txt",personNum_show_txt);
                cv.put("cost_show_txt",cost_show_txt);
                cv.put("location_show_txt",location_show_txt);
                cv.put("myDate_show_txt",myDate_show_txt);
                cv.put("sex_bg",sex_bg);
                cv.put("location_logo_pic",location_logo_pic);
                cv.put("likes_show_pic",likes_show_pic);
                cv.put("age_text_color",age_text_color);
                getContentResolver().insert(MyContentProvider.URI,cv);

                finish();
                break;


        }
    }

    private void getInvisible_dateAndtime(){
        timeDatePicker_id.setVisibility(View.INVISIBLE);
    }

    /**
     *昵称数据
     *  **/
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
        spinner_nickname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected
                    (AdapterView<?> parent, View view, int position, long id) {
                // 将所选mySpinner 的值记录下来
                nickname_show_txt = adapterNickname.getItem(position);//记录选择的昵称名
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**年龄 数据**/
    private void initAgeList(){
        // 添加一个下拉列表项的list，这里添加的项就是下拉列表的菜单项，即数据源
        list_age.add("18");
        list_age.add("19");
        list_age.add("20");
        list_age.add("21");
        list_age.add("22");
        list_age.add("23");
        list_age.add("24");
        list_age.add("25");
        list_age.add("26");
        list_age.add("27");
        list_age.add("28");
        list_age.add("29");
        list_age.add("30");
        list_age.add("31");
        list_age.add("32");
        list_age.add("33");
        list_age.add("34");
        list_age.add("35");
        list_age.add("36");
        list_age.add("37");
        list_age.add("38");
        list_age.add("39");
        list_age.add("40");
        list_age.add("41");
        list_age.add("42");
        list_age.add("43");
        list_age.add("44");
        list_age.add("45");
        list_age.add("46");
        list_age.add("47");
        list_age.add("48");
        list_age.add("49");
        list_age.add("50");

        adapterAge = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, list_age);
        adapterAge.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_age.setAdapter(adapterAge);
        spinner_age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected
                    (AdapterView<?> parent, View view, int position, long id) {
                // 将所选mySpinner 的值记录下来
                age_show_txt = adapterAge.getItem(position);//记录选择的年龄
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    /**
     * 约饭的地点
     * **/
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
        spinner_location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected
                    (AdapterView<?> parent, View view, int position, long id) {
                // 将所选mySpinner 的值带入myTextView 中
                location_show_txt = (String) adapterLocation.getItem(position);//记录选择的地址
                List<LocationInfos>  list = LocationInfos.getLocationInfos();//记录选择的“地址logo”
                LocationInfos locationInfos = list.get(position);
                location_logo_pic = locationInfos.locationRes;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    /**
     * 约饭理由的 数据
     * */
    private  void  initExplainList(){
        // 添加一个下拉列表项的list，这里添加的项就是下拉列表的菜单项，即数据源
        list_explain.add("呵呵，只是无聊找人搭伙");
        list_explain.add("聚餐，人多才会有食欲哦！");
        list_explain.add("找个有趣的妹子同吃同聊！");
        list_explain.add("找个幽默的男士边吃边聊");
        list_explain.add("共品咖啡，畅聊生活");
        list_explain.add("品有趣食，享有趣事");
        list_explain.add("玩王者荣耀的约起来");
        list_explain.add("来边吃边吐槽&减压");
        list_explain.add("侃侃人生事");
        list_explain.add("美酒配美女，人生几何");
        list_explain.add("组局吃火锅，人多才热闹");
        list_explain.add("请给出要约饭的理由");
        adapterExplain = new SimpleArrayAdapter<>(this, R.layout.simple_spinner_item,list_explain);
        adapterExplain.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_explain.setAdapter(adapterExplain);
        spinner_explain.setSelection(list_explain.size() - 1, true);
        spinner_explain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected
                    (AdapterView<?> parent, View view, int position, long id) {
                // 将所选mySpinner 的值带入myTextView 中
                explain_show_pic = (String) adapterExplain.getItem(position);//记录选择的说明
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    /**设置图片圆角**/
    private void initRoundCornerPic(){
        RoundingParams rp = new RoundingParams();
        rp.setRoundAsCircle(true);
        rp.setBorder(getResources().getColor(R.color.spinner_focused),6);
        GenericDraweeHierarchy genericDraweeHierarchyBuilder = GenericDraweeHierarchyBuilder.newInstance(getResources()).setRoundingParams(rp).build();
        avatar_pic.setHierarchy(genericDraweeHierarchyBuilder);
        DraweeController controller = Fresco.newDraweeControllerBuilder().setUri(Uri.parse("res:///"+ getResources().getIdentifier(avatar_picStr,"drawable", getPackageName()))).build();
        avatar_pic.setController(controller);
    }

    private void initView(){
        avatar_show_pic = "boy_avatar";//初始recyclerview的内容
        sex_show_pic = "male_sex_logo";
        sex_bg = "shape_boy_bg";
        location_logo_pic = "dinning1_logo";
        likes_show_pic = "likes_button_unpressed";
        age_show_txt = "20";
        age_text_color = 0xFF1E90FF;
        personNum_show_txt = "2人";
        cost_show_txt = "AA";
        myDate_show_txt = "男女不限";
        location_show_txt = "茶餐厅";
        explain_show_pic = "呵呵，只是无聊找人搭伙";
        date_show_txt = ""+  new SimpleDateFormat(
                "yyyy-MM-dd").format(Calendar.getInstance().getTime());//当前的日期

        int hour =  Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int minute =  Calendar.getInstance().get(Calendar.MINUTE);
        time_show_txt =("   "+hour+"："+ minute);//当前的时间
    }
}
