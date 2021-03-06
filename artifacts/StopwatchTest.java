package com.mytime;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class StopwatchTest {
    @Test
    public void main()
    {
        Course testCourse = new Course();
        testCourse.set_cred_hours(3);
        update_hours_remaining(testCourse);
        assertEquals(360.0, testCourse.get_time_available(), 0);
    }

    private void update_hours_remaining(Course testCourse)
    {
        double timeSpent = 3600.0;
        timeSpent = Math.floor(timeSpent * 100) / 100;

        // Code to deduct time spent studying for a specific class.
            if (testCourse.get_name().equals(testCourse))
            {
                double starting = testCourse.get_time_available();
                testCourse.set_time_available(starting - timeSpent);

                if (testCourse.get_time_available() < 0)
                    testCourse.set_time_available(0);
            }

    }

}