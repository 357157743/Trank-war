package com.mashibing.tank.bridge.V4;

/**
 * @date 2020/6/10 - 16:17
 */
public class GG {

    public void chaser(MM mm){
        Gift g = new WarmGift(new Flower());
        give(mm,g);
    }

    public void give(MM mm, Gift g) {
        System.out.println(g + "gived!");
    }
}
