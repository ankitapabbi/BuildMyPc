package com.lambtoncollege.buildmypc.interfaces;

public interface AdapterForBrands {
    public void toManage( int position,String name,String screen,String processor,
                         String ram,String rom,String graphic,String warranty,int price);
    public void getData( int position,String name,String screen,String processor,
                          String ram,String rom,String graphic,String warranty,int price);
}
