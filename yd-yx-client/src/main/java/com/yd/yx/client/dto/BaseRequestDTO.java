package com.yd.yx.client.dto;

import java.io.Serializable;

public class BaseRequestDTO implements Serializable {

    private static final long serialVersionUID = -6798990512217093624L;
    private int deviceType;

    public BaseRequestDTO() {
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }
}
