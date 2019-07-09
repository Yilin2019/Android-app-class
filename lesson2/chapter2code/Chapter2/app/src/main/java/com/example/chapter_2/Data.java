package com.example.chapter_2;

public class Data {
    private String name;
    private String index;
    private String num;
    private int imageid;

    public Data(String tname, String tindex, String tnum, int timageid){
        name = tname;
        index = tindex;
        num = tnum;
        imageid = timageid;
    }

    public String getname() {
        return name;
    }
    public String getindex() {
        return index;
    }
    public String getnum() {
        return num;
    }
    public int getImageid() {
        return imageid;
    }
}
