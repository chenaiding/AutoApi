package utils;

import model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author chenaiding
 * Created on 2020/7/22.
 */
public class ConfigUrl {

    public static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);
    public static String getUrl(InterfaceName name){
        String address = bundle.getString("url");
        String uri = "";
        //最终测试地址
        String testUrl;

        if (name == InterfaceName.CHECHBANLACE){
            uri = bundle.getString("checkBalanceUri");
        }

        testUrl = address + uri;

        return testUrl;
    }
}
