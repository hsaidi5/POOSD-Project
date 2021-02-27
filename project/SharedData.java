package com.mytime;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SharedData
{
    private static final String MY_PREFERENCE_NAME = "com.mytime";
    private static final String COURSES_KEY = "courses_key";

    public static void saveCourses(Context context, ArrayList<Course> courses)
    {
        SharedPreferences courseInfo = PreferenceManager.getDefaultSharedPreferences(context);
        //SharedPreferences courseInfo = context.getSharedPreferences(MY_PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = courseInfo.edit();
        Gson gson = new Gson();
        String json = gson.toJson(courses);
        editor.putString(COURSES_KEY, json);
        editor.commit();
    }

    public static ArrayList<Course> getCurrentCourses(Context context)
    {
        SharedPreferences courseInfo = PreferenceManager.getDefaultSharedPreferences(context);
        //SharedPreferences courseInfo = context.getSharedPreferences(MY_PREFERENCE_NAME, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = courseInfo.getString(COURSES_KEY, "");

        Type type = new TypeToken<ArrayList<Course>>() {}.getType();
        ArrayList<Course> currentCourses = gson.fromJson(json, type);

        return currentCourses;
    }

    public static void clearCourses(Context context)
    {
        SharedPreferences courseInfo = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = courseInfo.edit();
        editor.clear();
        editor.commit();
    }
}
