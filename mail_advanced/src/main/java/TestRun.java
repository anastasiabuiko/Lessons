import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.BeforeClass;

public class TestRun {
    private User testUserLogin = UserFactory.getWithValidCredantianals();
    private User testCreateFolder = UserFactory.getWithCreateFolder();
    private User testDeleteFolder = UserFactory.getWithCreateFolder();


    private final String wordEqualsOne ="Все проекты";
    private final String wordEqualsTwo ="Папка пока пуста";
    private final String getWordEqualsThree = "";

    @BeforeClass
    public static void setUp() {}

    @Test
    public void testLogin() throws InterruptedException {
        LoginService.LoginPage(testUserLogin);
        Thread.sleep(5000);
        Assert.assertEquals(new LoginPage().getXPH(),wordEqualsOne);
        this.Logout();
    }
    public void Logout(){
        new LoginPage().logOut();
    }

    @Test
    public void testCreateFolder() throws InterruptedException {
//        LoginService.CreateFolder(testCreateFolder);
//        Assert.assertEquals((new CreateFolderPage().getXXX()), wordEqualsTwo);
//        this.Logout();
    }

    @Test
    public void testDeleteFolder() throws InterruptedException {
//        LoginService.DeleteFolder(testDeleteFolder);
//        Assert.assertEquals(new DeleteFolderPage().isFolderNoEcxict(), getWordEqualsThree);

    }


    @AfterClass
    public static void tearDown() {
        WrappedDriver.CloseDriver();
    }

}
