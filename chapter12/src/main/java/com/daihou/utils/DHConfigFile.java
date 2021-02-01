package com.daihou.utils;

import com.course.model.AuthName;
import com.course.model.InterfaceName;
import com.daihou.model.DHInterfaceAuth;
import com.daihou.model.DHInterfaceName;
import com.daihou.model.DaiHou_API;
import java.util.Locale;
import java.util.ResourceBundle;

public class DHConfigFile {
    private static ResourceBundle bundle= ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getProp(DaiHou_API name){
        String result = "";
        if(name == DaiHou_API.AUTH){
            result = bundle.getString("AUTH");
        }
        return result;
    }
    public static String getUrl(DHInterfaceAuth name){
        String address = bundle.getString("DaiHou_URL");
        String uri = "";
        String testUrl;
        if(name == DHInterfaceAuth.AUTH){
            uri = bundle.getString("auth.uri");
        }
        testUrl = address + uri;
        return testUrl;
    }
    public static String getUrl(DHInterfaceName name){
        String address = bundle.getString("DaiHou_URL");
        String uri = "";
        String testUrl;
        if(name == DHInterfaceName.PINGFEN){
            uri = bundle.getString("pingfen.uri");
        }
        if(name == DHInterfaceName.DAORU){
            uri = bundle.getString("daoru.uri");
        }
        if(name == DHInterfaceName.DAORUJIANCHA){
            uri = bundle.getString("daorujiancha.uri");
        }
        if(name == DHInterfaceName.DAOCHU){
            uri = bundle.getString("daochu.uri");
        }
        if(name == DHInterfaceName.TIAOZHENGBILI){
            uri = bundle.getString("tiaozhengbili.uri");
        }
        if(name == DHInterfaceName.JILU){
            uri = bundle.getString("jilu.uri");
        }
        if(name == DHInterfaceName.KUAIZHAO){
            uri = bundle.getString("kuaizhao.uri");
        }
        testUrl = address + uri;
        return testUrl;
    }
}
