package com.happyride.rideshare.model;


import javax.persistence.*;

@Entity
@Table(name = "help_and_contact")
public class HelpAndContact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "help_and_contact_id")
    private int helpAndContactId;

    @Column(name = "location")
    private String location;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country countryId;

    public int getHelpAndContactId() {
        return helpAndContactId;
    }

    public void setHelpAndContactId(int helpAndContactId) {
        this.helpAndContactId = helpAndContactId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }
}
