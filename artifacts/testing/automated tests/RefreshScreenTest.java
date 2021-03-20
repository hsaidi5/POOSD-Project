package com.mytime;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RefreshScreenTest
{

    @Test
    public void refreshScreen()
    {
        ArrayList<Course> courses_data_struct = new ArrayList<Course>();

        Course testCourse1 = new Course();
        testCourse1.set_cred_hours(5);
        testCourse1.set_name("First Test");

        courses_data_struct.add(testCourse1);

        assertEquals(1, courses_data_struct.size());
        assertEquals("First Test", courses_data_struct.get(0).get_name());

        courses_data_struct = refresh();

        assertEquals(2, courses_data_struct.size());
        assertEquals("Test1", courses_data_struct.get(0).get_name());
        assertEquals("Test2", courses_data_struct.get(1).get_name());
        assertEquals(3, courses_data_struct.get(0).get_cred_hours(), 0);
        assertEquals(4, courses_data_struct.get(1).get_cred_hours(), 0);
    }

    private ArrayList<Course> refresh()
    {
        ArrayList<Course> courses_data_struct = new ArrayList<Course>();

        Course testCourse1 = new Course();
        Course testCourse2 = new Course();
        testCourse1.set_cred_hours(3);
        testCourse1.set_name("Test1");
        testCourse2.set_cred_hours(4);
        testCourse2.set_name("Test2");

        courses_data_struct.add(testCourse1);
        courses_data_struct.add(testCourse2);

        return courses_data_struct;
    }

}
