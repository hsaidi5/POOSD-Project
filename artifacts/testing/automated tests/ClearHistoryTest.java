package com.mytime;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ClearHistoryTest
{
    @Test
    public void addCourse()
    {
        int expected = 0;

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

        test_data_struct.clear();

        assertEquals(expected, test_data_struct.size(), 0);
    }
}
