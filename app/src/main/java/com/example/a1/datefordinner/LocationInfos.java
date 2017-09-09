package com.example.a1.datefordinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 2017/9/7.
 */

public class LocationInfos  {
    String locationRes,locationStr;

    public LocationInfos(String locationRes,String locationStr){
        this.locationRes = locationRes;
        this.locationStr = locationStr;
    }

    public static List<LocationInfos> getLocationInfos(){
        List<LocationInfos> location_list = new ArrayList();
        location_list.add(new LocationInfos("dinning1_logo","茶餐厅"));
        location_list.add(new LocationInfos("dinning2_logo","咖啡厅"));
        location_list.add(new LocationInfos("dinning3_logo","中餐馆"));
        location_list.add(new LocationInfos("dinning4_logo","西餐厅"));
        location_list.add(new LocationInfos("dinning5_logo","日本餐厅"));
        location_list.add(new LocationInfos("dinning6_logo","汉堡店"));
        location_list.add(new LocationInfos("dinning7_logo","西班牙餐厅"));
        location_list.add(new LocationInfos("dinning8_logo","墨西哥餐馆"));
        location_list.add(new LocationInfos("dinning9_logo","火锅店"));
        location_list.add(new LocationInfos("dinning10_logo","茶室"));
        location_list.add(new LocationInfos("dinning11_logo","饺子店"));
        location_list.add(new LocationInfos("dinning12_logo","鸡粥店"));
        location_list.add(new LocationInfos("dinning13_logo","KFC"));
        location_list.add(new LocationInfos("dinning14_logo","烧烤店"));
        location_list.add(new LocationInfos("dinning15_logo","披萨店"));
        location_list.add(new LocationInfos("dinning16_logo","饮品店"));
        location_list.add(new LocationInfos("dinning17_logo","面馆"));
        location_list.add(new LocationInfos("dinning18_logo","酒吧"));
        location_list.add(new LocationInfos("dinning19_logo","甜品店"));
        location_list.add(new LocationInfos("dinning20_logo","轻沙拉店"));
        location_list.add(new LocationInfos("dinning21_logo","请选择想约饭地点"));
        return  location_list;
    }
}
