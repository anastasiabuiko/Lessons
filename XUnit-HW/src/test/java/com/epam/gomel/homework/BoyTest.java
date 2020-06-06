package com.epam.gomel.homework;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.*;

public class BoyTest extends BaseConfigurationTest {

    List<Boy> birthdaySummerMonth;
    List<Boy> birthdayNoSummerMonth;
    Boy boyIsRichAndSummer;
    Boy boyIsPoorAndSummer;
    Boy isPrettyGirlfriend;
    Boy isNoPrettyGirlfriend;
    Boy moodGoodBoy;
    Boy moodExcellentBoy;
    Boy moodNeutralBoy;
    List<Boy> moodBadBoyList;
    List<Boy> moodHorribleList;


    BoyTest(){
        moodExcellentBoy = new Boy (Month.JUNE, RICH_BOY,new Girl(true));
        moodGoodBoy = new Boy (Month.OCTOBER, RICH_BOY,new Girl(true));
        moodNeutralBoy = new Boy (Month.JULY, RICH_BOY);
        moodBadBoyList = new ArrayList<>();
        moodHorribleList = new ArrayList<>();
        isPrettyGirlfriend = new Boy (Month.DECEMBER, RICH_BOY, new Girl(true));
        isNoPrettyGirlfriend = new Boy (Month.DECEMBER, RICH_BOY, new Girl(false));
        boyIsRichAndSummer=new Boy(Month.AUGUST,RICH_BOY);
        boyIsPoorAndSummer=new Boy(Month.AUGUST,POOR_BOY);
        birthdaySummerMonth = new ArrayList<>();
        birthdayNoSummerMonth = new ArrayList<>();
        this.ListSummerMonth();
        this.ListNoSummer();
        this.ListBadBoy();
        this.ListHorribleBoy();
    }

    void ListBadBoy (){
        moodBadBoyList.add(new Boy (Month.JUNE, POOR_BOY, new Girl (false)));
        moodBadBoyList.add(new Boy (Month.OCTOBER, RICH_BOY, new Girl (false)));
        moodBadBoyList.add(new Boy (Month.DECEMBER, POOR_BOY, new Girl (true)));
        moodBadBoyList.add(new Boy (Month.JULY));
        moodBadBoyList.add(new Boy (Month.NOVEMBER,RICH_BOY));
    }

    void ListHorribleBoy(){
        moodHorribleList.add(new Boy(Month.NOVEMBER, POOR_BOY, new Girl (false)));
        moodHorribleList.add(new Boy(Month.NOVEMBER));
        moodHorribleList.add(new Boy(Month.NOVEMBER, POOR_BOY));
    }

    void ListSummerMonth(){
        birthdaySummerMonth.add(new Boy(Month.AUGUST));
        birthdaySummerMonth.add(new Boy(Month.JUNE));
        birthdaySummerMonth.add(new Boy(Month.JULY));
    }
    void ListNoSummer (){
        birthdayNoSummerMonth.add(new Boy (Month.DECEMBER));
        birthdayNoSummerMonth.add(new Boy (Month.APRIL));
        birthdayNoSummerMonth.add(new Boy (Month.FEBRUARY));
        birthdayNoSummerMonth.add(new Boy (Month.JANUARY));
        birthdayNoSummerMonth.add(new Boy (Month.MARCH));
        birthdayNoSummerMonth.add(new Boy (Month.MAY));
        birthdayNoSummerMonth.add(new Boy (Month.NOVEMBER));
        birthdayNoSummerMonth.add(new Boy (Month.OCTOBER));
        birthdayNoSummerMonth.add(new Boy (Month.SEPTEMBER));
    }

    @Test(groups = "boy" ,priority = 1)
    public void testIsRich(){
       assertTrue(boyIsRichAndSummer.isRich());
       assertFalse(boyIsPoorAndSummer.isRich());
    }

    @Test(groups = "boy", priority = 2)
    public void isSummerMonth(){

        for (Boy boySummer:birthdaySummerMonth) {
            assertTrue(boySummer.isSummerMonth());
        }

        for (Boy boy:birthdayNoSummerMonth) {
            assertFalse(boy.isSummerMonth());
        }
    }

    @Test(groups = "boy", priority = 3)
    public void isPrettyGirlFriend(){
        assertTrue(isPrettyGirlfriend.isPrettyGirlFriend());
        assertFalse(isNoPrettyGirlfriend.isPrettyGirlFriend());
    }

    @Test(groups = "boy", priority = 4)
    public void spendSomeMoney() {

        for (double i = 0; i < RICH_BOY; i = i + EXPEND_MONEY) {
            double wealthBeforeExpendMoney = boyIsRichAndSummer.getWealth();
            boyIsRichAndSummer.spendSomeMoney(EXPEND_MONEY);
            double wealthAfterExpendMoney = boyIsRichAndSummer.getWealth();
            assertTrue(wealthAfterExpendMoney < wealthBeforeExpendMoney);
        }

        try {
            boyIsRichAndSummer.spendSomeMoney(EXPEND_MONEY);
            boyIsRichAndSummer.getWealth();
            Assert.fail("Expected IOException");
        } catch (Exception  thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }


    @Test(groups = "boy", priority = 5)
    public void getMood () {
        assertEquals(Mood.EXCELLENT, moodExcellentBoy.getMood());
        assertEquals(Mood.GOOD, moodGoodBoy.getMood());
        assertEquals(Mood.NEUTRAL, moodNeutralBoy.getMood());

        for (Boy moodBadBoy: moodBadBoyList) {
            assertEquals(Mood.BAD, moodBadBoy.getMood());
        }

        for (Boy moodHorribleBoy : moodHorribleList) {
            assertEquals(Mood.HORRIBLE, moodHorribleBoy.getMood());
        }
    }

}
