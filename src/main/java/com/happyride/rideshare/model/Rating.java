package com.happyride.rideshare.model;

import javax.persistence.*;


@Entity
@Table(name = "rating")
public class Rating {
    // This table is for base of rating for example one user have 30 ride and his average rating is 4.45 then we give him a base like platinum, gold , silver like that.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rating_id")
    private int ratingId;
    @Column(name = "rating_name")
    private String ratingName;
    @Column(name = "rating_status")
    private String ratingStatus;
    @Column(name = "rating_description")
    private String ratingDescription;

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public String getRatingName() {
        return ratingName;
    }

    public void setRatingName(String ratingName) {
        this.ratingName = ratingName;
    }

    public String getRatingStatus() {
        return ratingStatus;
    }

    public void setRatingStatus(String ratingStatus) {
        this.ratingStatus = ratingStatus;
    }

    public String getRatingDescription() {
        return ratingDescription;
    }

    public void setRatingDescription(String ratingDescription) {
        this.ratingDescription = ratingDescription;
    }
}
