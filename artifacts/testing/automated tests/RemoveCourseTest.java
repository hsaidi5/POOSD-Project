package com.mytime;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RemoveCourseTest
{
    @Test
    public void removeCourse()
    {
        ArrayList<Course> test_data_struct = new ArrayList<Course>();
        String testCourseName = "test";
        String removeCourseName = "test";
        int testCreditHours = 3;
        Course output = new Course();;
        double testTimeAvailable = 360;

        Course testCourse = new Course();
        testCourse.set_name(testCourseName);
        testCourse.set_cred_hours(testCreditHours);
        test_data_struct.add(testCourse);

        for(int i = 0; i < test_data_struct.size(); i++)
        {
            if(test_data_struct.get(i).get_name().equals(removeCourseName))
            {
                test_data_struct.remove(i);
            }
        }

        assertEquals(0, test_data_struct.size(), 0);
    }

}