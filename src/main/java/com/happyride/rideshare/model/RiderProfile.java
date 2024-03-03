package com.happyride.rideshare.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;


@Entity
public class RiderProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rider_profile_id")
    private long riderProfileId;

    @NotEmpty(message = "*Please provide your full name")
    @Column(name = "rider_full_name")
    private String riderFullname;

    @ManyToOne
    @JoinColumn(name = "states_id")
    private States states;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rider_pricing_id")
    private Pricing riderPricingId;
    @Column(name = "rider_rating")
    private double riderRating;
    @Column(name = "rider")
    private String riderAddress;
    @Column(name = "gender")
    private String gender;
    @Column(name = "work_place_name")
    private String workPlaceName;

    @Column(name = "work_place_longitude")
    private Double workPlaceLongitude;

    @Column(name = "work_place_latitude")
    private Double WorkPlaceLatitude;
    @Column(name = "home_place_name")
    private String homeplaceName;
    @Column(name = "home_place_longitude")
    private Double homePlaceLongitude;
    @Column(name = "home_place_latitude")
    private Double homePlaceLatitude;
    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "update_at")
    private Date updateAt;
    @Column(name = "status")
    private String status;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getRiderProfileId() {
        return riderProfileId;
    }

    public void setRiderProfileId(long riderProfileId) {
        this.riderProfileId = riderProfileId;
    }

    public String getRiderFullname() {
        return riderFullname;
    }

    public void setRiderFullname(String riderFullname) {
        this.riderFullname = riderFullname;
    }

    public States getStates() {
        return states;
    }

    public void setStates(States states) {
        this.states = states;
    }

    public Pricing getRiderPricingId() {
        return riderPricingId;
    }

    public void setRiderPricingId(Pricing riderPricingId) {
        this.riderPricingId = riderPricingId;
    }

    public double getRiderRating() {
        return riderRating;
    }

    public void setRiderRating(double riderRating) {
        this.riderRating = riderRating;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWorkPlaceName() {
        return workPlaceName;
    }

    public void setWorkPlaceName(String workPlaceName) {
        this.workPlaceName = workPlaceName;
    }

    public Double getWorkPlaceLongitude() {
        return workPlaceLongitude;
    }

    public void setWorkPlaceLongitude(Double workPlaceLongitude) {
        this.workPlaceLongitude = workPlaceLongitude;
    }

    public Double getWorkPlaceLatitude() {
        return WorkPlaceLatitude;
    }

    public void setWorkPlaceLatitude(Double workPlaceLatitude) {
        WorkPlaceLatitude = workPlaceLatitude;
    }

    public String getHomeplaceName() {
        return homeplaceName;
    }

    public void setHomeplaceName(String homeplaceName) {
        this.homeplaceName = homeplaceName;
    }

    public Double getHomePlaceLongitude() {
        return homePlaceLongitude;
    }

    public void setHomePlaceLongitude(Double homePlaceLongitude) {
        this.homePlaceLongitude = homePlaceLongitude;
    }

    public Double getHomePlaceLatitude() {
        return homePlaceLatitude;
    }

    public void setHomePlaceLatitude(Double homePlaceLatitude) {
        this.homePlaceLatitude = homePlaceLatitude;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

}
