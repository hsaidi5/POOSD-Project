package com.mytime;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AvgTimeTest {

    @Test
    public void main()
    {
        Course testCourse = new Course();

        testCourse.get_hours_spent().add(3.0);
        testCourse.get_hours_spent().add(3.0);
        testCourse.get_hours_spent().add(3.0);

        assertEquals(3.0, get_avg_study_time(testCourse), 0);
    }

    private double get_avg_study_time(Course course)
    {
        double sum = 0.0, avg = 0.0;

        for (int i = 0; i < course.get_hours_spent().size(); i++)
        {
            sum += course.get_hours_spent().get(i);
        }

        avg = sum / course.get_hours_spent().size();
        avg = Math.floor(avg * 100) / 100;
        return avg;
    }

}