package com.bona.data;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Asia on 2015-12-30.
 */
public class Spitter {

    private long id;
    @NotNull
    @Size(min=5, max=10, message="{firstName.size}")
    private String firstName;
    @NotNull
    @Size(min=5, max=10, message="{lastName.size}")
    private String lastName;
    @NotNull
    @Size(min=5, max=10, message="{userName.size}")
    private String userName;
    @NotNull
    @Size(min=3, max=10, message="{password.size}")
    private String password;

    public Spitter(){}
    public Spitter(long id, String firstName, String lastName, String userName, String password) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setUserName(userName);
        this.setPassword(password);
    }
    public Spitter(String firstName, String lastName, String userName, String password) {
        this(0l, firstName,lastName,userName,password);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object that){
        return EqualsBuilder.reflectionEquals(this, that, "id", "firstName",
                "lastName","userName","password");
    }

    @Override public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "firstName",
                "lastName", "userName", "password");
    }
}
