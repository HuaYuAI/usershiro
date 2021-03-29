package com.yd.yx.client.vo;

import java.io.Serializable;

public class BaseRequestVO implements Serializable {

    private static final long serialVersionUID = -3218768607784726832L;

    private int deviceType;

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }
}
