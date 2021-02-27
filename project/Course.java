package com.mytime;


import java.lang.*;


public class Course
{
    private String name = "";
    private int cred_hours = 0;

    public void set_name(String str)
    {

        this.name = str;
    }

    public void set_cred_hours(int hours)
    {

        this.cred_hours = hours;
    }

    public int get_cred_hours()
    {
        return this.cred_hours;
    }

    public String get_name()
    {
        return this.name;
    }

}
