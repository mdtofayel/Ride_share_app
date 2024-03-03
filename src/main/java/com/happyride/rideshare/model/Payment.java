package com.happyride.rideshare.model;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private int paymentId;
    @Column(name = "payment_type")
    private String paymentType;
    @Column(name = "payment_date")
    private Date paymentDate;
    @Column(name = "ride_cost")
    private double rideCost;
    @Column(name = "total_ride_cost")
    private double totalRideCost;
    @ManyToOne
    @JoinColumn(name = "PROMO_CODE_ID")
    private PromoCode promocCodeId;
    @ManyToOne
    @JoinColumn(name = "PRICING_ID")
    private Pricing pricingId;
    @ManyToOne
    @JoinColumn(name = "DRIVER_PROFILE_ID")
    private DriverProfile driverProfile;
    @ManyToOne
    @JoinColumn(name = "RIDER_PROFILE_ID")
    private RiderProfile riderProfile;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getRideCost() {
        return rideCost;
    }

    public void setRideCost(double rideCost) {
        this.rideCost = rideCost;
    }

    public double getTotalRideCost() {
        return totalRideCost;
    }

    public void setTotalRideCost(double totalRideCost) {
        this.totalRideCost = totalRideCost;
    }

    public PromoCode getPromocCodeId() {
        return promocCodeId;
    }

    public void setPromocCodeId(PromoCode promocCodeId) {
        this.promocCodeId = promocCodeId;
    }

    public Pricing getPricingId() {
        return pricingId;
    }

    public void setPricingId(Pricing pricingId) {
        this.pricingId = pricingId;
    }

    public DriverProfile getDriverProfile() {
        return driverProfile;
    }

    public void setDriverProfile(DriverProfile driverProfile) {
        this.driverProfile = driverProfile;
    }

    public RiderProfile getRiderProfile() {
        return riderProfile;
    }

    public void setRiderProfile(RiderProfile riderProfile) {
        this.riderProfile = riderProfile;
    }
}
