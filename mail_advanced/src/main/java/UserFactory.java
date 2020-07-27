public class UserFactory {
    public static User getWithValidCredantianals(){
        return new User()
                .withName("anastaisa.buiko19994")
                .withPassword("WorldofWarplanes1");
    }
    public static User getWithCreateFolder() {
        return new User()
                .withName("anastaisa.buiko19994")
                .withPassword("WorldofWarplanes1")
                .withNameFolder("Test");
    }
}
