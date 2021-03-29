package com.mytime;


import java.io.Serializable;
import java.lang.*;
import java.util.ArrayList;


public class Course implements Serializable
{
    private static int startOfWeek = 0;
    private static int dayLastChecked = 0;
    private String name = "";
    private int cred_hours = 0;
    private double time_available = 0.0;
    private boolean completion_stat = false;
    private String level_of_importance = "";
    private ArrayList<Double> hours_spent = new ArrayList<Double>();
    private double avg_study_time = 0.0;
    private double hours_spent_for_sort = 0.0;

    public void set_name(String str)
    {
        this.name = str;
    }

    public void setStartOfWeek(int day)
    {
        startOfWeek = day;
    }

    public int getStartOfWeek()
    {
        return startOfWeek;
    }

    public void setLastChecked(int day)
    {
        dayLastChecked = day;
    }

    public int getLastChecked()
    {
        return dayLastChecked;
    }

    //Added by Pedro Nemalceff
    public void set_importance_level(String str)
    {
        this.level_of_importance = str;
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

    public void set_comp_stat(boolean comp)
    {
        this.completion_stat = comp;
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

    //Added by Pedro Nemalceff
    public String get_level_of_importance()
    {
        return this.level_of_importance;
    }

    public boolean get_comp_stat()
    {
        if(time_available <= 0)
        {
            return this.completion_stat = true;
        }

        else
        {
            return this.completion_stat = false;
        }
        //return this.completion_stat;
    }

    public ArrayList<Double> get_hours_spent()
    {
        return this.hours_spent;
    }

    public void set_avg_study_time()
    {
        double sum = 0.0, avg = 0.0;

        for (int i = 0; i < this.get_hours_spent().size(); i++)
            sum += this.get_hours_spent().get(i);

        avg = sum / this.get_hours_spent().size();
        avg_study_time = Math.floor(avg * 100) / 100;
    }

    public double get_avg_study_time()
    {
        return avg_study_time;
    }

    public void set_hours_for_sort(double hrs)
    {
        this.hours_spent_for_sort = hrs;
    }

    public Double get_hours_for_sort()
    {
        return this.hours_spent_for_sort;
    }

    public void resetTimeAvailable()
    {
        // calculating time available (in minutes) to study based on the number of credit hours
        double time = (this.cred_hours * 3) * 60;
        // subtracting 180 minutes from overall time to account for the lectures and labs (on average about 3 hours total)
        double time_after_lectures = time - 180;
        this.time_available = time_after_lectures;
    }

}
