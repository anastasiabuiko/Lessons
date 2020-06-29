public class LoginService {

    public static void LoginPage(User user) throws InterruptedException {
        LoginPage page = new LoginPage();
        page.load();
        page.checkbox();
        page.UserName(user.getName())
                .clickLoginButton();
        page.typePassword(user.getPassword())
                .clickLoginButton();
    }

    public static void SendLetterPage(User user) throws InterruptedException{
         LoginPage(user);
         Thread.sleep(5000);
         SendLetterPage sendLetterPage= new SendLetterPage();
        Thread.sleep(5000);
         sendLetterPage.sendLetter();
         Thread.sleep(5000);
         sendLetterPage.withAddress(user.getAddress());
        Thread.sleep(5000);
         sendLetterPage.withTheme("test");
         sendLetterPage.withText("message me me");
         sendLetterPage.sendMessage();
    }

    public static void SendLetterPageTwo(User user) throws InterruptedException{
        LoginPage(user);
        Thread.sleep(5000);
        SendLetterPage sendLetterPage= new SendLetterPage();
        Thread.sleep(5000);
        sendLetterPage.sendLetter();
        Thread.sleep(5000);
        sendLetterPage.withAddress(user.getAddress());
        Thread.sleep(5000);
        sendLetterPage.withTheme("test");
        sendLetterPage.withText("message me me");
        sendLetterPage.buttonSave();
        Thread.sleep(9000);
        sendLetterPage.exit();
        Thread.sleep(5000);
        sendLetterPage.draft();
        Thread.sleep(5000);
        sendLetterPage.check();
        sendLetterPage.delete();
    }
}
