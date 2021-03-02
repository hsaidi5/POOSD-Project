package com.mytime;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTest {

    @Test
    public void set_cred_hours()
    {
        int input = 3;
        double output;
        double expected = 360;

        Course testCourse = new Course();
        testCourse.set_cred_hours(input);
        output = testCourse.get_time_available();

        assertEquals(expected, output, 0);
    }
}