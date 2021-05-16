package org.reg.model;

import org.dizitart.no2.objects.Id;

import java.util.Objects;

public class User {
    @Id
    private String username;
    private String password;
    private String role;
    private String eMail, phoneNumber, name, personalKey;

    public User(String username, String password, String role, String name, String eMail, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public User(String username, String password, String role, String name, String eMail, String phoneNumber, String personalKey) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.personalKey = personalKey;
    }

    public User() {

    }

    public String getUsername() { return username; }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPersonalKey(){ return personalKey;}

    public void setPersonalKey(){this.personalKey = personalKey;}

    public String getName() {return name;}

    public void setName() {this.name = name;}

    public String geteMail() {return eMail;}

    public void seteMail() { this.eMail = eMail;}

    public String getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber() {this.phoneNumber = phoneNumber;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(username, user.username)) return false;
        if (!Objects.equals(password, user.password)) return false;
        return true;
    }

    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}