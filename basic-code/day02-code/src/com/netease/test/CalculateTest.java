package com.netease.test;

import com.netease.day03.junit.Calculate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculateTest {

    /**
     * init method is used to apply resources before all test methods;
     */
    @Before
    public void init() {
        System.out.println("init...");
    }

    /**
     * release method is used to release resources after all test methods;
     */
    @After
    public void close() {
        System.out.println("close...");
    }


    /**
     * test add method
     */
    @Test
    public void testAdd() {
        Calculate cal = new Calculate();
        int result = cal.add(1, 3);
        Assert.assertEquals(4, result);

    }


    /**
     * test sub method
     */
    @Test
    public void testSub() {
        Calculate cal = new Calculate();
        int result = cal.sub(1, 2);
        Assert.assertEquals(-1, result);
    }
}
