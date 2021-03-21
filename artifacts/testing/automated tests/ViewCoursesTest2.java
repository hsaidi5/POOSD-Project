// Pedro Nemalceff. Updated automated test for view courses functionality

package com.mytime;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class ViewCoursesTest2
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
        testCourse1.set_importance_level("Not Important");

        //Course Two attribute assignment
        testCourse2.set_cred_hours(4);
        testCourse2.set_name("Test Course 2");
        testCourse2.set_time_available(540);
        testCourse2.set_comp_stat(false);
        testCourse2.set_importance_level("Important");


        TableRow[] row_arr = {r1, r2};

        assertEquals(3, testCourse1.get_cred_hours(), 0);
        assertEquals(4, testCourse2.get_cred_hours(), 0);
        assertEquals(360.0, testCourse1.get_time_available(), 0);
        assertEquals(540, testCourse2.get_time_available(), 0);
        assertEquals("Equal", "Test Course 1", testCourse1.get_name());
        assertEquals("Equal", "Test Course 2", testCourse2.get_name());
        assertEquals(false, testCourse1.get_comp_stat());
        assertEquals(false, testCourse2.get_comp_stat());
        assertEquals("Not Important", testCourse1.get_level_of_importance());
        assertEquals("Important", testCourse2.get_level_of_importance());


        testCourse1.set_time_available(0.0);
        assertEquals(true, testCourse1.get_comp_stat());

    }


}
