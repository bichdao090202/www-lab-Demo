package vn.edu.iuh.fit.models;

//("A", "123", "Nguyen Van A","A@gmail.com","user")
//("B", "123", "Le Thi B","B@yahoo.com","admin")

public class User {
    private String username;
    private String pass_word;
    private String fullname;
    private String email;
    private String role;

    public User() {
    }

    public User(String username, String pass_word, String fullname, String email, String role) {
        this.username = username;
        this.pass_word = pass_word;
        this.fullname = fullname;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + username + '\'' +
                ", password='" + pass_word + '\'' +
                ", fullName='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
