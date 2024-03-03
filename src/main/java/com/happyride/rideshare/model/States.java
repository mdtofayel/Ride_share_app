package com.happyride.rideshare.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "states")

public class States {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "states_id")
    private int statesId;
    @NotEmpty
    @Column(name = "states_name")
    private String statesName;
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;



    public int getStatesId() {
        return statesId;
    }

    public void setStatesId(int statesId) {
        this.statesId = statesId;
    }

    public String getStatesName() {
        return statesName;
    }

    public void setStatesName(String statesName) {
        this.statesName = statesName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
