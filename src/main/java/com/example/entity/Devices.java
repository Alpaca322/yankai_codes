package com.example.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Devices {
    Long DeviceID;
    String DeviceType;
    String DeviceName;
    String Status;
    LocalDateTime LastMaintenance;
    String FirmwareVersion;
}
