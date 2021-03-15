public class User {
    private String name;

    private String password;

    private String address;

    private String theme;

    private String text;

    public String getName(){
    return name;
    }

    public String getPassword(){
        return this.password;
    }

    public String getAddress(){
        return this.address;
    }
    public String getTheme(){
        return this.theme;
    }
    public String getText(){
        return this.text;
    }

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public User withAddress (String address){
        this.address = address;
        return this;
    }

    public User withPassword(String password) {
        this.password = password;
        return  this;
    }

    public User withTheme(String theme){
        this.theme = theme;
        return this;
    }

    public User withText(String text){
        this.text = text;
        return this;
    }

}
