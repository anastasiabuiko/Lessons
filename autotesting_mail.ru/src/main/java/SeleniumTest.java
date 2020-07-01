import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTest {

    private User testUserLogin = UserFactory.getWithValidCredantianals();

    private User testNoUserLogin = UserFactory.getWithNotValidCredantianals();

    private User testSendLetter = UserFactory.getSendLetter();

    private User testWhithoutBody = UserFactory.getWhithoutBody();

    private User testErrorLetter = UserFactory.getErrorLetter();

    private User testDraft = UserFactory.getDeleteLetter();

    private final String wordEqualsOne ="Все проекты";
    private final String wordEqualsTwo ="Неверное имя или пароль";
    private final String wordEqualsThree = "Анастасия Буйко";
    private final String getWordEqualsFour = "Анастасия Буйко";
    private final String getWordEqualsFifth = "<Без темы>";
    private final String getWordEqualsSix = "У вас нет незаконченных\n" +
            "или неотправленных писем";


    @BeforeClass
    public static void setUp() {}

    @Test(priority=1)
    public void testLogin() throws InterruptedException {
        LoginService.LoginPage(testUserLogin);
        Assert.assertEquals(new LoginPage().getXPH(),wordEqualsOne);
        this.Logout();
    }

    public void Logout(){
        new LoginPage().logOut();
    }

    @Test(priority=2)
    public void testNoLogin() throws InterruptedException {
        LoginService.LoginPage(testNoUserLogin);
        Assert.assertEquals(new LoginPage().getErrorMassage(),wordEqualsTwo);
    }

    @Test(priority=3)
    public void TestSendLetter () throws InterruptedException{
        LoginService.SendLetterPage(testSendLetter);
        LoginService.SendMessage();
        Thread.sleep(5000);
        this.cresd();
        Assert.assertEquals(new SendLetterPage().Inbox(),wordEqualsThree);
        this.Logout();
    }

    public void cresd(){
        new SendLetterPage().crestClick();
    }

    @Test(priority=4)
    public void TestWhithoutBody() throws  InterruptedException{
        LoginService.SendLetterPage(testWhithoutBody);
        LoginService.SendMessage();
        LoginService.SendButton();
        this.cresd();
        Assert.assertEquals(new SendLetterPage().Error(), getWordEqualsFour);
        Thread.sleep(5000);
        this.Logout();
    }

    @Test(priority=5)
    public void TestErrorLetter() throws InterruptedException{
        LoginService.SendLetterPage((testErrorLetter));
        LoginService.SaveButton();
        Assert.assertEquals(new SendLetterPage().ErrorTwo(), getWordEqualsFifth);
        this.Logout();
    }

    @Test(priority=6)
    public void TestDelete() throws InterruptedException{
        LoginService.SendLetterPage((testDraft));
        LoginService.SaveButton();
        LoginService.Draft();
        Assert.assertEquals(new SendLetterPage().Empty(), getWordEqualsSix);
        this.Logout();
    }

    @AfterClass
    public static void tearDown() {
        WrappedDriver.CloseDriver();
    }
}
