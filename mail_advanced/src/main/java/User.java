public class User {
    private String name;
    private String password;
    private String nameFolder;

    public String getName(){
        return name;
    }

    public String getPassword(){
        return this.password;
    }

    public String getNameFolder(){
        return this.nameFolder;
    }

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public User withPassword(String password) {
        this.password = password;
        return  this;
    }

    public User withNameFolder(String nameFolder){
        this.nameFolder = nameFolder;
        return this;
    }

}
