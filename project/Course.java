package com.mytime;


import java.lang.*;


public class Course
{
    private String name = "";
    private int cred_hours = 0;
    private double time_available = 0.0;

    public void set_name(String str)
    {

        this.name = str;
    }

    public void set_cred_hours(int hours)
    {

        this.cred_hours = hours;

        // calculating time available (in minutes) to study based on the number of credit hours
        double time = (hours * 3) * 60;
        // subtracting 180 minutes from overall time to account for the lectures and labs (on average about 3 hours total)
        double time_after_lectures = time - 180;
        this.time_available = time_after_lectures;
    }

    public void set_time_available(double time)
    {
        this.time_available = time;
    }

    public int get_cred_hours()
    {
        return this.cred_hours;
    }

    public String get_name()
    {
        return this.name;
    }

    public double get_time_available()
    {
        return this.time_available;
    }

}