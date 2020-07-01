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
         sendLetterPage.withTheme(user.getTheme());
         sendLetterPage.withText(user.getText());
    }

    public static void SendMessage(){
        new SendLetterPage().sendMessage();
    }

    public static void SendButton(){
        new SendLetterPage().Sendbutton();
    }

    public static void SaveButton()  throws InterruptedException{
        Thread.sleep(5000);
        new SendLetterPage().SaveButton();
    }

    public static void Draft()throws InterruptedException{
        Thread.sleep(5000);
        new SendLetterPage().exit();
        new SendLetterPage().draft();
        Thread.sleep(5000);
        new SendLetterPage().check();
        new SendLetterPage().delete();
        Thread.sleep(5000);
    }

}
