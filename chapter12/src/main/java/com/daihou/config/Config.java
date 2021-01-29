package com.daihou.config;

import lombok.Data;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;


@Data
public class Config {
    //评分卡功能，评分模块
    //评分
    public static String pingFengURL;
    //导入
    public static String daoRuURL;
    //导入检查
    public static String daoRuJianChaURL;
    //导出
    public static String daoChu_URL;
    //调整比例
    public static String tiaoZhengBiLi_URL;
    //记录
    public static String jiLuURL;
    //快照
    public static String kuaiZhaoURL;

    //声明http客户端
    public static DefaultHttpClient defaultHttpClient;
    //登陆催收系统Authorization
    public static String Auth;

}
