package com.mashibing.tank.builder;

/**
 * @date 2020/6/10 - 8:56
 */
public class Main {
    public static void main(String[] args) {
        TerrainBuilder builder = new ComplexTerrainBuilder();
        //链式编程 都返回的是 TerrainBuilder
        Terrain t = builder.buildFort().bulidMind().bulidWall().bulid();

            Person p = new Person.PersonBuilder()
                    .basicInfo(1,"zhangsan",18)
                    .score(20)
                    .weight(200)
                    .loc("bj","23")
                    .bulid();
    }
}
