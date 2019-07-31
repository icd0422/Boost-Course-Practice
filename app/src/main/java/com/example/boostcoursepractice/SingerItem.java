package com.example.boostcoursepractice;

public class SingerItem {
    private String name ;
    private String mobile ;
    private int resID ;

    public SingerItem(String name, String mobile, int resID) {
        this.name = name;
        this.mobile = mobile;
        this.resID = resID ;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public int getResID()
    {
        return resID ;
    }

    @Override
    public String toString() {
        return "SingerItem{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", resID=" + resID +
                '}';
    }
}
