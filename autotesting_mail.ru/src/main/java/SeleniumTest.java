import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SeleniumTest {

    private User testUserLogin = UserFactory.getWithValidCredantianals();

    private User testNoUserLogin = UserFactory.getWithNotValidCredantianals();

    private User testSendLetter = UserFactory.getSendLetter();

    private User testErrorLetter = UserFactory.getErrorLetter();

    private User testErrorLetterTwo = UserFactory.getErrorLetterTwo();

    private User testDraft = UserFactory.getDeleteLetter();

    private final String wordEqualsOne ="Все проекты";
    private final String wordEqualsTwo ="Неверное имя или пароль";
    private final String wordEqualsThree = "Анастасия Буйко";
    private final String getWordEqualsFour = "Не указан адрес получателя";
    private final String getWordEqualsFifth = "Без темы";
    private final String getWordEqualsSix = "У вас нет незаконченных или неотправленных писем";


    @BeforeClass
    public static void setUp() {}

    @Test
    public void testLogin() throws InterruptedException {
        LoginService.LoginPage(testUserLogin);
        Assert.assertEquals(new LoginPage().getXPH(),wordEqualsOne);
        this.Logout();
    }

    public void Logout(){
        new LoginPage().logOut();
    }

    @Test
    public void testNoLogin() throws InterruptedException {
        LoginService.LoginPage(testNoUserLogin);
        Assert.assertEquals(new LoginPage().getErrorMassage(),wordEqualsTwo);
    }

    @Test
    public void TestSendLetter () throws InterruptedException{
        LoginService.SendLetterPage(testSendLetter);
        Thread.sleep(5000);
        this.cresd();
       Assert.assertEquals(new SendLetterPage().Inbox(),wordEqualsThree);
    }

    public void cresd(){
        new SendLetterPage().crestClick();
    }

    @Test
    public void TestErrorLetter() throws  InterruptedException{
        LoginService.SendLetterPage(testErrorLetter);
        Assert.assertEquals(new SendLetterPage().Error(), getWordEqualsFour);
        Thread.sleep(5000);
    }

    @Test
    public void TestErrorLetterTwo() throws InterruptedException{
        LoginService.SendLetterPage((testErrorLetterTwo));
        this.cresd();
        Assert.assertEquals(new SendLetterPage().ErrorTwo(), getWordEqualsFifth);

    }

    @Test
    public void TestDelete() throws InterruptedException{
        LoginService.SendLetterPage((testDraft));
        this.cresd();
        Assert.assertEquals(new SendLetterPage().Empty(), getWordEqualsSix);

    }

    @AfterClass
    public static void tearDown() {
        WrappedDriver.CloseDriver();
    }
}
