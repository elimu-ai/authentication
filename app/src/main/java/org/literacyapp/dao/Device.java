package org.literacyapp.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "DEVICE".
 */
public class Device {

    private Long id;
    private String deviceId;

    public Device() {
    }

    public Device(Long id) {
        this.id = id;
    }

    public Device(Long id, String deviceId) {
        this.id = id;
        this.deviceId = deviceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

}