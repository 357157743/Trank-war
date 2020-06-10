package com.mashibing.tank.Adapter;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.stream.Stream;

/**
 * @date 2020/6/10 - 9:45
 */
public class Main {
    public static void main(String[] args) throws Exception {
        /*FileInputStream fis =  new FileInputStream("c:/test.txt");
        InputStreamReader isr =  new InputStreamReader(fis); //InputStreamReader 就是adapter适配器*/
        FileReader isr = new FileReader("c:/test.txt");
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while (line != null && !line.equals("")){
                System.out.println(line);
                line=br.readLine();
        }
        br.close();
    }
}
