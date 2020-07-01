package com.mashibing.trank;

import java.io.IOException;
import java.util.Properties;

/**
 * @date 2020/4/28 - 8:14
 */
// 管理配置文件
public class PropertyMgr {
    static Properties props = new Properties();

    static{
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int get(String key){
        if(props == null) return 0;
        return Integer.parseInt((String)props.get(key));
    }

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initTankCount"));
    }
}
