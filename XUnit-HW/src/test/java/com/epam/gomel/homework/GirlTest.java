package com.epam.gomel.homework;

import org.testng.annotations.Test;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class GirlTest extends BaseConfigurationTest{

    Girl isNoPrettyAndBecameFat;
    Girl isPrettyAndBecameFat;
    Girl isBoyFriendWillBuyNewShoes;

    Girl isBoyRich;
    Girl isNoRichBoy;
    Girl moodExcellentGirl;
    Girl moodNeutralGirl;
    Girl moodI_HATE_THEM_ALL_Girl;
    List<Girl> moodGoodGirlList;

    //
    GirlTest() {
        //girl = new Girl();
        isNoPrettyAndBecameFat = new Girl(false, true);
        isPrettyAndBecameFat = new Girl(true, true);
        isBoyRich= new Girl(true, false,  new Boy (Month.JUNE, RICH_BOY));
        isNoRichBoy= new Girl(true, false,  new Boy (Month.JUNE, POOR_BOY));
        isBoyFriendWillBuyNewShoes = new Girl(true, false,  new Boy (Month.JUNE, RICH_BOY));
        moodExcellentGirl = new Girl(true, true, new Boy(Month.JUNE, RICH_BOY) );
        moodGoodGirlList = new ArrayList<>();
        this.moodGoodGirlList();
        moodNeutralGirl = new Girl (false, true);
        moodI_HATE_THEM_ALL_Girl = new Girl (false, false, null);
    }

    void moodGoodGirlList(){
        moodGoodGirlList.add(new Girl(true, false, new Boy (Month.JUNE, POOR_BOY)));
        moodGoodGirlList.add(new Girl (false, false, new Boy (Month.JUNE, RICH_BOY)));
    }

    @Test(groups = "girl", priority = 1)
    public void isSlimFriendBecameFat(){
        assertTrue(isNoPrettyAndBecameFat.isSlimFriendBecameFat());
        assertFalse(isPrettyAndBecameFat.isSlimFriendBecameFat());
    }

    @Test (groups = "girl",priority = 2)
    public void isBoyfriendRich() {
        assertTrue(isBoyRich.isBoyfriendRich());
        assertFalse(isNoRichBoy.isBoyfriendRich());
    }

    @Test(groups = "girl",priority = 3)
    public void isBoyFriendWillBuyNewShoes(){
        assertTrue(isBoyFriendWillBuyNewShoes.isBoyFriendWillBuyNewShoes());
    }

    @Test(groups = "girl",priority = 4)
    public void spendBoyFriendMoney(){
        double wealthBeforeExpendMoney1 = isBoyRich.getBoyFriend().getWealth();
        isBoyRich.spendBoyFriendMoney(EXPEND_MONEY);
        double wealthAfterExpendMoney1 = isBoyRich.getBoyFriend().getWealth();
        assertTrue(wealthAfterExpendMoney1 < wealthBeforeExpendMoney1);

        double wealthBeforeExpendMoney2 = isNoRichBoy.getBoyFriend().getWealth();
        isNoRichBoy.spendBoyFriendMoney(EXPEND_MONEY);
        double wealthAfterExpendMoney2 = isNoRichBoy.getBoyFriend().getWealth();
        assertTrue(wealthAfterExpendMoney2==wealthBeforeExpendMoney2);
    }

    @Test (groups = "girl",priority = 5)
    public void getMood(){
        assertEquals(Mood.EXCELLENT, moodExcellentGirl.getMood());
        for (Girl moodGoodGirl: moodGoodGirlList) {
            assertEquals(Mood.GOOD, moodGoodGirl.getMood());
        }
        assertEquals(Mood.NEUTRAL, moodNeutralGirl.getMood());
        assertEquals(Mood.I_HATE_THEM_ALL, moodI_HATE_THEM_ALL_Girl.getMood());
    }


}
