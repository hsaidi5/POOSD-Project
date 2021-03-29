package com.mytime;

import android.os.CountDownTimer;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BreakTimerTest {

    @Test
    public void main()
    {
        String[] break_activities = {
                "Try doing a few stretches.",
                "You should get something to drink.",
                "Take a deep breath and relax for a bit.",
                "Get up and walk for a bit. Clear your head.",
                "Go ahead and watch a YouTube video."
        };
        Random rand = new Random();
        int index = rand.nextInt(break_activities.length);

        CountDownTimer timer = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String msg = break_activities[0];
            }

            @Override
            public void onFinish() {
                String msg = break_activities[index];
                assertNotNull(msg);
            }
        };

        assertNotNull(timer);
    }
}