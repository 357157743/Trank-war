package com.mashibing.tank.ASM;

/**
 * @date 2020/6/3 - 10:33
 */
public class MyclassLoader extends  ClassLoader{
    public Class defineClass(String name, byte[] b) {
        return defineClass(name,b,0,b.length);
    }
}
