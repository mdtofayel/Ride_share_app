package com.happyride.rideshare.model;


import javax.persistence.*;


@Entity
@Table(name = "pricing")
public class Pricing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pricing_id")
    private int pricingId;
    @ManyToOne
    @JoinColumn(name = "STATES_ID")
    private States states;
    @Column(name = "base_price")
    private double basePrice;
    @Column(name = "pricing_city")
    private String pricingCity;
    @Column(name = "price_per_kilo")
    private double pricePerKilo;
    @Column(name = "waiting_price_per_minute")
    private double waitingPricePerMinute;
    @Column(name = "traffic_jam_price")
    private double trafficJamPrice;
    @Column(name = "pricing_note")
    private String pricingNote;
    @Column(name = "pricing_status")
    private  String pricingStatus;


    public int getPricingId() {
        return pricingId;
    }

    public void setPricingId(int pricingId) {
        this.pricingId = pricingId;
    }
    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String getPricingCity() {
        return pricingCity;
    }

    public void setPricingCity(String pricingCity) {
        this.pricingCity = pricingCity;
    }

    public double getPricePerKilo() {
        return pricePerKilo;
    }

    public void setPricePerKilo(double pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
    }

    public double getWaitingPricePerMinute() {
        return waitingPricePerMinute;
    }

    public void setWaitingPricePerMinute(double waitingPricePerMinute) {
        this.waitingPricePerMinute = waitingPricePerMinute;
    }

    public double getTrafficJamPrice() {
        return trafficJamPrice;
    }

    public void setTrafficJamPrice(double trafficJamPrice) {
        this.trafficJamPrice = trafficJamPrice;
    }

    public String getPricingNote() {
        return pricingNote;
    }

    public void setPricingNote(String pricingNote) {
        this.pricingNote = pricingNote;
    }

    public States getStates() {
        return states;
    }

    public void setStates(States states) {
        this.states = states;
    }

    public String getPricingStatus() {
        return pricingStatus;
    }

    public void setPricingStatus(String pricingStatus) {
        this.pricingStatus = pricingStatus;
    }
}
