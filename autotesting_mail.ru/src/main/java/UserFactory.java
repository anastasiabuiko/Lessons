public class UserFactory {
    public static User getWithValidCredantianals(){
        return new User()
                .withName("anastaisa.buiko19994")
                .withPassword("WorldofWarplanes1");
    }

    public static User getWithNotValidCredantianals(){
        return new User()
                .withName("anastaisa.buiko19994")
                .withPassword("false");
    }

    public static User getSendLetter(){
        return new User()
                .withName("anastaisa.buiko19994")
                .withPassword("WorldofWarplanes1")
                .withAddress("anastaisa.buiko19994@mail.ru")
                .withTheme("test")
                .withText("text");
    }

    public static User getWhithoutBody(){
        return new User()
                .withName("anastaisa.buiko19994")
                .withPassword("WorldofWarplanes1")
                .withAddress("anastaisa.buiko19994@mail.ru")
                .withTheme("");
    }

    public  static User getErrorLetter(){
        return new User()
                .withName("anastaisa.buiko19994")
                .withPassword("WorldofWarplanes1")
                .withAddress("")
                .withTheme("")
                .withText("");
    }
    public static User getDeleteLetter() {
        return new User()
                .withName("anastaisa.buiko19994")
                .withPassword("WorldofWarplanes1")
                .withAddress("anastaisa.buiko19994@mail.ru")
                .withTheme("tema")
                .withText("text text");
    }

}
