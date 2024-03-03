package com.happyride.rideshare.model;

import javax.persistence.*;

@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "offer_id")
    private  int offerId;
    @Column(name = "offer_name")
    private  String offerName;
    @Column(name = "offer_max_ride")
    private  int offerMaxRide;
    @Column(name = "offer_min_ride")
    private  int offerMinTime;
    @Column(name = "offer_discount")
    private  int offerDiscount;
    @Column(name = "offer_maximum_discount")
    private  int offerMaximumDicount;

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public int getOfferMaxRide() {
        return offerMaxRide;
    }

    public void setOfferMaxRide(int offerMaxRide) {
        this.offerMaxRide = offerMaxRide;
    }

    public int getOfferMinTime() {
        return offerMinTime;
    }

    public void setOfferMinTime(int offerMinTime) {
        this.offerMinTime = offerMinTime;
    }

    public int getOfferDiscount() {
        return offerDiscount;
    }

    public void setOfferDiscount(int offerDiscount) {
        this.offerDiscount = offerDiscount;
    }

    public int getOfferMaximumDicount() {
        return offerMaximumDicount;
    }

    public void setOfferMaximumDicount(int offerMaximumDicount) {
        this.offerMaximumDicount = offerMaximumDicount;
    }
}
