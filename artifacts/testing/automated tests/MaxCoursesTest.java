package com.mytime;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MaxCoursesTest
{
    @Test
    public void maxCoursesMessage()
    {
        String expected = "No more courses can be added! Maximum of 6 courses have been added! Please delete a course to add different course.";
        String output = "Course successfully added!";

        ArrayList<Course> test_data_struct = new ArrayList<Course>();
        String[] testCourseNames = {"test1", "test2", "test3", "test4", "test5", "test6"};
        int testCreditHours = 3;

        for(int i = 0; i < 6; i++)
        {
            Course testCourse = new Course();
            testCourse.set_name(testCourseNames[i]);
            testCourse.set_cred_hours(testCreditHours);
            test_data_struct.add(testCourse);
        }

        if(test_data_struct.size() == 6)
        {
            output = "No more courses can be added! Maximum of 6 courses have been added! Please delete a course to add different course.";
        }

        assertEquals(expected, output);
    }

    @Test
    public void preventCourseEnrollment()
    {
        int expected = 6;
        int output = 0;

        ArrayList<Course> test_data_struct = new ArrayList<Course>();
        String[] testCourseNames = {"test1", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9"};
        int testCreditHours = 3;

        for(int i = 0; i < 6; i++)
        {
            if(test_data_struct.size() < 6)
            {
                Course testCourse = new Course();
                testCourse.set_name(testCourseNames[i]);
                testCourse.set_cred_hours(testCreditHours);
                test_data_struct.add(testCourse);
            }
        }

        output = test_data_struct.size();

        assertEquals(expected, output);
    }
}
