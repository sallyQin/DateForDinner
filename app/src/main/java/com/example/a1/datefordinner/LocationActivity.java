package com.example.a1.datefordinner;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;


public class LocationActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    LinearLayout realPosition_linear;
    SimpleDraweeView positions_id;
    TextView position_txt;
    RecyclerView hotCity_recy;
    String[] hotCityStr = new String[]{"北京", "深圳", "广州", "上海", "成都","重庆","南京", "西安", "济南", "杭州", "苏州","天津"};
    public LocationClient mLocationClient = null; //初始化LocationClient类
    public MyLocationListener myListener = new MyLocationListener();
    String[] letter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String[] cityLetter = {"C", "B", "H", "G", "W", "C", "S", "S", "C", "W", "H", "Z", "C", "D", "N", "L", "Q", "S", "S"
            ,"N", "H", "X", "H", "S", "Z","J", "T", "S", "X", "A",
            "X","H","W","M","C","H","C","A","H","H",
            "B","C","S","X","L","F","T","M","T","N",
            "J","T","F","Q","Z","N","S","L","P","N",
            "J","W","C","F","J","N","F","L","S","S",
            "F","J","Z","Y","N","X","Y","G","L","W",
            "B","Q","B","F","G","H","C","L","D","G",
            "B","C","H","P","Y","G","A","Z","L","X",
            "D","K","B","Q","T","C","R","F","H","S",
            "W","W","D","Q","D","W","J","X","X","J",
            "H","Y","S","E","X","H","S","Z","L","E",
            "X","T","Z","Q","M","H","H","C","S","D",
            "W","G","S","D","Z","Y","Y","D","A","Y",
            "L","T","C","Y","L","Z","H","X","Y","C",
            "S","Y","H","L","L","X","L","Y","L","C",
            "J","J","L","L","M","W","S","A","X","W",
            "C","Y","X","L","Y","H","S","Z","N","T",
            "X","D","C","J","Z","T","Y","P","H","D",
            "L","T","L","K","Q","J","D","W","J","Y",
            "X","Y","T","J","G","J","J","G","G","S",
            "Y","J","X","J","P","F","Y","J","F","Z",
            "D","R","J","G","L","N","G","R","D","G",
            "X","G","D","L","B","N","Y","N","D","Z",
            "L","G","D","Z","M","M","S","Y","L","P",
            "G","M","W","H","J","X","P","J","C","S",
            "E","Q","S","K","Y","D","Q","S","B","L",
            "L","C","K","G","J","A","X","N","S","W",
            "T","H","J","J","Z","Q","L","Y","L","L",
            "W","Y","R","C","Y","S","Z","H","T","L",
            "L","J","F","P","D","S","F","L","J","T",
            "T","T","G","T","B","W","J","P","Z","J",
            "J","Q","D","L","T","Y","L","H","D","G",
            "B","T","H","X","C","H","L","C","Q","L",
            "Q","N","R","Y","X","Z","D","J","B","H",
            "Z","Z","S","S","J","W","H","X","B","A",
            "S","G","L","J","S","X","Z","H","A","P",
            "Z","N","K","L","X","X","J","L","Y","D",
            "D","S","X","Y","G","Y","C","Y","L","X",
            "R","X","P","W","X","W","X","M","Q","J",
            "Y","M","D","J","H","S","H","F","H","M",
            "J","S","H","T","B","W","A","S","W","A",
            "Q","T","S","N","M","T","J","T","B","S",
            "L", "S", "B", "J", "M", "S",
            "Y","J","H","Y","J","P","D","D","T","L",
            "H","G","T","S","H","L","D","H","P","A",
            "T","B","D","F","J","L","F","D","C","H",
            "B","G","F","Z","L","K","X","X","D","D",
            "B","W","P","L","D","Y","H","C","Z","E",
            "W","B","E","H","B","W","A","W","X","G",
            "M","E","Y","L","F","T","Y","G","S","Q",
            "Z","W","L","X","G","D","Q","W","W","H",
            "J","L","D","Y","Z","Z","T","L","R","D",
            "L","B","L","Y","Z","Z","T","F","X","J",
            "J","J","L","P","L","T","D","Y","C","L",
            "J","Y","X","S","L","G","G","Y","X","H",
            "H","J","H","F","Y","L","X","Y","B","T",
            "W","H","A","S","Y","H","X","H","R",
            "S","K","A","F","K","A","A","H","K","C",
            "K","M","H","S","Z","M","Z","F","H","D",
            "J","S","C","J","H","Y","M","Z","Z","S",
            "Y","Q"};//每个城市对应的首字母
    String[] cityName = {"长沙", "北京", "杭州", "广州", "武汉", "重庆", "上海", "深圳", "长春", "乌鲁木齐", "哈尔滨", "郑州", "成都", "大连", "南昌", "兰州", "齐齐哈尔", "汕头", "苏州"
            ,"南京", "呼和浩特", "厦门", "合肥", "沈阳", "张家界","济南", "天津", "石家庄", "西安", "澳门", "香港","亳州", "芜湖", "马鞍山", "池州", "黄山", "滁州", "安庆", "淮南", "淮北",
            "蚌埠", "巢湖", "宿州", "宣城", "六安", "阜阳", "铜陵","明光","天长", "宁国",
            "界首","桐城","福州","泉州","漳州","南平","三明","龙岩","莆田","宁德",
            "建瓯","武夷山","长乐市","福清","晋江","南安","福安","龙海","邵武","石狮",
            "福鼎","建阳","漳平","永安","南宁","贺州","玉林","桂林","柳州","梧州",
            "北海","钦州","百色","防城港","贵港","河池","崇左","来宾","东兴","贵平",
            "北流","岑溪","合山","凭祥","宜州","贵阳","安顺","遵义","六盘水","兴义",
            "都均","凯里","毕节","清镇","铜仁","赤水","仁怀","福泉","海口","三亚",
            "万宁","文昌","儋州","琼海","东方","五指山","荆门","咸宁","襄樊","荆州",
            "黄石","宜昌","随州","鄂州","孝感","黄冈","十堰","枣阳","老河口","恩施",
            "仙桃","天门","钟祥","潜江","麻城","洪湖","汉川","赤壁","松滋","丹江口",
            "武穴","广水","石首","大治","枝江","应城","宜城","当阳","安陆","宜都",
            "利川","肇东","郴州","益阳","娄底","株洲","衡阳","湘潭","岳阳","常德",
            "邵阳","永州","怀化","浏阳","醴陵","湘乡","耒阳","沅江","涟源","常宁",
            "吉首","津市","冷水江","临湘","汨罗","武冈","韶山","安化县","湘西州","无锡",
            "常州","扬州","徐州","连云港","盐城","淮安","宿迁","镇江","南通","泰州",
            "兴化","东台","常熟","江阴","张家港","通州","宜兴","邳州","海门","大丰",
            "溧阳","泰兴","如皋","昆山","启东","江都","丹阳","吴江","靖江","扬中",
            "新沂","仪征","太仓","姜堰","高邮","金坛","句容","灌南县","赣州","上饶",
            "宜春","景德镇","新余","九江","萍乡","抚州","鹰潭","吉安","丰城","樟树",
            "德兴","瑞金","井冈山","高安","乐平","南康","贵溪","瑞昌","东乡县","广丰县",
            "信州区","广安","德阳","乐山","巴中","内江","宜宾","南充","都江堰","自贡",
            "泸州","广元","达州","资阳","绵阳","眉山","遂宁","雅安","阆中","攀枝花",
            "广汉","绵竹","万源","华蓥","江油","西昌","彭州","简阳","崇州","什邡",
            "峨眉山","邛崃","双流县","昆明","玉溪","大理","曲靖","邵通","保山","丽江",
            "临沧","楚雄","开远","个旧","景洪","安宁","宣威","宁波","绍兴","温州",
            "台州","湖州","嘉兴","金华","舟山","衢州","丽水","余姚","乐清","临海",
            "温岭","永康","瑞安","慈溪","义乌","上虞","诸暨","海宁","桐乡","兰溪",
            "龙泉","建德","富阳","平湖","东阳","嵊州","奉化","临安","江山","台北",
            "台南","台中","高雄","桃园","白银","武威","金昌","平凉","张掖","嘉峪关",
            "酒泉","庆阳","定西","陇南","天水","玉门","临夏","合作","敦煌","甘南州",
            "保定","唐山","邯郸","邢台","沧州","衡水","廊坊","承德","迁安","鹿泉",
            "秦皇岛","南宫","任丘","业城","辛集","涿州","定州","晋州","霸州","黄骅",
            "遵化","张家口","沙河市","三河","冀州","武安","河间","新乐","泊头","安国",
            "双滦区","高碑店","洛阳","焦作","商丘","信阳","周口","鹤壁","安阳","濮阳",
            "驻马店","南阳","开封","漯河","许昌","新乡","济源","灵宝","偃师","邓州",
            "登封","三门峡","新郑","禹州","巩义","永城","长葛","义马","林州","项城",
            "汝州","荥阳","平顶山","卫辉","辉县","舞钢","新密","孟州","沁阳","郏县",
            "伊春","牡丹江","大庆","鸡西","鹤岗","绥化","黑河","富锦","虎林","密山",
            "佳木斯","双鸭山","海林","铁力","北安","五大连池","阿城","尚志","五常","安达",
            "七台河","妥汾河","双城","讷河","穆棱","同江","吉林","通化","白城","四平","辽源","松原","白山","集安","梅河口","双辽",
            "延吉","九台","桦甸","榆树","蛟河","磐石","大安","德惠","洮南","龙井",
            "珲春","公主岭","图们","舒兰","和龙","临江","敦化","葫芦岛","盘锦","鞍山",
            "铁岭","本溪","丹东","抚顺","锦州","辽阳","阜新","调兵山","朝阳","海城",
            "北票","盖州","凤城","庄河","凌源","开原","兴城","新民","大石桥","东港",
            "北宁","瓦房店","普兰店","凌海","灯塔","营口","呼伦贝尔","赤峰","扎兰屯","鄂尔多斯",
            "乌兰察布","巴彦淖尔","二连浩特","霍林郭勒","包头","乌海","阿尔山","乌兰浩特","锡林浩特","根河",
            "满洲里","额尔古纳","牙克石","临河","丰镇","通辽","银川","固原","石嘴山","青铜峡",
            "中卫","吴忠","灵武","西宁","格尔木","德令哈","青岛","威海","潍坊","菏泽",
            "济宁","莱芜","东营","烟台","淄博","枣庄","泰安","临沂","日照","德州",
            "聊城","滨州","乐陵","兖州","诸城","邹城","滕州","肥城","新泰","胶州",
            "胶南","即墨","龙口","平度","莱西","太原","大同","阳泉","长治","临汾",
            "晋中","运城","忻州","朔州","吕梁","古交","高平","永济","孝义","侯马",
            "霍州","介休","河津","汾阳","原平","潞城","咸阳","榆林","宝鸡","铜川",
            "渭南","汉中","安康","商洛","延安","韩城","兴平","华阴","日喀则",
            "石河子","喀什","阿勒泰","阜康","库尔勒","阿克苏","阿拉尔","哈密","克拉玛依","昌吉",
            "奎屯","米泉","和田","深圳","珠海","梅州","中山","佛山","惠州","东莞",
            "江门","汕尾","潮州","揭阳","河源","阳江","茂名","湛江","肇庆","韶关",
            "云浮","清远"};//城市名

    List<String> letterToCity = new ArrayList<String>();
    ListView lv;
    ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        positions_id = (SimpleDraweeView) findViewById(R.id.positions_id);
        position_txt = (TextView) findViewById(R.id.position_txt);
        lv = (ListView) findViewById(R.id.listView1);
        lv1 = (ListView) findViewById(R.id.listView2);
        realPosition_linear = (LinearLayout) findViewById(R.id.realPosition_linear);
        realPosition_linear.setOnClickListener(new View.OnClickListener() { //监测是否启动了GPS权限
            @Override
            public void onClick(View v) {
                Boolean isConnected = isConn(LocationActivity.this);//监测是否开启了网络
                int isAvailable = isAppAvailable(LocationActivity.this);//监测是否开启了GPS
                if (isConnected) {
                    if (isAvailable == 0) {
                        LocationIniti();
                    } else if (isAvailable == -1) {
                        OpenGPS();
                    }
                } else {
                    if (isAvailable == -1) {
                        OpenGPS();
                    }
                }

            }
        });


        hotCity_recy = (RecyclerView) findViewById(R.id.hotCity_recy);
        hotCity_recy.setAdapter(new RecyclerView.Adapter() {
            int mSelected = -1;

            class ViewHolder extends RecyclerView.ViewHolder {
                public ViewHolder(View itemView) {
                    super(itemView);
                }
            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(LocationActivity.this).inflate(R.layout.recyclerview_hot_city, parent, false);
                return new ViewHolder(view);
            }

            @Override
            public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

                TextView hotCity_txt = (TextView) holder.itemView.findViewById(R.id.hotCity_txt);
                hotCity_txt.setText(hotCityStr[position]);
                hotCity_txt.setSelected(position == mSelected);
                hotCity_txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mSelected = holder.getAdapterPosition();
                        notifyDataSetChanged();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(800);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                Intent intent = new Intent();
                                intent.putExtra("realLocation", hotCityStr[mSelected]);
                                setResult(RESULT_OK, intent);
                                finish();

                            }
                        }).start();
                    }
                });
            }

            @Override
            public int getItemCount() {
                return hotCityStr.length;
            }
        });


        //list加载相同的首字母城市
        String str = "";
        for (int i = 0; i < letter.length; i++) {
            str = letter[i];
            boolean isAddLetter = false;
            for (int j = 0; j < cityLetter.length; j++) {
                if (str.equals(cityLetter[j])) {
                    if (!isAddLetter) {
                        letterToCity.add(str);
                        isAddLetter = true;
                    }
                    letterToCity.add(cityName[j]);
                }
            }
        }


        lv.setAdapter(new MyAdapter());
        lv.setOnItemClickListener(this);

        lv1.setAdapter(new MyAdapter1());
        lv1.setOnItemClickListener(this);
    }

    /**
     * 启动GPS定位
     **/
    public void LocationIniti() {
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //声明LocationClient类
        mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(myListener); //注册监听函数
        setLocationOption(); //定义setLocationOption()方法
        mLocationClient.start(); //执行定位
    }


    public class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(final BDLocation location) {
            //将获取的City赋值给txt
            /**
             *1.国家:location.getCountry()
             * 2.城市:location.getCity()
             * 3.区域(例：海滨区)：location.getDistrict()
             * 4.地点(例：人民路)：location.getStreet()
             * 5.详细地址：location.getAddrStr()
             */
            position_txt.setText(location.getCity() + location.getDistrict());
            positions_id.setAspectRatio(0.73f);
            positions_id.setImageURI(Uri.parse("res:///" + getResources().getIdentifier("map_icon", "drawable", getPackageName())));

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Intent intent = new Intent();
                    intent.putExtra("realLocation", location.getCity());
                    setResult(RESULT_OK, intent);
                    finish();

                }
            }).start();

            Toast.makeText(LocationActivity.this, "网络定位成功" +
                    location.getDirection(), Toast.LENGTH_LONG).show();
        }

        public void onReceivePoi(BDLocation arg0) {
        }
    }


    //执行onDestroy()方法，停止定位
    @Override
    public void onDestroy() {
        if (mLocationClient != null) {
            mLocationClient.stop();
        }
        super.onDestroy();
    }


    //设置定位和网络的相关参数
    private void setLocationOption() {
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); //打开gps
        option.setAddrType("all");//返回定位结果包含地址信息
        option.setPriority(LocationClientOption.NetWorkFirst); // 设置网络优先
        option.setPriority(LocationClientOption.GpsFirst);       //gps
        option.disableCache(true);//禁止启用缓存定位
        mLocationClient.setLocOption(option);
    }


    /**
     * 判断APP是否获得定位权限
     *
     * @param context
     * @return 0 表示获得了权限，-1 表示未获得
     */
    public final int isAppAvailable(final Context context) {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
    }

    /**
     * 判断网络连接是否已开
     * true 已打开  false 未打开
     */
    public static boolean isConn(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
            searchNetwork(context);//弹出提示对话框
        }
        return false;
    }

    /**
     * 判断网络是否连接成功，连接成功不做任何操作
     * 未连接则弹出对话框提示用户设置网络连接
     */
    public static void searchNetwork(final Context context) {
        //提示对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("网络设置提示").setMessage("网络连接不可用,是否进行设置?").setPositiveButton("设置", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = null;
                //判断手机系统的版本  即API大于10 就是3.0或以上版本
                if (android.os.Build.VERSION.SDK_INT > 10) {
                    intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                } else {
                    intent = new Intent();
                    ComponentName component = new ComponentName("com.android.settings", "com.android.settings.WirelessSettings");
                    intent.setComponent(component);
                    intent.setAction("android.intent.action.VIEW");
                }
                context.startActivity(intent);
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }

    /**
     * 提醒开启GPS
     */
    public void OpenGPS() {
        Toast.makeText(LocationActivity.this, "请打开GPS", Toast.LENGTH_SHORT).show();
        final AlertDialog.Builder dialog = new AlertDialog.Builder(LocationActivity.this);
        dialog.setTitle("请打开GPS连接");
        dialog.setMessage("为方便获取你所在位置，请先打开GPS");
        dialog.setPositiveButton("设置", new android.content.DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // 转到手机设置界面，用户设置GPS
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                Toast.makeText(LocationActivity.this, "打开后直接点击返回键即可，若不打开返回下次将再次出现", Toast.LENGTH_SHORT).show();
                startActivityForResult(intent, 0); // 设置完成后返回到原来的界面
            }
        });
        dialog.setNeutralButton("取消", new android.content.DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                arg0.dismiss();
            }
        });
        dialog.show();
    }


    /**
     * 全国城市列表
     * 在listview中加载多个布局
     * 以城市列表为例,保证cityLetter和cityName中没有相同的元素，且letter中没有相同的元素
     */

    class MyAdapter1 extends BaseAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return letter.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return letter[position];
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(LocationActivity.this).inflate(R.layout.letter_list, null);
            TextView tv = (TextView) view.findViewById(R.id.letterListTextView);
            tv.setText(letter[position]);
            return view;
        }

    }

    class MyAdapter extends BaseAdapter {

        final static int TYPE_1 = 1;
        final static int TYPE_2 = 2;

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return letterToCity.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return letterToCity.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public int getItemViewType(int position) {
            for (int i = 0; i < letter.length; i++) {
                if (letterToCity.get(position).equals(letter[i])) {
                    return TYPE_1;
                }
            }
            return TYPE_2;
        }

        @Override
        public int getViewTypeCount() {
            return 3;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            /**
             * @Override
             * public int getItemViewType(int position) {}这个函数获取在getView中创建的视图的类型
             * @Override
             * public int getViewTypeCount() {}返回在getView中创建视图类型的数量
            */
            ViewHolder1 vh1 = null;
            ViewHolder2 vh2 = null;
            int type = getItemViewType(position);
            if (convertView == null) {
                switch (type) {
                    case TYPE_1:
                        convertView = LayoutInflater.from(LocationActivity.this).inflate(R.layout.letter, null);
                        vh1 = new ViewHolder1();
                        vh1.tv = (TextView) convertView.findViewById(R.id.letterTextView);
                        convertView.setTag(vh1);
                        break;
                    case TYPE_2:
                        convertView = LayoutInflater.from(LocationActivity.this).inflate(R.layout.city, null);
                        vh2 = new ViewHolder2();
                        vh2.tv = (TextView) convertView.findViewById(R.id.cityTextView);
                        convertView.setTag(vh2);
                        break;
                    default:
                        break;
                }
            } else {
                switch (type) {
                    case TYPE_1:
                        vh1 = (ViewHolder1) convertView.getTag();
                        break;
                    case TYPE_2:
                        vh2 = (ViewHolder2) convertView.getTag();
                        break;
                    default:
                        break;
                }
            }
            switch (type) {
                case TYPE_1:
                    vh1.tv.setText(letterToCity.get(position));
                    break;
                case TYPE_2:
                    vh2.tv.setText(letterToCity.get(position));
                    break;
                default:
                    break;
            }
            return convertView;

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position,
                            long id) {
        switch (parent.getId()) {
            case R.id.listView1:
                boolean isLetter = false;
                for (int i = 0; i < letter.length; i++) {
                    if (letter[i].equals(letterToCity.get(position))) {
                        isLetter = true;
                        break;
                    }
                }
                if (!isLetter) {
                    Toast.makeText(this, letterToCity.get(position), Toast.LENGTH_SHORT).show();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Intent intent = new Intent();
                            intent.putExtra("realLocation",letterToCity.get(position));
                            setResult(RESULT_OK, intent);
                            finish();

                        }
                    }).start();
                }
                break;
            case R.id.listView2:
                for (int i = 0; i < letterToCity.size(); i++) {
                    if (letter[position].equals(letterToCity.get(i))) {
                        lv.setSelection(i);
                        break;
                    }
                }
                break;
            default:
                break;
        }
    }


    class ViewHolder1{
        TextView tv;
    }
    class ViewHolder2{
        TextView tv;
    }
}
