package com.mytime;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AddCourseTest
{
    @Test
    public void addCourse()
    {
        ArrayList<Course> test_data_struct = new ArrayList<Course>();
        String testCourseName = "test";
        int testCreditHours = 3;
        Course output = new Course();;
        double testTimeAvailable = 360;

        Course testCourse = new Course();

        testCourse.set_name(testCourseName);
        testCourse.set_cred_hours(testCreditHours);
        test_data_struct.add(testCourse);

        output = test_data_struct.get(0);

        assertEquals(testCourseName, output.get_name());
        assertEquals(testCreditHours, output.get_cred_hours(), 0);
        assertEquals(testTimeAvailable, output.get_time_available(), 0);
    }

}