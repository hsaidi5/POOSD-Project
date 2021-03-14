package com.mytime;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DuplicateCourseTest
{
    @Test
    public void duplicateCourse()
    {
        String expected = "You are already enrolled in this course!";

        ArrayList<Course> test_data_struct = new ArrayList<Course>();
        String testCourseName = "test";
        int testCreditHours = 3;
        double testTimeAvailable = 360;
        Course output = new Course();;

        Course testCourse = new Course();
        testCourse.set_name(testCourseName);
        testCourse.set_cred_hours(testCreditHours);
        test_data_struct.add(testCourse);

        String result = "";
        boolean exists = false;
        for(int i = 0; i < test_data_struct.size(); i++)
        {
            if(test_data_struct.get(i).get_name().equals(testCourseName))
            {
                exists = true;
            }
        }

        if(exists == true)
        {
            result = "You are already enrolled in this course!";
        } else
        {
            output.set_name(testCourseName);
            output.set_cred_hours(testCreditHours);
            test_data_struct.add(output);
        }



        assertEquals(expected, result);
        assertEquals(1, test_data_struct.size(), 0);
    }

}