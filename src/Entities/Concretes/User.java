package Entities.Concretes;

import Entities.Abstracts.Entity;

public class User implements Entity {
    private String name;
    private String surname;
    private String email;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVerify() {
        return verify;
    }

    public void setVerify(boolean verify) {
        this.verify = verify;
    }

    private boolean verify;

    public User(String name, String surname, String email, String password, boolean verify) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.verify = verify;
    }


}
