package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Details about the user object.")
public class User {
    private Integer id;

    @Size(min=2, message = "Name should have atleast 2 characters")
    @ApiModelProperty(notes="Name should have at least 2 characters")
    private String name;

    @Future(message = "Birthdate should be a future date")
    @ApiModelProperty(notes="Birthdate should be in the past.")
    private Date birthDate;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    @Override
    public String toString() {
        return "User [birthDate=" + birthDate + ", id=" + id + ", name=" + name + "]";
    }

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
}
