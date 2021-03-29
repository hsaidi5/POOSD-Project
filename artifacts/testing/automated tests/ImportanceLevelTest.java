// Pedro Nemalceff. Updated automated test for view courses functionality
//Automated test for Sprint 8

package com.mytime;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ImportanceLevelTest
{
    private TextView r1_course_text;
    private TableRow r1;
    private TableRow r2;

    @Test

    public void main()
    {

        Course testCourse1 = new Course();
        Course testCourse2 = new Course();

        //Course One attribute assignment
        testCourse1.set_cred_hours(3);
        testCourse1.set_name("Test Course 1");
        testCourse1.set_time_available(360.0);
        testCourse1.set_comp_stat(false);
        testCourse1.set_importance_level("Very Important");

        //Course Two attribute assignment
        testCourse2.set_cred_hours(4);
        testCourse2.set_name("Test Course 2");
        testCourse2.set_time_available(540);
        testCourse2.set_comp_stat(false);
        testCourse2.set_importance_level("Somewhat Important");

        //Level of importance assignemnt
        //Testing the switch

        String color = null;

        switch (testCourse1.get_level_of_importance()) {
            case "Not Important":
                //Original code
                //importance_arr[i].setTextColor(Color.parseColor("#00FF00"));
                color = "#00FF00";
                break;
            case "Somewhat Important":
                //Original code
                //importance_arr[i].setTextColor(Color.parseColor("#FFFF00"));
                color = "#FFFF00";
                break;
            case "Important":
                //Original code
                //importance_arr[i].setTextColor(Color.parseColor("#FFA500"));
                color = "#FFA500";
                break;
            case "Very Important":
                //Original code
                //importance_arr[i].setTextColor(Color.parseColor("#FF0000"));
                color = "#FF0000";
                break;
        }

        TableRow[] row_arr = {r1, r2};

        assertEquals(3, testCourse1.get_cred_hours(), 0);
        assertEquals(360.0, testCourse1.get_time_available(), 0);
        assertEquals("Equal", "Test Course 1", testCourse1.get_name());
        assertEquals(false, testCourse1.get_comp_stat());
        assertEquals("Very Important", testCourse1.get_level_of_importance());
        assertEquals("#FF0000", color);

    }


}
