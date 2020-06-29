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
                .withAddress("anastaisa.buiko19994@mail.ru");
    }

    public static User getErrorLetter(){
        return new User()
                .withName("anastaisa.buiko19994")
                .withPassword("WorldofWarplanes1")
                .withAddress("");
    }

    public  static User getErrorLetterTwo(){
        return new User()
                .withName("anastaisa.buiko19994")
                .withPassword("WorldofWarplanes1")
                .withAddress("anastaisa.buiko19994@mail.ru")
                .withTheme("")
                .withText("");
    }
    public static User getDeleteLetter() {
        return new User()
                .withName("anastaisa.buiko19994")
                .withPassword("WorldofWarplanes1")
                .withAddress("anastaisa.buiko19994@mail.ru");
    }

}
