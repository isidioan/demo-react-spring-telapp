package com.iioannou.taap.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iioannou.taap.entity.Call;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ioannou
 */
public class CallerD implements Serializable {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("image")
    private String image;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Call> callContacts = new ArrayList<>();

    public CallerD() {
        super();
    }

    public CallerD(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public CallerD(Long id, String firstName, String lastName, String image, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Call> getCallContacts() {
        return callContacts;
    }

    public void setCallContacts(List<Call> callContacts) {
        this.callContacts = callContacts;
    }
}
