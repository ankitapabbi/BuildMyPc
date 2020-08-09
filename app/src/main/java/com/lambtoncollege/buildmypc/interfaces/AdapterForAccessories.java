package com.lambtoncollege.buildmypc.interfaces;

public interface AdapterForAccessories {
    public void getData( int position,String name,String brand,String colour,
                         String shortd,String longd,int price);
    public void getForWish( int position,String name,String brand,String colour,
                         String shortd,String longd,int price);
}
