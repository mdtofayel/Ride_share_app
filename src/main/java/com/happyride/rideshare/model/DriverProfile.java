package com.happyride.rideshare.model;




import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class DriverProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "driver_profile_id")
    private int driverProfileId;
    @NotEmpty(message = "*Please provide your full name")
    @Column(name = "name")
    private String name;
    @Column(name = "active")
    private String active;
    @Column(name = "id_expired_date")
    private String idEpiredDate;
    @Column(name = "licence_expird_date")
    private String licenceExpiredDate;
    @ManyToOne
    @JoinColumn(name = "STATES_ID")
    private States states;
    @ManyToOne
    @JoinColumn(name = "CAR_INFO")
    private VehicleInfo vehicleInfo;
    @Column(name = "driver_gender")
    private String gender;
    @Column(name = "driver_address")
    private String driverAdress;
    @Column(name = "driver_rating")
    private int driverRating;
    @Column(name = "id_number")
    private String idNumber;
    @OneToOne
    @JoinColumn(name = "driver_id")
    private User driver;

    public int getDriverProfileId() {
        return driverProfileId;
    }

    public void setDriverProfileId(int driverProfileId) {
        this.driverProfileId = driverProfileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getIdEpiredDate() {
        return idEpiredDate;
    }

    public void setIdEpiredDate(String idEpiredDate) {
        this.idEpiredDate = idEpiredDate;
    }

    public String getLicenceExpiredDate() {
        return licenceExpiredDate;
    }

    public void setLicenceExpiredDate(String licenceExpiredDate) {
        this.licenceExpiredDate = licenceExpiredDate;
    }

    public String getDriverAdress() {
        return driverAdress;
    }

    public void setDriverAdress(String driverAdress) {
        this.driverAdress = driverAdress;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public States getStates() {
        return states;
    }

    public void setStates(States states) {
        this.states = states;
    }

    public VehicleInfo getVehicleInfo() {
        return vehicleInfo;
    }

    public void setVehicleInfo(VehicleInfo vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(int driverRating) {
        this.driverRating = driverRating;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User user) {
        this.driver = driver;
    }
}
