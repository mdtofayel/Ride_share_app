package com.happyride.rideshare.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trip_id")
    private long tripId;

    @Column(name = "start_longitude")
    private double startLongitude;

    @Column(name = "start_latitude")
    private double startLatitude;

    @Column(name = "end_longitude")
    private double endLongitude;

    @Column(name = "end_latitude")
    private double endLatitude;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "trip_date")
    private Date tripDate;

    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "trip_start_time")
    private String tripStartTime;

    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "trip_end_time")
    private String tripEndTime;

    @Column(name = "trip_waiting_time")
    private String tripWaitingTime;

    @Column(name = "trip_traffic_time")
    private String tripTrafficTime;

    @Column(name = "trip_status")
    private String TripStatus;

    @Column(name = "trip_distance")
    private double tripDistance;

    @Column(name = "driver_rating")
    private double driverRating;

    @Column(name = "rider_rating")
    private double riderRating;

    @ManyToOne
    @JoinColumn(name = "PROMO_CODE_ID")
    private PromoCode promoCodeId;

    @ManyToOne
    @JoinColumn(name = "PRICING_ID")
    private Pricing pricingId;

    @ManyToOne
    @JoinColumn(name = "driver_profile_id")
    private DriverProfile  driverProfile;

    @ManyToOne
    @JoinColumn(name = "RIDER_PROFILE_ID")
    private RiderProfile riderProfile;

    public long getTripId() {
        return tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = tripId;
    }

    public double getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(double startLongitude) {
        this.startLongitude = startLongitude;
    }

    public double getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(double startLatitude) {
        this.startLatitude = startLatitude;
    }

    public double getEndLongitude() {
        return endLongitude;
    }

    public void setEndLongitude(double endLongitude) {
        this.endLongitude = endLongitude;
    }

    public double getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(double endLatitude) {
        this.endLatitude = endLatitude;
    }

    public Date getTripDate() {
        return tripDate;
    }

    public void setTripDate(Date tripDate) {
        this.tripDate = tripDate;
    }

    public String getTripStartTime() {
        return tripStartTime;
    }

    public void setTripStartTime(String tripStartTime) {
        this.tripStartTime = tripStartTime;
    }

    public String getTripEndTime() {
        return tripEndTime;
    }

    public void setTripEndTime(String tripEndTime) {
        this.tripEndTime = tripEndTime;
    }

    public String getTripWaitingTime() {
        return tripWaitingTime;
    }

    public void setTripWaitingTime(String tripWaitingTime) {
        this.tripWaitingTime = tripWaitingTime;
    }

    public String getTripTrafficTime() {
        return tripTrafficTime;
    }

    public void setTripTrafficTime(String tripTrafficTime) {
        this.tripTrafficTime = tripTrafficTime;
    }

    public String getTripStatus() {
        return TripStatus;
    }

    public void setTripStatus(String tripStatus) {
        TripStatus = tripStatus;
    }

    public double getTripDistance() {
        return tripDistance;
    }

    public void setTripDistance(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    public double getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(double driverRating) {
        this.driverRating = driverRating;
    }

    public double getRiderRating() {
        return riderRating;
    }

    public void setRiderRating(double riderRating) {
        this.riderRating = riderRating;
    }

    public PromoCode getPromoCodeId() {
        return promoCodeId;
    }

    public void setPromoCodeId(PromoCode promoCodeId) {
        this.promoCodeId = promoCodeId;
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
