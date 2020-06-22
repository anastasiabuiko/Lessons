package com.epam.gomel.homework;


import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeClass;

import java.time.Month;

public class BaseConfigurationTest {

    public static final double RICH_BOY=1_000_000;
    public static final double POOR_BOY=999_999;
    public static final double EXPEND_MONEY=1_00_000;

    @BeforeClass
    public void testWorkLombok() {
        Boy boy=new Boy(Month.APRIL , 2.0, new Girl(true));
        assertEquals(boy.getWealth(),2.0);
    }
}
