package com.mashibing.tank.builder;

/** 复杂地形
 * @date 2020/6/10 - 8:48
 */
public class ComplexTerrainBuilder implements  TerrainBuilder {
    Terrain terrain = new Terrain();


    @Override
    public TerrainBuilder bulidWall() {  //墙
        terrain.w = new Wall(10,10,50,50);
        return this;
    }

    @Override
    public TerrainBuilder buildFort() {  //暗堡
        terrain.f = new Fort(10,10,50,50);
        return this;
    }

    @Override
    public TerrainBuilder bulidMind() { //地雷
        terrain.m = new Mine(10,10,50,50);
        return this;
    }

    @Override
    public Terrain bulid() {
        return terrain;
    }
}
