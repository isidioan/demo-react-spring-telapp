package com.iioannou.taap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ioannou
 */
@Entity
@Table(name = "CALLERS")
public class Caller {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "image")
    private String image;

    @OneToMany(
            mappedBy = "caller",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Call> callContacts = new ArrayList<>();

    public Caller() {
        super();

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

    public void addCallContact(Call callContact) {
        callContact.setCaller(this);
        this.getCallContacts().add(callContact);
    }

    public void removeCallContact(Call callContact) {
        this.getCallContacts().remove(callContact);
        callContact.setCaller(null);

    }

    public List<Call> getCallContacts() {
        return callContacts;
    }
}
