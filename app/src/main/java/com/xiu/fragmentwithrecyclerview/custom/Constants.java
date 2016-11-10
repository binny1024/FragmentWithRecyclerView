package com.xiu.fragmentwithrecyclerview.custom;

import com.xiu.fragmentwithrecyclerview.R;

public class Constants {
    // TODO:2016/10/22 GV数据
    // Fresco Uri uri = Uri.parse("res://包名(实际可以是任何字符串甚至留空)/" + R.drawable.ic_launcher)
    public static String[] gridViewImgURI = {
            "res://com.lzhy.moneyhll/" + R.drawable.fczs,
            "res://com.lzhy.moneyhll/" + R.drawable.jplx,
            "res://com.lzhy.moneyhll/" + R.drawable.lzsc,
            "res://com.lzhy.moneyhll/" + R.drawable.grzx,
            "res://com.lzhy.moneyhll/" + R.drawable.zjbx,
            "res://com.lzhy.moneyhll/" + R.drawable.tsrb,
            "res://com.lzhy.moneyhll/" + R.drawable.lyqz,
            "res://com.lzhy.moneyhll/" + R.drawable.jpyd
    };

    public static String gridItemName[] = {
            "房车展示", "精品路线", "龙珠商城", "个人中心",
            "自驾保险", "特色日本", "旅游签证", "机票预订",
            "房车展示", "精品路线", "龙珠商城", "个人中心",
            "自驾保险", "特色日本", "旅游签证", "机票预订",
            "房车展示", "精品路线", "龙珠商城", "个人中心",
            "自驾保险", "特色日本", "旅游签证", "机票预订"
    };

    //分别定义两种显示格式的值

    public final static int ViewPagerFlag = 0;//ViewPager 标志位
    public final static int GridFlag = 1;//GridView 标志位
    public final static int ListFlag = 2;//ListView 标志位
    public final static int oneItemFourColumn = 4;
    public final static int oneItemOneColumn = 1;
    public final static int rowTotalFourColumn = 4;

    public static final String urlPath = "http://www.imooc.com/api/teacher?type=4&num=30";
}
