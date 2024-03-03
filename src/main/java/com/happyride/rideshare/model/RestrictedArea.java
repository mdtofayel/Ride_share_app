package com.happyride.rideshare.model;


import javax.persistence.*;


@Entity
@Table(name = "restrictedArea")
public class RestrictedArea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restricted_area_id")
    private int id;
    @Column(name = "restricted_area_name")
    private String restrictedAreaName;
    @Column(name = "restricted_area_city")
    private String restrictedAreaCity;
    @ManyToOne
    @JoinColumn(name = "STATES_ID")
    private States statesId;
    @Column(name = "restricted_area_note")
    private String restrictedAreaNote;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRestrictedAreaName() {
        return restrictedAreaName;
    }

    public void setRestrictedAreaName(String restrictedAreaName) {
        this.restrictedAreaName = restrictedAreaName;
    }

    public String getRestrictedAreaCity() {
        return restrictedAreaCity;
    }

    public void setRestrictedAreaCity(String restrictedAreaCity) {
        this.restrictedAreaCity = restrictedAreaCity;
    }

    public States getStatesId() {
        return statesId;
    }

    public void setStatesId(States statesId) {
        this.statesId = statesId;
    }

    public String getRestrictedAreaNote() {
        return restrictedAreaNote;
    }

    public void setRestrictedAreaNote(String restrictedAreaNote) {
        this.restrictedAreaNote = restrictedAreaNote;
    }
}
