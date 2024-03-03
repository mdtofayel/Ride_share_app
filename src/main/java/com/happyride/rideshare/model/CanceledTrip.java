package com.happyride.rideshare.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "canceled_trip")
public class CanceledTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "date")
    private Date date;
    @OneToOne
    @JoinColumn(name = "cancel_by")
    private User cancelBy;
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private User driverId;
    @ManyToOne
    @JoinColumn(name = "rider_id")
    private User rider_id;
    @Column(name = "canceled_at")
    private Date canceledAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getCancelBy() {
        return cancelBy;
    }

    public void setCancelBy(User cancelBy) {
        this.cancelBy = cancelBy;
    }

    public User getDriverId() {
        return driverId;
    }

    public void setDriverId(User driverId) {
        this.driverId = driverId;
    }

    public User getRider_id() {
        return rider_id;
    }

    public void setRider_id(User rider_id) {
        this.rider_id = rider_id;
    }

    public Date getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(Date canceledAt) {
        this.canceledAt = canceledAt;
    }
}
