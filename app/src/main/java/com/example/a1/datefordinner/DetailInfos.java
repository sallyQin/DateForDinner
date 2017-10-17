package com.example.a1.datefordinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 2017/9/12.
 */

class DetailInfos {
    int id;
    String avatar_show_pic,nickname_show_txt,sex_show_pic,age_show_txt,explain_show_pic,date_show_txt,time_show_txt,
            personNum_show_txt,cost_show_txt,location_show_txt,myDate_show_txt,sex_bg,location_logo_pic,likes_show_pic;
    int age_text_color;
    DetailInfos(int id, String avatar_show_pic, String nickname_show_txt, String sex_show_pic, String age_show_txt, String explain_show_pic, String date_show_txt, String time_show_txt,
                String personNum_show_txt, String cost_show_txt, String location_show_txt, String myDate_show_txt, String sex_bg, String location_logo_pic, String likes_show_pic, int age_text_color){
        this.id = id;
        this.avatar_show_pic = avatar_show_pic;
        this.nickname_show_txt = nickname_show_txt;
        this.sex_show_pic = sex_show_pic;
        this.age_show_txt = age_show_txt;
        this.explain_show_pic = explain_show_pic;
        this.date_show_txt = date_show_txt;
        this.time_show_txt = time_show_txt;
        this.personNum_show_txt = personNum_show_txt;
        this.cost_show_txt = cost_show_txt;
        this.location_show_txt = location_show_txt;
        this.myDate_show_txt = myDate_show_txt;
        this.sex_bg = sex_bg;
        this.location_logo_pic = location_logo_pic;
        this.likes_show_pic = likes_show_pic;
        this.age_text_color = age_text_color;
    }


}
