package com.happyride.rideshare.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "vehicle_info")
public class VehicleInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_id")
    private int vehicleId;

    //@NotEmpty(message = "*Please provide your vehicle registration no.")
    @Column(name = "vehicle_no")
    private String vehicleNo;
    @Column(name = "rc_no")
    //@NotEmpty(message = "*Please provide your vehicle rc no")
    private String rcNo;
    @Column(name = "rc_no_expire_date")
    //@NotEmpty(message = "*Please provide your vehicle rc no")
    private String rcNoExpireDate;
    @Column(name = "owner_nid_no")
    private String vehicleOwnerNidNo;
    @Column(name = "vehicle_model")
    // @NotEmpty(message = "Please provide your vehicle model.")
    private String vehicleModel;
    @Column(name = "manufacture_year")
    //@NotEmpty(message = "*Please provide your vehicle manufacture year")
    private String vehicleManufacYear;
    @Column(name = "manufacture_company")
    // @NotEmpty(message = "*Please provide your vehile manufacture company.")
    private String vehicleManufacCompany;
    @Column(name = "status")
    private String status;
    @Column(name = "vehicle_type")
    private String vehicleType;


    //none are is null check it  id is null bocze it will generate automatically by data base. hello
    public String getRcNoExpireDate() {
        return rcNoExpireDate;
    }

    public void setRcNoExpireDate(String rcNoExpireDate) {
        this.rcNoExpireDate = rcNoExpireDate;
    }

    public String getVehicleOwnerNidNo() {
        return vehicleOwnerNidNo;
    }

    public void setVehicleOwnerNidNo(String vehicleOwnerNidNo) {
        this.vehicleOwnerNidNo = vehicleOwnerNidNo;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getRcNo() {
        return rcNo;
    }

    public void setRcNo(String rcNo) {
        this.rcNo = rcNo;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleManufacYear() {
        return vehicleManufacYear;
    }

    public void setVehicleManufacYear(String vehicleManufacYear) {
        this.vehicleManufacYear = vehicleManufacYear;
    }

    public String getVehicleManufacCompany() {
        return vehicleManufacCompany;
    }

    public void setVehicleManufacCompany(String vehicleManufacCompany) {
        this.vehicleManufacCompany = vehicleManufacCompany;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
