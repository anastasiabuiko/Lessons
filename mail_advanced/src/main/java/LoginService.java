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
    public static void CreateFolder(User user) throws InterruptedException {
        LoginPage(user);
        Thread.sleep(5000);
        CreateFolderPage сreateFolder = new CreateFolderPage();
        Thread.sleep(10000);
        сreateFolder.clickCloud();
        Thread.sleep(5000);
        сreateFolder.frame();
         Thread.sleep(1000000);
//        сreateFolder.close();
//        Thread.sleep(50000);
//        сreateFolder.clickFolder();
//        Thread.sleep(5000);
//        сreateFolder.addFolder();
//        Thread.sleep(5000);
//        сreateFolder.createFolder();
    }

    public static void DeleteFolder(User user) throws InterruptedException {
        LoginPage(user);
        Thread.sleep(5000);
        DeleteFolderPage deleteFolder = new DeleteFolderPage();
        CreateFolderPage сreateFolder = new CreateFolderPage();
        //сreateFolder.nav();
        Thread.sleep(5000);
        deleteFolder.clickDeleteFolder();
        Thread.sleep(5000);
       // deleteFolder.delete();
        //Thread.sleep(5000);
        //deleteFolder.deletebutton();
    }
}
