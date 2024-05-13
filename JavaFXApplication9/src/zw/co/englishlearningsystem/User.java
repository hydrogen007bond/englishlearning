package zw.co.englishlearningsystem;


public class User {
    private String username;
    private String password;
    private int age;
    private String gender;

    public User(String username, String password, int age, String gender) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}

