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
public class BreakMsgTest {

    @Test
    public void main()
    {
        String msg = "";
        String[] break_activities = {
                "Try doing a few stretches.",
                "You should get something to drink.",
                "Take a deep breath and relax for a bit.",
                "Get up and walk for a bit. Clear your head.",
                "Go ahead and watch a YouTube video."
        };

        msg = startBreak(break_activities);
        assertNotNull(msg);
    }

    private String startBreak(String[] break_activities)
    {
        Random rand = new Random();
        int index = rand.nextInt(break_activities.length);

        return break_activities[index];
    }

}