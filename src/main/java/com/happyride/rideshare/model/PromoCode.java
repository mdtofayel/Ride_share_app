package com.happyride.rideshare.model;


import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "promo_code")
public class PromoCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "promo_code_id")
    private int promoCodeId;
    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;
    @Column(name = "promo_start_date")
    private Date promoStartDate;
    @Column(name = "promo_start_time")
    private Time promoStartTime;
    @Column(name = "promo_end_date")
    private Date promoEndDate;
    @Column(name = "promo_end_time")
    private Time promoEndTime;
    @Column(name = "promo_code")
    private String promoCode;
    @Column(name = "promo_description")
    private String promoDescription;
    @Column(name = "promo_code_status")
    private String  promoCodeStatus;

    public int getPromoCodeId() {
        return promoCodeId;
    }

    public void setPromoCodeId(int promoCodeId) {
        this.promoCodeId = promoCodeId;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Date getPromoStartDate() {
        return promoStartDate;
    }

    public void setPromoStartDate(Date promoStartDate) {
        this.promoStartDate = promoStartDate;
    }

    public Time getPromoStartTime() {
        return promoStartTime;
    }

    public void setPromoStartTime(Time promoStartTime) {
        this.promoStartTime = promoStartTime;
    }

    public Date getPromoEndDate() {
        return promoEndDate;
    }

    public void setPromoEndDate(Date promoEndDate) {
        this.promoEndDate = promoEndDate;
    }

    public Time getPromoEndTime() {
        return promoEndTime;
    }

    public void setPromoEndTime(Time promoEndTime) {
        this.promoEndTime = promoEndTime;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getPromoDescription() {
        return promoDescription;
    }

    public void setPromoDescription(String promoDescription) {
        this.promoDescription = promoDescription;
    }

    public String getPromoCodeStatus() {
        return promoCodeStatus;
    }

    public void setPromoCodeStatus(String promoCodeStatus) {
        this.promoCodeStatus = promoCodeStatus;
    }
}
