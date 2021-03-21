// Yoseph Hassan Automated test for view courses functionality

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

public class HistoryTest
{


    @Test

    public void main()
    {
        //r1_course_text = (TextView) getView().findViewById(R.id.r1_course);

        Course testCourse1 = new Course();
        Course testCourse2 = new Course();
        testCourse1.set_cred_hours(3);
        testCourse1.set_name("Test1");
        testCourse2.set_cred_hours(4);
        testCourse2.set_name("Test2");
        testCourse1.get_hours_spent().add(25.2);
        testCourse2.get_hours_spent().add(33.7);
        testCourse2.get_hours_spent().add(26.4);


        //makevisible(2, row_arr);

        assertEquals(3, testCourse1.get_cred_hours(), 0);
        assertEquals(4, testCourse2.get_cred_hours(), 0);
        assertEquals(360.0, testCourse1.get_time_available(), 0);
        assertEquals(540, testCourse2.get_time_available(), 0);
        assertEquals("Equal", "Test1", testCourse1.get_name());
        assertEquals("Equal", "Test2", testCourse2.get_name());
        assertEquals(false, testCourse1.get_comp_stat());
        assertEquals(false, testCourse2.get_comp_stat());

        testCourse1.set_time_available(0.0);
        assertEquals(true, testCourse1.get_comp_stat());

        assertEquals(25.2, testCourse1.get_hours_spent().get(0), 0);
        assertEquals(33.7, testCourse2.get_hours_spent().get(0), 0);
        assertEquals(26.4, testCourse2.get_hours_spent().get(1), 0);

    }
}